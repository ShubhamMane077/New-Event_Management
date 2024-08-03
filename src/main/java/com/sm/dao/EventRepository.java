package com.sm.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sm.entity.Event;

@Repository
public interface EventRepository extends CrudRepository<Event, Long> {

	List<Event> findByVenueId(Long venueId);

	List<Event> findByOrganizerId(Long organizerId);
}
