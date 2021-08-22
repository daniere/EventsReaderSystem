package com.eventreadersystem.eventreader.service;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.eventreadersystem.eventreader.Model.Request;
import com.eventreadersystem.eventreader.respository.RequestRepository;


@Service
public class RequestService
{
	@Autowired
	private RequestRepository requestRepo;

	public void save(Request request)
	{
		requestRepo.save(request);
	}

	public List<Request> getAllRequests()
	{
		List<Request> customers = new ArrayList<>();
		requestRepo.findAll().forEach(customers::add);
		return customers;
	}
}
