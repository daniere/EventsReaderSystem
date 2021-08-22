package com.eventreadersystem.eventreader.Model;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class RequestDetails implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String            id;
	private String            acceptDate;
	@Id
	private String            sourceCompany;

	public RequestDetails()
	{
	}

	public RequestDetails(String id,String acceptDate,String sourceCompany)
	{
		super();
		this.id = id;
		this.acceptDate = acceptDate;
		this.sourceCompany = sourceCompany;
	}

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getAcceptDate()
	{
		return acceptDate;
	}

	public void setAcceptDate(String acceptDate)
	{
		this.acceptDate = acceptDate;
	}

	public String getSourceCompany()
	{
		return sourceCompany;
	}

	public void setSourceCompany(String sourceCompany)
	{
		this.sourceCompany = sourceCompany;
	}
}
