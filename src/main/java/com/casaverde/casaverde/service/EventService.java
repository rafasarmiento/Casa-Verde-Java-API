package com.casaverde.casaverde.service;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.casaverde.casaverde.entities.Event;
import com.casaverde.casaverde.entities.Payment;
import com.casaverde.casaverde.repository.IEventRepository;
import com.casaverde.casaverde.repository.IPaymentRepository;

@Service
public class EventService {
	
	@Autowired
	private IEventRepository eventRepository;//metodos para manejar la tabla de Eventos
	
	@Autowired
	private IPaymentRepository paymentRepository;//metodos para manejar la tabla de Pagos
	
	
	public Event addEvent(Event event) {
		return eventRepository.save(event);
	}
	
	
	public List<Event> getEvents() {
		return eventRepository.findAll();
	}
	
	public Event getEventById(Long id) {
		return eventRepository.findById(id).orElse(null);
	}
	
	public Event updateEvent(Event event) {
		double eventTotal = event.getTotal();
		double eventPayments = 0;

		for (Payment p : event.getPayments()) {
			eventPayments += p.getAmount();
			
			if (eventPayments > eventTotal) {
				System.out.println("el monto de los pagos supera el total del evento");
				return null;
			} else if (eventPayments == eventTotal) {
				event.setStatus("Pagado");
			}
		}

		return eventRepository.save(event);

	}
	
	public String deleteEvent(Long id) {
		eventRepository.deleteById(id);
		return "Evento borrado: " + id;
	}

}
