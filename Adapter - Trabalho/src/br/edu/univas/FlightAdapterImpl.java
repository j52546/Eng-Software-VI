package br.edu.univas;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class FlightAdapterImpl implements FlightAdapter {
	
	private FlightDAO flightDAO;
	
	public FlightAdapterImpl(FlightDAO flightDAO) {
		this.flightDAO = flightDAO;
	}

	@Override
	public List<Flight> getAll() {
		List<Flight> flights = new ArrayList<Flight>();
		for(Flight flight : flightDAO.getAll()) {
			Flight newFlight = new Flight();
			newFlight.setFrom(flight.getFrom());
			newFlight.setTo(flight.getTo());
			newFlight.setCompany(flight.getCompany());
			newFlight.setDeparture(convertToTimeLosAngeles(flight.getDeparture()));
			newFlight.setArrival(convertToTimeLosAngeles(flight.getArrival()));	
			flights.add(newFlight);
		}
		return flights;
	}
	
	private ZonedDateTime convertToTimeLosAngeles(ZonedDateTime time) {
        ZoneId utcZoneID = ZoneId.of("America/Los_Angeles");
        LocalDateTime ldt = time.toLocalDateTime();
        return ldt.atZone(utcZoneID);
	}

	
}
