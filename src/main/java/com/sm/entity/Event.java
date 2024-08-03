package com.sm.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@jakarta.persistence.Entity
@Data
public class Event {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String eventName;
	private String eventDate;
	private String description;

	@ManyToOne
	@JoinColumn(name = "organizer_id")
	private Organizer organizer;

	@ManyToOne
	@JoinColumn(name = "venue_id")
	private Venue venue;
}
