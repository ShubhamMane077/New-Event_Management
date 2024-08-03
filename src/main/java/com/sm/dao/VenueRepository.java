package com.sm.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sm.entity.Venue;

@Repository
public interface VenueRepository extends CrudRepository<Venue, Long> {

}
