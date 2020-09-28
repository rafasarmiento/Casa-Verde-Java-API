package com.casaverde.casaverde.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casaverde.casaverde.entities.Event_Payment;
import com.casaverde.casaverde.repository.IEvent_PaymentRepository;

@Service
public class Event_PaymentService {

	@Autowired
	private IEvent_PaymentRepository event_PaymentRepository;
	
	public Boolean addEvent_Payment(Event_Payment event_Payment) {
		Event_Payment result = event_PaymentRepository.save(event_Payment);
		if (result != null) {
			return true;
		} else {
			return false;
		}
	}
	
	public Boolean deleteEvent_Payment(Event_Payment event_Payment) {
		boolean deleted = true;

		try {
			event_PaymentRepository.delete(event_Payment);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error al borrar registro de la tabla... imprimo StackTrace:");
			e.printStackTrace();
			deleted = false;
		}
		return deleted;
	}
}
