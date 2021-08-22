package com.eventreadersystem.eventreader.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.eventreadersystem.eventreader.Model.Events;
import com.eventreadersystem.eventreader.Model.Products;
import com.eventreadersystem.eventreader.respository.EventRespository;


@Service
public class EventService
{
	@Autowired
	private EventRespository eventRepo;

	public List<Products> getOptionalProductsByinsuredId(Long id)
	{
		List<Events>   events = new ArrayList<>();
		List<Products> temp   = new ArrayList<>();
		eventRepo.findAll().forEach(events::add);
		for(int i = 0; i < events.size(); i++)
		{
			if(events.get(i).getInsuredId().equals(id))
			{
				for(int j = 0; j < events.get(i).getProducts().size(); j++)
				{
					temp.add(events.get(i).getProducts().get(j));
				}
			}
		}
		return temp;
	}

	public Optional<Events> getOptionalByinsuredId(Long id)
	{
		Optional<Events> temp_event;
		List<Events>     events = new ArrayList<>();
		List<Events>     temp   = new ArrayList<>();
		eventRepo.findAll().forEach(events::add);
		for(int i = 0; i < events.size(); i++)
		{
			if(events.get(i).getInsuredId().equals(id))
			{
				temp.add(events.get(i));
			}
		}
		temp_event = temp.stream().findFirst();
		return temp_event;
	}

	public void saveAll(List<Events> events)
	{
		eventRepo.saveAll(events);
	}
}
