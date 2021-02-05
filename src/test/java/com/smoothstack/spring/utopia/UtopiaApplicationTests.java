package com.smoothstack.spring.utopia;

import com.smoothstack.spring.utopia.controller.AirplaneController;
import com.smoothstack.spring.utopia.controller.AirportController;
import com.smoothstack.spring.utopia.controller.FlightController;
import com.smoothstack.spring.utopia.dto.AirplaneDto;
import com.smoothstack.spring.utopia.dto.AirportDto;
import com.smoothstack.spring.utopia.dto.FlightDto;
import com.smoothstack.spring.utopia.entity.Airplane;
import com.smoothstack.spring.utopia.entity.Airport;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = UtopiaApplication.class)

class UtopiaApplicationTests {

	@Autowired
	private AirportController airportController;

	@Autowired
	private AirplaneController airplaneController;

	@Autowired
	private FlightController flightController;

	@Test
	public void testCreateFlight()
	{
		AirportDto airportDto = new AirportDto();
		airportDto.setCity("San Diego");
		airportDto.setIataId(120L);

		AirportDto airportDto1 = new AirportDto();
		airportDto1.setCity("Los Angeles");
		airportDto1.setIataId(125L);

		AirplaneDto airplaneDto = new AirplaneDto();
		airplaneDto.setMaxCapacity(100);

		airportController.createAirport(airportDto);
		airportController.createAirport(airportDto1);
		airplaneController.createAirplane(airplaneDto);

		FlightDto flightDto = new FlightDto();
		flightDto.setOriginId(airportDto.getId());
		flightDto.setDestinationId(airportDto1.getId());
		flightDto.setAirplaneId(airplaneDto.getId());
		flightDto.setFilledSeats(50);

		flightController.createFlight(flightDto);
	}

}
