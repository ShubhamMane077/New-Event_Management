package com.sm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sm.entity.Organizer;
import com.sm.service.OrganizerService;

@RestController
@RequestMapping("/organizets")
public class OrganizerController {

	@Autowired
    private OrganizerService organizerService;

    @PostMapping
    public Organizer createOrganizer(@RequestBody Organizer organizer) {
        return organizerService.createOrganizer(organizer);
    }

    @GetMapping("/{id}")
    public Organizer getOrganizerById(@PathVariable Long id) {
        return organizerService.getOrganizerById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Organizer updateOrganizer(@PathVariable Long id, @RequestBody Organizer organizerDetails) {
        return organizerService.updateOrganizer(id, organizerDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteOrganizer(@PathVariable Long id) {
        organizerService.deleteOrganizer(id);
    }
}
