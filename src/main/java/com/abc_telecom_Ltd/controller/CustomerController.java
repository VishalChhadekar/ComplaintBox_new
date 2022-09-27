package com.abc_telecom_Ltd.controller;
	


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
import com.abc_telecom_Ltd.model.FeedbackModel;
import com.abc_telecom_Ltd.service.ComplaintService;


@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private ComplaintService complaintService;
	
	//LOGIN
	
	//RAISE COMPLAINT
	@PostMapping("/raiseComplaint")
	public ResponseEntity<Complaint> raiseComplaint(@RequestBody Complaint complaint ){
		Complaint complaint2 = complaintService.raiseComplaint(complaint);
		//Customer_id, complaint, pin code, contact are required to raise complaint
		//Engineer, Feedback can be set 'NA' from UI side. 
		return new ResponseEntity<Complaint>(complaint2, HttpStatus.OK);
	}
	
	
	//VIEW COMPLAINT
	@GetMapping("/viewComplaint/{cust_id}")
	public ResponseEntity<Complaint> viewComplaint(@PathVariable Long cust_id){
		Complaint complaint = complaintService.viewComplaint(cust_id);
		return new ResponseEntity<Complaint>(complaint, HttpStatus.OK);
	}
	

	//PROVIDE FEEDBACK
	@PostMapping("/addFeedback/{cust_id}")
	public String provideFeedback(@RequestBody FeedbackModel feedback, @PathVariable Long cust_id) {
		complaintService.provideFeedback(feedback, cust_id);
		return "Feedback addedd";
	}
	

}
