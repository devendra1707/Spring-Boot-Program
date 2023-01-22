package com.springboot.ticketbooking.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springboot.ticketbooking.entities.Ticket;

@Repository
public interface TicketBookingDao extends CrudRepository<Ticket, Integer> {

	
}
