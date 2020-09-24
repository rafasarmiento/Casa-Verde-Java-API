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
	
	
	public Event addEvent(@RequestBody Event event) {
		return eventRepository.save(event);
	}
	
	
	public List<Event> getEvents() {
		return eventRepository.findAll();
	}
	
	public Event getEventById(@PathVariable Long id) {
		return eventRepository.findById(id).orElse(null);
	}
	
	public Event updateEvent(@RequestBody Event event) {
		Event oldEvent= eventRepository.findById(event.getId()).orElse(null);
		
		if (oldEvent !=null) {
			double oldEventTotal=oldEvent.getTotal();
			double eventPayments=0;
			List<Payment> oldEventPayments = oldEvent.getPayments();
			
			oldEventPayments.add(event.getPayments().get(0));//de esta forma ya que siempre se agrega de a 1 pago
			
			for (Payment payment : oldEventPayments) {
				eventPayments += payment.getAmount();
			}
			
			if (eventPayments > oldEventTotal) {
				System.out.println("El pago total excede al monto total del evento");
				return null;
			} else {
				
			}
			
		} else {
			return null;
		}
		return null;
	}
	
	public String deleteEvent(@PathVariable Long id) {
		eventRepository.deleteById(id);
		return "Evento borrado: " + id;
	}

}
