package com.casaverde.casaverde.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casaverde.casaverde.entities.Event;
import com.casaverde.casaverde.entities.Payment;
import com.casaverde.casaverde.repository.IPaymentRepository;

@Service
public class PaymentService {

	@Autowired
	private IPaymentRepository paymentRepository;
	
	public Payment addPayment(Payment payment) {
		return paymentRepository.save(payment);
	}
	
	public List<Payment> getPayments(){
		return paymentRepository.findAll();
	}
	
	public List<Payment> getPaymentsByEvent(Long id){
		return paymentRepository.findPaymentsByEvent(id);
	}
	
	public String deleteEventPayments(Event event) {
		return paymentRepository.deleteEventPayments(event);
	}
}
