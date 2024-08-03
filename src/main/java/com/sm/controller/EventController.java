package com.sm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sm.entity.Event;
import com.sm.service.EventService;

@RestController
@RequestMapping("/events")
public class EventController {

	@Autowired
	private EventService eventService;

	@PostMapping
	public Event createEvent(@RequestBody Event event) {
		return eventService.createEvent(event);
	}

	@GetMapping
	public List<Event> getAllEvents() {
		return eventService.getAllEvents();
	}

	@GetMapping("/{id}")
	public Event getEventById(@PathVariable Long id) {
		return eventService.getEventById(id);
	}

	@PutMapping("/{id}")
	public Event updateEvent(@PathVariable Long id, @RequestBody Event eventDetails) {
		return eventService.updateEvent(id, eventDetails);
	}

	@DeleteMapping("/{id}")
	public void deleteEvent(@PathVariable Long id) {
		eventService.deleteEvent(id);
	}

	@GetMapping("/venue/{venueId}")
	public List<Event> getEventsByVenue(@PathVariable Long venueId) {
		return eventService.getEventsByVenue(venueId);
	}

	@GetMapping("/organizer/{organizerId}")
	public List<Event> getEventsByOrganizer(@PathVariable Long organizerId) {
		return eventService.getEventsByOrganizer(organizerId);
	}
}
