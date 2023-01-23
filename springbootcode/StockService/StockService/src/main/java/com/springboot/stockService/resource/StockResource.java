package com.springboot.stockService.resource;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;
import yahoofinance.quotes.stock.StockQuote;

@RestController
@RequestMapping("/rest/stock")
public class StockResource {

	
	 Logger logger= LoggerFactory.getLogger(StockResource.class);
	 
    @Autowired
    RestTemplate restTemplate;
    
    
    YahooFinance yahooFinance;
    
    public StockResource() {
    	this.yahooFinance=new YahooFinance();
    }
    
    
	 @GetMapping("/{userName}")
	    public List<Quote> getStock(@PathVariable("userName") 
	    final String userName) throws JsonProcessingException {
		 
		    logger.info("STock-Service Request : "+userName);
				
		 ResponseEntity<List<String>> quoteResponse=restTemplate.
				 exchange("http://db-service/rest/db/"+userName,
				 HttpMethod.GET,
				 null,
				 new ParameterizedTypeReference<List<String>>() {
         });
		 
		 logger.info("STock-Service Request  : "+new ObjectMapper().writeValueAsString(quoteResponse));
		List<String> quotes=quoteResponse.getBody();
	    return quotes
                .stream()
                .map(quote -> {
                Stock stock=getStockPrice_internal(quote);
                return new Quote(quote,stock.getCurrency());
                })
                .collect(Collectors.toList());
	     //  logger.info("STock-Service Request  : "+new ObjectMapper().writeValueAsString(quotes));
		//
	 }
	 
	 private class Quote{
		 private String quote;
		 
		private String price;
		 public Quote(String quote,String price)
		 {
			 this.quote=quote;
			 this.price=price;
		 }
		 public String getQuote() {
				return quote;
			}
			public void setQuote(String quote) {
				this.quote = quote;
			}
			public String getPrice() {
				return price;
			}
			public void setPrice(String price) {
				this.price = price;
			}
		 
	 }
	 
	 
	 private Stock getStockPrice_yahoo(String quote) {
	        try {
	            return YahooFinance.get(quote);
	        } catch (IOException e) {
	            e.printStackTrace();
	            return new Stock(quote);
	        }
	    }
	 
	 
	 private Stock getStockPrice_internal(String quote)
	 {
		 //return	YahooFinance.get(quote);
		 if(quote.equalsIgnoreCase("GOOG"))
		 {
			 Stock stock=new Stock(quote);
			 stock.setCurrency("100$");
			 return stock;
		 } else if(quote.equalsIgnoreCase("RIL"))
		 {
			 Stock stock=new Stock(quote);
			 
			 stock.setCurrency("200$");
			 return stock;
		 }else if(quote.equalsIgnoreCase("AIRTEL"))
		 {
			 Stock stock=new Stock(quote);
			 
			 stock.setCurrency("300$");
			 return stock;
		 }else if(quote.equalsIgnoreCase("JIO"))
		 {
			 Stock stock=new Stock(quote);
			 
			 stock.setCurrency("400$");
			 return stock;
		 }if(quote.equalsIgnoreCase("SUZ"))
		 {
			 Stock stock=new Stock(quote);
			 
			 stock.setCurrency("10$");
			 return stock;
		 }
		 if(quote.equalsIgnoreCase("SBI"))
		 {
			 Stock stock=new Stock(quote);
			 
			 stock.setCurrency("20$");
			 return stock;
		 }
		 else
			 return null;
	 }
}
