package com.eventreadersystem.eventreader.service;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.eventreadersystem.eventreader.Model.RequestDetails;
import com.eventreadersystem.eventreader.respository.RequestDetailsRepository;


@Service
public class RequestDetailsService
{
	@Autowired
	private RequestDetailsRepository requestDetails;

	public Optional<RequestDetails> getCustomer(String sourceCompany)
	{
		return requestDetails.findById(sourceCompany);
	}

	public void addRequestDetail(RequestDetails requestD)
	{
		requestDetails.save(requestD);
	}
}
