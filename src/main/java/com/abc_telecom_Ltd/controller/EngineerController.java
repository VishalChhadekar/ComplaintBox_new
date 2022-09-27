package com.abc_telecom_Ltd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abc_telecom_Ltd.entity.Complaint;
import com.abc_telecom_Ltd.model.UpdateStatusModel;
import com.abc_telecom_Ltd.service.ComplaintService;


@RestController
@RequestMapping("/engineer")
public class EngineerController {
	
	@Autowired
	private ComplaintService complaintService;
	
	//VIEW ASSIGNED COMPLAINTS
	@GetMapping("/viewComplaints/{eng_id}")
	public ResponseEntity<List<Complaint>> viewAllComplaints(@PathVariable Long eng_id){
		List<Complaint> complaints = complaintService.viewAllComplaints(eng_id);
		return new  ResponseEntity<List<Complaint>>(complaints, HttpStatus.OK);
		
	}
	//UPDATE STATUS
	@PostMapping("/updateStatus")
	public ResponseEntity<Complaint> updateStatus(@RequestBody UpdateStatusModel status){
		Complaint complaint = complaintService.updateStatus(status);
		return new  ResponseEntity<Complaint>(complaint, HttpStatus.OK);
	}

}
