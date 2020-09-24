package com.casaverde.casaverde.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.casaverde.casaverde.entities.Event;

public interface IEventRepository extends JpaRepository<Event, Long> {

}
