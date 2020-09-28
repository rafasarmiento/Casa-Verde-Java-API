package com.casaverde.casaverde.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.casaverde.casaverde.entities.Event;
import com.casaverde.casaverde.entities.Payment;

public interface IPaymentRepository extends JpaRepository<Payment, Long> {

	List<Payment> findPaymentsByEvent(Long id);;

	String deleteEventPayments(Event event);

}
