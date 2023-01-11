package com.nareshit.ticketbooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nareshit.ticketbooking.model.Ticket;
import com.nareshit.ticketbooking.service.TicketService;

@RestController
@RequestMapping(value="/tickets")
//http://localhost:8080/tickets ==> TicketController = ioc.getTicketController();
public class TicketController {


	//JAX - RS Framework ===> Java API FOR XML RestServices Framework
	//Rest Sevice is a webservice

	//If two different programming languages want to communicate with each
	//other ==> WebServices


	//Rest Services and SOAP Services


	//VERBS ==>  GET ==> If we want to get the data
	//           POST ==> If we want to create the data
	//           PUT ==> Update the data
	//           DELETE ==> Deletes the data

	//REQUESTOBJ AND RESPONSEOBJ ==> Input and Output






	@Autowired
	private TicketService ticketService;
	//@GetMapping ==> @Get+ @RequestMapping


	//FindAll Method
	@GetMapping(value="/admin/all") //==> http://localhost:8080/tickets/admin/all
	public Iterable<Ticket> getAllTickets(){

		return ticketService.getAllTickets();

	}


	//FineOneticket method

	// http://localhost:8080/tickets/1 ==> Ticket with id=1
	// http://localhost:8080/tickets/2 ==> Ticket with id=2

	/*
	@GetMapping(value="/{ticketId}")
	public Ticket getTicket(@PathVariable("ticketId") Integer ticketId) {

		return ticketService.getTicket(ticketId);
	}
*/

	@GetMapping(value="/ticket/{passengerName}")
	//// http://localhost:8080/tickets/ticket/Ramu
	public Ticket getTicket(@PathVariable("passengerName") String  passengerName) {

		return ticketService.findByPassengerName(passengerName);
	}

	//CreateTicket Method
	//Create ==> POST VERB, postmapping ==> @post+@RequestMapping
	@PostMapping(value="/create") // http://localhost:8080/create
	public Ticket createTicket(@RequestBody Ticket ticketObj) {

		return ticketService.createTicket(ticketObj);
	}



	//UpdateTicket
	//@PutMapping ==> @Put + @RequestMapping

	//http://localhost:8080/tickets/1/a@b.com ==>
	@PutMapping(value="/{ticketId}/{newEmail}")
	public Ticket updateTicket(
				@PathVariable("ticketId") Integer ticketId,
				@PathVariable("newEmail") String newEmail) {
		return ticketService.updateTicket(ticketId, newEmail);
	}


	//Delete Ticket

	//@DeleteMapping ==> @Delete + @RequestMapping

	@DeleteMapping(value="/{ticketId}") //http://localhost:8080/tickets/1
	public void deleteTicket(@PathVariable("ticketId") Integer ticketId) {
		ticketService.deleteTicket(ticketId);
	}


}
