package com.spring.mvc.entity;

import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name="USERS")
@Data
public class User extends BaseEntity  {
	
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

@Id
@SequenceGenerator(name = "user_seq_gen",sequenceName="user_gen",initialValue=100,allocationSize=1)
@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="user_seq_gen")
@Column(name="ID")
private long id;

@Column(name="NAME",length=100)
private String firstName;

@Column(name="SURNAME",length=100)
private String lastName;

public long getId() {
	return id;
}

public void setId(long id) {
	this.id = id;
}

public String getFirstName() {
	return firstName;
}

public void setFirstName(String firstName) {
	this.firstName = firstName;
}

public String getLastName() {
	return lastName;
}

public void setLastName(String lastName) {
	this.lastName = lastName;
}



}
