package com.nareshit.ticketooking.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//This is model class and this will be having all annotions related to databae operations

@Entity //@Entity will be creating a table the in the database with class name as table name
@Table(name = "tbl_ticket") //This will creatina table with name tbl_ticket
//This annotation Optional
public class Ticket {



	@Id //This annotation will create primary key
	@Column(name="ticket_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer ticketId;

	//@GeneratedValue ==> Framework is generating the value ..End User no need to populate
	//AUTO ==> JPA will Generate the the value using Database Sequence
	//IDENTITY ==> Database will Generate the value


	//By default Every Property will be table column==> PropertyName will be column Name
	@Column(name="passenger_name") // Column will be created with name as passenger_name
	private String passengerName;

	@Column(name="source_station")
	private String sourceStation;

	@Column(name="destination_station")
	private String destinationStation;

	@Column(name="travel_date")
	private Date travelDate;

	private String email;

	public Integer getTicketId() {
		return ticketId;
	}

	public void setTicketId(Integer ticketId) {
		this.ticketId = ticketId;
	}

	public String getPassengerName() {
		return passengerName;
	}

	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}

	public String getSourceStation() {
		return sourceStation;
	}

	public void setSourceStation(String sourceStation) {
		this.sourceStation = sourceStation;
	}

	public String getDestinationStation() {
		return destinationStation;
	}

	public void setDestinationStation(String destinationStation) {
		this.destinationStation = destinationStation;
	}

	public Date getTravelDate() {
		return travelDate;
	}

	public void setTravelDate(Date travelDate) {
		this.travelDate = travelDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Ticket( String passengerName, String sourceStation, String destinationStation,
			 String email) {
		super();
		this.passengerName = passengerName;
		this.sourceStation = sourceStation;
		this.destinationStation = destinationStation;
		this.travelDate = new Date();
		this.email = email;
	}
	public Ticket( ) {}

	@Override
	public String toString() {
		return "Ticket [ticketId=" + ticketId + ", passengerName=" + passengerName + ", sourceStation=" + sourceStation
				+ ", destinationStation=" + destinationStation + ", travelDate=" + travelDate + ", email=" + email
				+ "]";
	}






}
