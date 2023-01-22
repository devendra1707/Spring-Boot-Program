package com.springboot.ticketbooking;

import java.util.Date;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.springboot.ticketbooking.entities.Ticket;
import com.springboot.ticketbooking.service.TicketBookingService;

@SpringBootApplication
@EnableCaching
public class TicketBoookngManagmentAppApplication 
{

		
	public static void main(String[] args) {
		 SpringApplication
				.run(TicketBoookngManagmentAppApplication.class, args);
	

	}

	
	@Bean
	public CacheManager cacheManager(){
		return new ConcurrentMapCacheManager("ticketsCache");
	}

}
