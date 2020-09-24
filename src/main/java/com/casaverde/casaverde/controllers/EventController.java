package com.casaverde.casaverde.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.casaverde.casaverde.entities.Event;
import com.casaverde.casaverde.entities.Payment;
import com.casaverde.casaverde.service.EventService;
import com.casaverde.casaverde.service.PaymentService;

@RestController
public class EventController {
	
	@Autowired
	private EventService eventService;
	
	@Autowired
	private PaymentService paymentService;
	
	@RequestMapping(method = RequestMethod.POST, value = "/addEvent")
	public Event addEvent(Event event) {
		return eventService.addEvent(event);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/events")
	public List<Event> getEvents(){
		return eventService.getEvents();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/events/{id}")
	public Event getEventById(@PathVariable Long id) {
		return eventService.getEventById(id);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/events/pay/")
	public Event updateEvent(@RequestBody Event event) {
		return eventService.updateEvent(event);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/events/delete/{id}")
	public String deleteEvent(@PathVariable Long id) {
		return eventService.deleteEvent(id);
	}

}
