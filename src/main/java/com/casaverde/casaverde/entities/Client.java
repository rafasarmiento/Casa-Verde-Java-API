package com.casaverde.casaverde.entities;

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
@Table(name = "Client")
public class Client {
	
	@Id
	@GeneratedValue
	private Long Id;
	
	private String Name;
	
	private String Email;
	
	private String Phone;
	
	private String BackupPhone;
	
	private String Comments;
	
	public Client(long id, String name, String email, String phone, String backupPhone, String comments) {
		super();
		Id = id;
		Name = name;
		Email = email;
		Phone = phone;
		BackupPhone = backupPhone;
		Comments = comments;
	}
	public long getId() {
		return Id;
	}
	public void setId(long id) {
		Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	public String getBackupPhone() {
		return BackupPhone;
	}
	public void setBackupPhone(String backupPhone) {
		BackupPhone = backupPhone;
	}
	public String getComments() {
		return Comments;
	}
	public void setComments(String comments) {
		Comments = comments;
	}

	
	
}
