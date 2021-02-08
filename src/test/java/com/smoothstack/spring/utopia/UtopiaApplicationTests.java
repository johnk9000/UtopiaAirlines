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
import org.springframework.http.ResponseEntity;

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
	public void testCreateUpdateDeleteFlight()
	{
		AirportDto airportDto = new AirportDto();
		airportDto.setCity("San Diego");
		airportDto.setIataId("SAN");

		AirportDto airportDto1 = new AirportDto();
		airportDto1.setCity("Los Angeles");
		airportDto1.setIataId("LAX");

		AirplaneDto airplaneDto = new AirplaneDto();
		airplaneDto.setMaxCapacity(100);

		ResponseEntity<Long> response = airportController.createAirport(airportDto);
		assertEquals(201, response.getStatusCodeValue());

		ResponseEntity<Long> response2 = airportController.createAirport(airportDto1);
		assertEquals(201, response2.getStatusCodeValue());

		ResponseEntity<Long> response3 = airplaneController.createAirplane(airplaneDto);
		assertEquals(201, response3.getStatusCodeValue());

		FlightDto flightDto = new FlightDto();
		flightDto.setOriginId(response.getBody());
		flightDto.setDestinationId(response2.getBody());
		flightDto.setAirplaneId(response3.getBody());
		flightDto.setFilledSeats(50);

		ResponseEntity<Long> response4 = flightController.createFlight(flightDto);
		assertEquals(201, response4.getStatusCodeValue());

		FlightDto updateFlightDto = new FlightDto();
		updateFlightDto.setOriginId(response2.getBody());
		updateFlightDto.setDestinationId(response.getBody());
		updateFlightDto.setAirplaneId(response3.getBody());
		updateFlightDto.setFilledSeats(100);
		ResponseEntity<?> updateResponse = flightController.updateFlight(response4.getBody(), updateFlightDto);
		assertEquals(200, updateResponse.getStatusCodeValue());

		updateResponse = flightController.updateFlight(null, updateFlightDto);
		assertEquals(400, updateResponse.getStatusCodeValue());

		updateResponse = flightController.updateFlight(300L, updateFlightDto);
		assertEquals(404, updateResponse.getStatusCodeValue());

		ResponseEntity<String> deleteResponse = flightController.deleteFlight(response4.getBody());
		assertEquals(204, deleteResponse.getStatusCodeValue());
	}

	@Test
	public void testUpdateAirplane()
	{
		AirplaneDto airplaneDto = new AirplaneDto();
		airplaneDto.setMaxCapacity(150);
		ResponseEntity<Long> createResponse = airplaneController.createAirplane(airplaneDto);
		assertEquals(201, createResponse.getStatusCodeValue());

		AirplaneDto updateAirplaneDto = new AirplaneDto();
		updateAirplaneDto.setMaxCapacity(100);
		ResponseEntity<?> updateResponse = airplaneController.updateAirplane(createResponse.getBody(), updateAirplaneDto);
		assertEquals(200, updateResponse.getStatusCodeValue());

		updateResponse =airplaneController.updateAirplane(null, updateAirplaneDto);
		assertEquals(400, updateResponse.getStatusCodeValue());

		updateResponse = airplaneController.updateAirplane(0L, updateAirplaneDto);
		assertEquals(404, updateResponse.getStatusCodeValue());
	}

	@Test
	public void testUpdateAirport()
	{
		AirportDto airportDto = new AirportDto();
		airportDto.setCity("Los Angeles");
		airportDto.setIataId("LAX");
		ResponseEntity<Long> createResponse = airportController.createAirport(airportDto);
		assertEquals(201, createResponse.getStatusCodeValue());

		AirportDto updateAirportDto = new AirportDto();
		updateAirportDto.setCity("San Diego");
		updateAirportDto.setIataId("SAN");
		ResponseEntity<?> updateResponse = airportController.updateAirport(createResponse.getBody(), updateAirportDto);
		assertEquals(200, updateResponse.getStatusCodeValue());

		updateResponse = airportController.updateAirport(null, updateAirportDto);
		assertEquals(400, updateResponse.getStatusCodeValue());

		updateResponse = airportController.updateAirport(0L, updateAirportDto);
		assertEquals(404, updateResponse.getStatusCodeValue());



	}

	@Test
	public void deleteAirplaneSuccess()
	{
		AirplaneDto airplaneDto = new AirplaneDto();
		airplaneDto.setMaxCapacity(100);
		ResponseEntity<Long> createResponse = airplaneController.createAirplane(airplaneDto);
		assertEquals(201, createResponse.getStatusCodeValue());

		ResponseEntity<String> deleteResponse = airplaneController.deleteAirplane(createResponse.getBody());
		assertEquals(204, deleteResponse.getStatusCodeValue());
	}

	@Test
	public void deleteAirportSuccess()
	{
		AirportDto airportDto = new AirportDto();
		airportDto.setCity("Los Angeles");
		airportDto.setIataId("LAX");
		ResponseEntity<Long> createResponse = airportController.createAirport(airportDto);
		assertEquals(201, createResponse.getStatusCodeValue());

		ResponseEntity<String> deleteResponse = airportController.deleteAirport(createResponse.getBody());
		assertEquals(204, deleteResponse.getStatusCodeValue());
	}

	@Test
	public void deleteAirplaneAirportFail()
	{
		AirportDto airportDto = new AirportDto();
		airportDto.setCity("San Diego");
		airportDto.setIataId("SAN");

		AirportDto airportDto1 = new AirportDto();
		airportDto1.setCity("Los Angeles");
		airportDto1.setIataId("LAX");

		AirplaneDto airplaneDto = new AirplaneDto();
		airplaneDto.setMaxCapacity(100);

		ResponseEntity<Long> response = airportController.createAirport(airportDto);
		assertEquals(201, response.getStatusCodeValue());

		ResponseEntity<Long> response2 = airportController.createAirport(airportDto1);
		assertEquals(201, response2.getStatusCodeValue());

		ResponseEntity<Long> response3 = airplaneController.createAirplane(airplaneDto);
		assertEquals(201, response3.getStatusCodeValue());

		FlightDto flightDto = new FlightDto();
		flightDto.setOriginId(response.getBody());
		flightDto.setDestinationId(response2.getBody());
		flightDto.setAirplaneId(response3.getBody());
		flightDto.setFilledSeats(50);

		ResponseEntity<Long> response4 = flightController.createFlight(flightDto);
		assertEquals(201, response4.getStatusCodeValue());

		ResponseEntity<String> deleteResponse = airportController.deleteAirport(response.getBody());
		assertEquals(405, deleteResponse.getStatusCodeValue());

		deleteResponse = airplaneController.deleteAirplane(response3.getBody());
		assertEquals(405, deleteResponse.getStatusCodeValue());
	}

}
