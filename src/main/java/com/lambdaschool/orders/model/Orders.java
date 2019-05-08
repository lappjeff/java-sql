package com.lambdaschool.orders.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Orders
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long ordnum;

	private double ordamount;
	private double advanceamount;
	private String orddescription;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "custcode", nullable = false)
	@JsonIgnoreProperties({"agent", "customer_orders"})
	private Customers customer;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "agentcode", nullable = false)
	@JsonIgnoreProperties({"customers", "agent_orders"})
	private Agents agent;

	public Orders()
	{
	}

	public Orders(double ordamount, double advanceamount, Customers customer, Agents agent, String orddescription)
	{
		this.ordamount = ordamount;
		this.advanceamount = advanceamount;
		this.customer = customer;
		this.agent = agent;
		this.orddescription = orddescription;

	}

	public long getOrdnum()
	{
		return ordnum;
	}

	public void setOrdnum(long ordnum)
	{
		this.ordnum = ordnum;
	}

	public double getOrdamount()
	{
		return ordamount;
	}

	public void setOrdamount(double ordamount)
	{
		this.ordamount = ordamount;
	}

	public double getAdvanceamount()
	{
		return advanceamount;
	}

	public void setAdvanceamount(double advanceamount)
	{
		this.advanceamount = advanceamount;
	}

	public String getOrddescription()
	{
		return orddescription;
	}

	public void setOrddescription(String orddescription)
	{
		this.orddescription = orddescription;
	}

	public Customers getCustcode()
	{
		return customer;
	}

	public void setCustcode(Customers customer)
	{
		this.customer = customer;
	}

	public Agents getAgentcode()
	{
		return agent;
	}

	public void setAgentcode(Agents agent)
	{
		this.agent = agent;
	}
}
