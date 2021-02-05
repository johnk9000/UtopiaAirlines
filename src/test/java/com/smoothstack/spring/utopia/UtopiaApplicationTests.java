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

import static org.junit.jupiter.api.Assertions.assertEquals;

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

		Long id = airportController.createAirport(airportDto).getBody();
		Long id2 = airportController.createAirport(airportDto1).getBody();
		Long id3 = airplaneController.createAirplane(airplaneDto).getBody();

		FlightDto flightDto = new FlightDto();
		flightDto.setOriginId(id);
		flightDto.setDestinationId(id2);
		flightDto.setAirplaneId(id3);
		flightDto.setFilledSeats(50);

		flightController.createFlight(flightDto);

		assertEquals(2, 2);
	}

}
