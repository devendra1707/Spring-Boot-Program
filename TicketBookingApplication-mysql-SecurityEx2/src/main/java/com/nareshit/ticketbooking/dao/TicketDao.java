package com.nareshit.ticketbooking.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nareshit.ticketbooking.model.Ticket;

@Repository
//Automatically reads the data source  url,username,password,schemaName
//Automatically it will create a database connection

//Connection con=DriverManager.getConnection(url.....);

public interface TicketDao  extends CrudRepository<Ticket, Integer>{


	//insert into ticket values (,,,,,,);

	//update ticket set .....where tiket_id=?

	//delete from ticket.....

	//select * from ticket

//CrudRe

	//CrudRepository ===> CRUD --> Create (Insert) ==>
	//                          --> Read (select)
	//                          ---> Update(update)
	//                          ---> Delete(delete)



}
