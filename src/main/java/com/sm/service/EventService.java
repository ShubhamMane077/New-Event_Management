package com.sm.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sm.dao.EventRepository;
import com.sm.entity.Event;

@Service
public class EventService {

	@Autowired
	private EventRepository eventRepository;

	public Event createEvent(Event event) {
		return eventRepository.save(event);
	}

	public List<Event> getAllEvents() {
		Iterable<Event> events = eventRepository.findAll();
		return StreamSupport.stream(events.spliterator(), false).collect(Collectors.toList());
	}

	public Event getEventById(Long id) {
		return eventRepository.findById(id).orElse(null);
	}

	public Event updateEvent(Long id, Event eventDetails) {
		Event event = eventRepository.findById(id).orElse(null);
		if (event != null) {
			event.setEventName(eventDetails.getEventName());
			event.setEventDate(eventDetails.getEventDate());
			event.setDescription(eventDetails.getDescription());
			event.setOrganizer(eventDetails.getOrganizer());
			event.setVenue(eventDetails.getVenue());
			return eventRepository.save(event);
		}
		return null;
	}

	public void deleteEvent(Long id) {
		eventRepository.deleteById(id);
	}

	public List<Event> getEventsByVenue(Long venueId) {
		return eventRepository.findByVenueId(venueId);
	}

	public List<Event> getEventsByOrganizer(Long organizerId) {
		return eventRepository.findByOrganizerId(organizerId);
	}
}
