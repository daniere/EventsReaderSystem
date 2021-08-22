package com.eventreadersystem.eventreader.Model;
import java.io.Serializable;


public class Products implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String            type;
	private int               price;
	private String            startDate;
	private String            endDate;

	public Products()
	{
	}

	public Products(String type,int price,String startDate,String endDate)
	{
		super();
		this.type = type;
		this.price = price;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public String getType()
	{
		return type;
	}

	public void setType(String type)
	{
		this.type = type;
	}

	public int getPrice()
	{
		return price;
	}

	public void setPrice(int price)
	{
		this.price = price;
	}

	public String getStartDate()
	{
		return startDate;
	}

	public void setStartDate(String startDate)
	{
		this.startDate = startDate;
	}

	public String getEndDate()
	{
		return endDate;
	}

	public void setEndDate(String endDate)
	{
		this.endDate = endDate;
	}
}
