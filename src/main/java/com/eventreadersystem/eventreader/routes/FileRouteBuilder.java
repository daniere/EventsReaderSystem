package com.eventreadersystem.eventreader.routes;
import java.io.FileInputStream;
import java.util.List;
import java.util.Optional;
import java.util.Properties;
import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.apache.camel.support.DefaultMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.eventreadersystem.eventreader.Model.Events;
import com.eventreadersystem.eventreader.Model.Products;
import com.eventreadersystem.eventreader.Model.Request;
import com.eventreadersystem.eventreader.Model.RequestDetails;
import com.eventreadersystem.eventreader.service.EventService;
import com.eventreadersystem.eventreader.service.RequestDetailsService;
import com.eventreadersystem.eventreader.service.RequestService;


@Component
public class FileRouteBuilder extends RouteBuilder
{
	@Autowired
	private RequestService        requestService;
	@Autowired
	private RequestDetailsService requestDetailService;
	@Autowired
	private EventService          eventService;
	Properties                    property = new Properties();

	@Override
	public void configure() throws Exception
	{
		property.load(new FileInputStream("./userinput.properties"));
		restConfiguration()
				.component("servlet")
				.bindingMode(RestBindingMode.json);
		rest()
				.get("/requests").to("direct:get-all-requests")
				.get("/requests/insureid/{insuredId}").to("direct:get-events-insuredId")
				.get("/requests/{sourceCompany}").to("direct:get-source-company");
		from("file:" + property.getProperty("file_path")
				+ "?delay=" + property.getProperty("duration")
				+ "000&noop=true&idempotent=false&antInclude=*.xml,*.XML")
						.unmarshal()
						.jacksonxml(Request.class)
						.process(this::saveWeatherData);
		from("direct:get-all-requests")
				.process(this::getAllRequests);
		from("direct:get-events-insuredId")
				.process(this::getInsuredId);
		from("direct:get-source-company")
				.process(this::getSrcComp);
	}

	private void saveWeatherData(Exchange exchange)
	{
		try
		{
			Request        req       = exchange.getMessage().getBody(Request.class);
			RequestDetails reqDeatil = req.getRequestDetails();
			List<Events>   event     = req.getEvents();
			requestService.save(req);
			requestDetailService.addRequestDetail(reqDeatil);
			eventService.saveAll(event);
			log.info("Added to database ");
		}
		catch (Exception e)
		{
			log.error("Error While Saving. ", e);
			exchange.getIn().setHeader(Exchange.HTTP_RESPONSE_CODE, 500);
		}
	}

	private List<Products> getInsuredId(Exchange exchange)
	{
		List<Products> proList;
		Long           id = exchange.getMessage().getHeader("insuredId", Long.class);
		proList = eventService.getOptionalProductsByinsuredId(id);
		Message message = new DefaultMessage(exchange.getContext());
		message.setBody(proList);
		exchange.setMessage(message);
		return proList;
	}

	private List<Request> getAllRequests(Exchange exchange)
	{
		List<Request> temp    = requestService.getAllRequests();
		Message       message = new DefaultMessage(exchange.getContext());
		message.setBody(temp);
		exchange.setMessage(message);
		return temp;
	}

	private Optional<RequestDetails> getSrcComp(Exchange exchange)
	{
		Optional<RequestDetails> temp;
		String                   id = exchange.getMessage().getHeader("sourceCompany", String.class);
		temp = requestDetailService.getCustomer(id);
		Message message = new DefaultMessage(exchange.getContext());
		if(temp.isPresent())
			message.setBody(temp.get());
		else
		{
			message.setBody(temp);
		}
		exchange.setMessage(message);
		return temp;
	}
}
