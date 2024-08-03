package com.sm.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sm.dao.OrganizerRepository;
import com.sm.entity.Organizer;

@Service
public class OrganizerService {

	@Autowired
    private OrganizerRepository organizerRepository;

    public Organizer createOrganizer(Organizer organizer) {
        return organizerRepository.save(organizer);
    }

    public Optional<Organizer> getOrganizerById(Long id) {
        return organizerRepository.findById(id);
    }

    public Organizer updateOrganizer(Long id, Organizer organizerDetails) {
        Optional<Organizer> optionalOrganizer = organizerRepository.findById(id);
        if (optionalOrganizer.isPresent()) {
            Organizer organizer = optionalOrganizer.get();
            organizer.setName(organizerDetails.getName());
            organizer.setContactInfo(organizerDetails.getContactInfo());
            return organizerRepository.save(organizer);
        }
        return null;
    }

    public void deleteOrganizer(Long id) {
        organizerRepository.deleteById(id);
    }
}
