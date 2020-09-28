package com.casaverde.casaverde.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.casaverde.casaverde.entities.Event;
import com.casaverde.casaverde.entities.Event_Payment;
import com.casaverde.casaverde.entities.Payment;
import com.casaverde.casaverde.service.EventService;
import com.casaverde.casaverde.service.Event_PaymentService;
import com.casaverde.casaverde.service.PaymentService;

@RestController
public class PaymentController {

	@Autowired
	private PaymentService paymentService;
	
	@Autowired
	private EventService eventService;
	
	@Autowired
	private Event_PaymentService event_paymentService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/payments")
	public List<Payment> getPayments(){
		return paymentService.getPayments();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/events/{id}/payments")
	public List<Payment> getPaymentsByEvent(@PathVariable Long id){
		return paymentService.getPaymentsByEvent(id);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/addPayment")
	public Payment addPayment(@RequestBody Payment payment) {
		boolean valid = true;
		boolean event_paymentInsert = false;

		try {
			Event eventPayment = eventService.getEventById(payment.getEventId());
			List<Payment> payments = eventPayment.getPayments();
			payments.add(payment);
			eventPayment.setPayments(payments);
			System.out.println("Actualizando el evento...");
			Event updatedEvent = eventService.updateEvent(eventPayment);
			if (updatedEvent == null) {
				valid = false;
			} else {
				Event_Payment event_Payment = new Event_Payment(payment.getEventId(), payment.getId());
				event_paymentInsert = event_paymentService.addEvent_Payment(event_Payment);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Ha ocurrido una excepcion: " + e.getMessage() + "\nEmpiezo el StackTrace:");
			e.printStackTrace();
			valid = false;
		}

		if (valid && event_paymentInsert) {
			System.out.println("Creando pago...");

			return paymentService.addPayment(payment);
		} else {
			System.out.println("No se ha procesado el pago correctamente, no se actualiza el evento...");
			return null;
		}
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/payments/delete/{id}")
	public String deleteEventPayments(Event event) {
		return paymentService.deleteEventPayments(event);
	}
}
