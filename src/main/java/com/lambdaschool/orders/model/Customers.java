package com.lambdaschool.orders.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="customer")
public class Customers
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long custcode;

	@Column(nullable = false)
	private String custname;

	private String custcity;
	private String workingarea;
	private String custcountry;
	private String grade;
	private double openingamt;
	private double receiveamt;
	private double outstandingamt;
	private double paymentamt;
	private String phone;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "agentcode", nullable = false)
	@JsonIgnoreProperties({"customers", "agent_orders", "hibernateLazyInitializer"})
	private Agents agent;


	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnoreProperties({"customer", "agent", "hibernateLazyInitialiaer"})
	private List<Orders> customer_orders = new ArrayList<>();

	public Customers()
	{
	}

	public Customers(String custname, String custcity, String workingarea, String custcountry, String grade,
					 double openingamt, double receiveamt, double outstandingamt, double paymentamt, String phone,
					 Agents agent)
	{
		this.custname = custname;
		this.custcity = custcity;
		this.workingarea = workingarea;
		this.custcountry = custcountry;
		this.grade = grade;
		this.openingamt = openingamt;
		this.receiveamt = receiveamt;
		this.outstandingamt = outstandingamt;
		this.paymentamt = paymentamt;
		this.phone = phone;
		this.agent = agent;
	}

	public List<Orders> getOrders()
	{
		return customer_orders;
	}

	public void setOrders(List<Orders> customer_orders)
	{
		this.customer_orders = customer_orders;
	}

	public double getPaymentamt()
	{
		return paymentamt;
	}

	public void setPaymentamt(double paymentamt)
	{
		this.paymentamt = paymentamt;
	}

	public long getCustcode()
	{
		return custcode;
	}

	public void setCustcode(long custcode)
	{
		this.custcode = custcode;
	}

	public String getCustname()
	{
		return custname;
	}

	public void setCustname(String custname)
	{
		this.custname = custname;
	}

	public String getCustcity()
	{
		return custcity;
	}

	public void setCustcity(String custcity)
	{
		this.custcity = custcity;
	}

	public String getWorkingarea()
	{
		return workingarea;
	}

	public void setWorkingarea(String workingarea)
	{
		this.workingarea = workingarea;
	}

	public String getCustcountry()
	{
		return custcountry;
	}

	public void setCustcountry(String custcountry)
	{
		this.custcountry = custcountry;
	}

	public String getGrade()
	{
		return grade;
	}

	public void setGrade(String grade)
	{
		this.grade = grade;
	}

	public double getOpeningamt()
	{
		return openingamt;
	}

	public void setOpeningamt(double openingamt)
	{
		this.openingamt = openingamt;
	}

	public double getReceiveamt()
	{
		return receiveamt;
	}

	public void setReceiveamt(double receiveamt)
	{
		this.receiveamt = receiveamt;
	}

	public double getOutstandingamt()
	{
		return outstandingamt;
	}

	public void setOutstandingamt(double outstandingamt)
	{
		this.outstandingamt = outstandingamt;
	}

	public String getPhone()
	{
		return phone;
	}

	public void setPhone(String phone)
	{
		this.phone = phone;
	}

	public Agents getAgent()
	{
		return agent;
	}

	public void setAgent(Agents agent)
	{
		this.agent = agent;
	}
}
