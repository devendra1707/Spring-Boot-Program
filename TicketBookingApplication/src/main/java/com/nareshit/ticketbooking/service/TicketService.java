package com.nareshit.ticketbooking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nareshit.ticketbooking.dao.TicketDao;
import com.nareshit.ticketbooking.model.Ticket;


@Service
//All Middlware capability TransactionMgmt will be handled
public class TicketService {

	@Autowired
	private TicketDao ticketdao; //TicketDao ticketDao=null;
	                             //ticketDao=new TicketdDao();




	//Retrieve All Tickets

	public Iterable<Ticket> getAllTickets(){

		//findAll  ==> select * from tbl_ticket ..
		//ResultSet ==> Map Resultset into Ticket
		return ticketdao.findAll();

	}

	//Create a new Ticket

	public Ticket createTicket(Ticket ticketObj) {
	//save ==> Insert into ticket values (ticketObj.,ticketObj.,....);
		//if(ticketObj.getticketId() null or not there in db ==> Insert
				return ticketdao.save(ticketObj);
	}


	//Get a Ticket

	public Ticket getTicket(Integer ticketId) {

		//findById ==> select * from tbl_ticket where ticket_id=ticketId
		//Resultset into Ticket Java Object
		//tikctObj.setPassengerName(rs[0]["passengerName"]);

		return ticketdao.findById(ticketId).
				orElse(new Ticket());

	}



	//Update a Ticket

	public Ticket updateTicket(Integer ticketId,String newEmail) {

		//Only we can update email through Update Method
		//save Method only create or update
		//save method will create insert stattment or update statement

		//If ticketObj.getTicketId() ==> If there in DB ==> Update


		Ticket dbTicketObj=getTicket(ticketId);
		dbTicketObj.setEmail(newEmail);


		return ticketdao.save(dbTicketObj);
		//save ==> it will write update statement to DB
		//update ticket set email=newEmail where ticketid=ticketId


	}



	public void deleteTicket(Integer ticketId) {
		ticketdao.deleteById(ticketId);
		//deleteById => delete from tbl_ticket where ticket_id=ticketId
	}

}
