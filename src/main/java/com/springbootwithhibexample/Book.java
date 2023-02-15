package com.springbootwithhibexample;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;


@Entity
@Data
// hello java 
public class Book {

	@Id
	@GeneratedValue
	private int id;
	private String name;
	private double cost;
	

	
}
