package com.anhduc.hello.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Data
@Entity
@Table(name = "trancript")	
@Getter
@Setter
@NoArgsConstructor
public class Transcript {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	@Column(name = "english")
	private double english;
	
	@Column(name = "mark")
	private double mark;
	
	@Column(name = "it")
	private double it;
	
	@OneToOne(cascade = CascadeType.ALL) 
	@JoinColumn(name = "employee_id", referencedColumnName = "id")
	private Employee employee;


	public Transcript(double english, double mark, double it, Employee employee) {
		super();
		this.english = english;
		this.mark = mark;
		this.it = it;
		this.employee = employee;
	}


	

	
	
	
}
