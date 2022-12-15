package com.nareshit.ticketooking.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nareshit.ticketooking.model.Ticket;

//DAO Layer ==> Database Access Object ==> All data base operations wil be here

@Repository

//Connect to the database, Opens the Connection using Connection Pool

//CRUD Operations are common for every table

//CrudRepository ==> Predefined interface for performing CRUD Operations
//if we take CRUD Repository ==> Developer no need to write any database code
//It will have two parameters ==> 1) Model Class Name 2) Datatype of PK of Model

public interface TicketDao extends CrudRepository<Ticket, Integer>{

//NO need to write any code in the DAO Class ==> CRUDRepo is completely having this functionality.
}
