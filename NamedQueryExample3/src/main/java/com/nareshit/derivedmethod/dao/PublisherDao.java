package com.nareshit.derivedmethod.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nareshit.derivedmethod.model.Publisher;

@Repository
public interface PublisherDao extends CrudRepository<Publisher, Integer> {



}
