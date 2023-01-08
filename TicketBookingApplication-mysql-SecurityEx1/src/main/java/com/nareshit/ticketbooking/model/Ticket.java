package com.nareshit.ticketbooking.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//Its a JPA Class represent a database table

@Entity //It will create table with Name as Ticket
@Table(name = "tbl_ticket") // tbl_ticket will be created in database

public class Ticket {

	//Primary Key
	@Id //Creating Primary key to Database
	@Column(name="ticket_id")
	//@GeneratedValue ==> JPA will generate
	//AUTO => JPA will create a sequence to dababase and used this sequence
	//for autopopulate this value
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer ticketId;


	//By default every java property wil be a database column
	@Column(name = "passenger_name") //passenger_name will be created in db
	private String passengerName;



	@Column(name = "source_station")
	private String sourceStation;

	@Column(name = "destination_station")
	private String destinationStation;

	@Column(name = "travel_date")
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

	public Ticket(String passengerName, String sourceStation, String destinationStation,
			Date travelDate, String email) {
		super();

		this.passengerName = passengerName;
		this.sourceStation = sourceStation;
		this.destinationStation = destinationStation;
		this.travelDate = new Date();
		this.email = email;
	}

	public Ticket() {}

	@Override
	public String toString() {
		return "Ticket [ticketId=" + ticketId + ", passengerName=" + passengerName + ", sourceStation=" + sourceStation
				+ ", destinationStation=" + destinationStation + ", travelDate=" + travelDate + ", email=" + email
				+ "]";
	}







}
