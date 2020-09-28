package com.casaverde.casaverde.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Event_Payment")
public class Event_Payment {

	private Long eventId;
	
	private Long paymentId;

	public Event_Payment(Long eventId, Long paymentId) {
		super();
		this.eventId = eventId;
		this.paymentId = paymentId;
	}

	public Long getEventId() {
		return eventId;
	}

	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}

	public Long getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
	}
	
	
}
