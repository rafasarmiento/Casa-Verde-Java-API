package com.casaverde.casaverde.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Event")
public class Event {

	@Id
	@GeneratedValue
	private Long Id;
	
	private Date Date;
	
	private Integer Type;
	
	private String Status;
	
	private Double Price;
	
	private Double Aditional;
	
	private Double Total;
	
	private String Comments;
	
	private Client Client_idClient;
	
	private List<Payment> Payments;
	
	public Event(Long id, java.util.Date date, Integer type, String status, Double price, Double aditional,
			Double total, String comments, Client client) {
		super();
		Id = id;
		Date = date;
		Type = type;
		Status = status;
		Price = price;
		Aditional = aditional;
		Total = total;
		Comments = comments;
		Client_idClient = client;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Date getDate() {
		return Date;
	}

	public void setDate(Date date) {
		Date = date;
	}

	public Integer getType() {
		return Type;
	}

	public void setType(Integer type) {
		Type = type;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public Double getPrice() {
		return Price;
	}

	public void setPrice(Double price) {
		Price = price;
	}

	public Double getAditional() {
		return Aditional;
	}

	public void setAditional(Double aditional) {
		Aditional = aditional;
	}

	public Double getTotal() {
		return Total;
	}

	public void setTotal(Double total) {
		Total = total;
	}

	public String getComments() {
		return Comments;
	}

	public void setComments(String comments) {
		Comments = comments;
	}

	public Client getClient() {
		return Client_idClient;
	}

	public void setClient(Client client) {
		Client_idClient = client;
	}

	public List<Payment> getPayments() {
		return Payments;
	}

	public void setPayments(List<Payment> payments) {
		Payments = payments;
	}
	
}
