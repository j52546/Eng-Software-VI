package br.edu.univas;

import java.time.ZonedDateTime;

public class Flight {

	private String from;
	private String to;
	private String company;
	private ZonedDateTime departure;
	private ZonedDateTime arrival;

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public ZonedDateTime getDeparture() {
		return departure;
	}

	public void setDeparture(ZonedDateTime departure) {
		this.departure = departure;
	}

	public ZonedDateTime getArrival() {
		return arrival;
	}

	public void setArrival(ZonedDateTime arrival) {
		this.arrival = arrival;
	}
	
	@Override
	public String toString() {
		StringBuffer out = new StringBuffer();
		out.append("From: ").append(from);
		out.append("\nTo: ").append(to);
		out.append("\nCompany: ").append(company);
		out.append("\nDeparture: ").append(departure);
		out.append("\nArrival: ").append(arrival);
		out.append("\n");
		return out.toString();
	}
}
