package lambda.javasql.model;

import javax.persistence.*;

@Entity
@Table(name = "order")
public class Order
{
	@Id
	@GeneratedValue
	@Column(nullable = false)
	private long ordnum;

	private double ordamount;
	private double advanceamount;
	private String orddescription;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customercode", nullable = false)
	private long custcode;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "agentcode", nullable = false)
	private long agentcode;

	public Order()
	{
	}

	public Order(double ordamount, double advanceamount, String orddescription, long custcode, long agentcode)
	{
		this.ordamount = ordamount;
		this.advanceamount = advanceamount;
		this.orddescription = orddescription;
		this.custcode = custcode;
		this.agentcode = agentcode;
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

	public long getCustcode()
	{
		return custcode;
	}

	public void setCustcode(long custcode)
	{
		this.custcode = custcode;
	}

	public long getAgentcode()
	{
		return agentcode;
	}

	public void setAgentcode(long agentcode)
	{
		this.agentcode = agentcode;
	}
}
