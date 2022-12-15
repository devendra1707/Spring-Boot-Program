package com.nareshit.ticketooking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nareshit.ticketooking.dao.TicketDao;
import com.nareshit.ticketooking.model.Ticket;

@Service // It will update the framework as business logic layer ,,where transaction
			// mgmt,logging,etc. automatically plugged
public class TicketService {

	@Autowired
	private TicketDao ticketDao; // TicketDao ticketDao =new TicketDao();

	// Retrieve the Data
	public Iterable<Ticket> getTickets() {
		return ticketDao.findAll();

		// FindAll ==> SELECT * FROM TBL_TICKET
		// ResultSet will be converted to Iterable<Ticket>
	}

	// Retrieving Specific Ticket
	public Ticket getTicket(Integer ticketId) {

		// findById ==> Retrieves the data with Primary key value
		// OrElse ==> Supporting for Minimizing Null Pointer exception using Optional
		// findById ==> select * from tbl_ticket where ticket_id=ticketId

		return ticketDao.findById(ticketId).orElse(new Ticket());
	}

	// Creating (Inserting) the data
	public Ticket createTicket(Ticket ticketObj) {

		// Save is the Method which will insert the data
		// Save is also Updates the data
		// if ticketObj.getTicketId ==null or if assigned value which is not there in db
		// ==> It will create
		// if ticketObj.getTicketId ==> If we have the data ==> Updates the data
		return ticketDao.save(ticketObj);
	}

	public Ticket updateTicket(Integer ticketId, String newEmail) {

		Ticket dbTicketObj = getTicket(ticketId);
		dbTicketObj.setEmail(newEmail);
		//Here save method wil do updat e==> PK wil lbe there in the dbTicketObj
		return ticketDao.save(dbTicketObj);
	}
}
