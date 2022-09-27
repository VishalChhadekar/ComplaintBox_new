package com.abc_telecom_Ltd.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Complaint { 
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Complaint_id;
	private String complaint;
	private String feedback;
	private String status;
	private Long pinCode;
	private Long engineer;
	private Long customer;
	
}
