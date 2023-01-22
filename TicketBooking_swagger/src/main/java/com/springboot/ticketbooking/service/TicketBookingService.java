package com.springboot.ticketbooking.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.springboot.ticketbooking.dao.TicketBookingDao;
import com.springboot.ticketbooking.entities.Ticket;

@Service
public class TicketBookingService {
	
	@Autowired
	private TicketBookingDao ticketBookingDao;
	

	public Ticket createTicket(Ticket ticket) {
				return ticketBookingDao.save(ticket);
	}
	
	public Optional<Ticket> getTicketById(Integer ticketId) {
				return ticketBookingDao.findById(ticketId);
	}

	
	public Iterable<Ticket> getAllBookedTickets() {
		
		return ticketBookingDao.findAll();
	}

	
	public void deleteBookedTicket(Integer ticketId) {
		
		ticketBookingDao.deleteById(ticketId);
	}

	
		public Ticket updateBookedTicket(Integer ticketId, String newEmail) {
		
		Ticket ticket=ticketBookingDao.findById(ticketId).
				orElse(new Ticket());
		ticket.seteMail(newEmail);
		ticketBookingDao.save(ticket);
		return ticket;
	}

}
