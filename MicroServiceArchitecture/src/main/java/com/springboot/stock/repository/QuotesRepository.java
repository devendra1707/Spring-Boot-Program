package com.springboot.stock.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.stock.model.Quote;
import com.springboot.stock.model.Quotes;

public interface QuotesRepository extends JpaRepository<Quote, Integer> {

	List<Quote> findByUserName(String username);

}
