package com.sm.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sm.entity.Organizer;

@Repository
public interface OrganizerRepository extends CrudRepository<Organizer, Long> {

}
