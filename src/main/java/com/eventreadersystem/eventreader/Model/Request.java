package com.eventreadersystem.eventreader.Model;
import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Request implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private RequestDetails    requestDetails;
	@Column(length = 100000)
	private ArrayList<Events> events;

	public Request()
	{
	}

	public Request(RequestDetails requestDetails,ArrayList<Events> events)
	{
		super();
		this.requestDetails = requestDetails;
		this.events = events;
	}

	public RequestDetails getRequestDetails()
	{
		return requestDetails;
	}

	public void setRequestDetails(RequestDetails requestDetails)
	{
		this.requestDetails = requestDetails;
	}

	public ArrayList<Events> getEvents()
	{
		return events;
	}

	public void setEvents(ArrayList<Events> events)
	{
		this.events = events;
	}
}
