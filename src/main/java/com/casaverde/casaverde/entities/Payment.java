package com.casaverde.casaverde.entities;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Payment")
public class Payment {

	@Id
	@GeneratedValue
	private Long Id;
	
	private Double Amount;
	
	private Integer Type;
	
	private Date Date;
	
	private Client Client;
	
	private Long EventId;
	
	public Payment(Long id, Double amount, Integer type, java.util.Date date,
			Client client, Long event) {
		super();
		Id = id;
		Amount = amount;
		Type = type;
		Date = date;
		Client = client;
		EventId = event;
	}
	
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public Double getAmount() {
		return Amount;
	}
	public void setAmount(Double amount) {
		Amount = amount;
	}
	public Integer getType() {
		return Type;
	}
	public void setType(Integer type) {
		Type = type;
	}
	public Date getDate() {
		return Date;
	}
	public void setDate(Date date) {
		Date = date;
	}
	public Client getClient() {
		return Client;
	}
	public void setClient(Client client) {
		Client = client;
	}
	public Long getEventId() {
		return EventId;
	}
	public void setEventId(Long eventId) {
		EventId = eventId;
	}
	
}
