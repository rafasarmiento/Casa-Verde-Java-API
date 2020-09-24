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
public class PaymentController {

	@Autowired
	private PaymentService paymentService;
	
	@Autowired
	private EventService eventService;
	
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
		return paymentService.addPayment(payment);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/payments/delete/{id}")
	public String deleteEventPayments(Event event) {
		return paymentService.deleteEventPayments(event);
	}
}
