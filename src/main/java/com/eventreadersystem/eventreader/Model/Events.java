package com.eventreadersystem.eventreader.Model;
import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Events implements Serializable
{
	/**
	 * 
	 */
	private static final long   serialVersionUID = 1L;
	@Id
	private String              id;
	private String              type;
	private Long                insuredId;
	@Column(length = 100000)
	private ArrayList<Products> products;

	public Events()
	{
	}

	public Events(String id,String type,Long insuredId,ArrayList<Products> products)
	{
		super();
		this.id = id;
		this.type = type;
		this.insuredId = insuredId;
		this.products = products;
	}

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getType()
	{
		return type;
	}

	public void setType(String type)
	{
		this.type = type;
	}

	public Long getInsuredId()
	{
		return insuredId;
	}

	public void setInsuredId(Long insuredId)
	{
		this.insuredId = insuredId;
	}

	public ArrayList<Products> getProducts()
	{
		return products;
	}

	public void setProduct(ArrayList<Products> products)
	{
		this.products = products;
	}
}
