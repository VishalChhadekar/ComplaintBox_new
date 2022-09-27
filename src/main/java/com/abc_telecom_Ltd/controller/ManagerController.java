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
import com.abc_telecom_Ltd.entity.Engineer;
import com.abc_telecom_Ltd.exceptions.ComplaintNotPresentException;
import com.abc_telecom_Ltd.exceptions.EngineerNotPresentException;
import com.abc_telecom_Ltd.model.AssingEngineerToComplaintModel;
import com.abc_telecom_Ltd.service.ComplaintService;
import com.abc_telecom_Ltd.service.EngineerService;

@RestController
@RequestMapping("/manager")
public class ManagerController {
	// LOGIN

	@Autowired
	private ComplaintService complaintService;

	@Autowired
	private EngineerService engineerService;

	// VIEW COMPLAINTS: BY PINCODE
	
	@GetMapping("/viewComplaints/{pin_code}")
	public ResponseEntity<List<Complaint>> viewComplaints(@PathVariable Long pin_code) throws Exception {
		List<Complaint> complaints = complaintService.viewComplaints(pin_code);
		if (complaints.isEmpty()) {
			throw new ComplaintNotPresentException("No complaint presents for this pin code.");
		}
		return new ResponseEntity<List<Complaint>>(complaints, HttpStatus.OK);
	}

	// VIEW ALL ENGINEERS
	
	@GetMapping("/viewEngineers")
	public ResponseEntity<List<Engineer>> viewEngineers() throws Exception {
		List<Engineer> engineers = engineerService.viewEngineers();
		if (engineers.isEmpty()) {
			throw new EngineerNotPresentException();
		}
		return new ResponseEntity<List<Engineer>>(engineers, HttpStatus.OK);
	}

	// ASSIGN ENGINEER
	
	@PostMapping("/assignEngineer")
	public ResponseEntity<String> assignEngineer(@RequestBody AssingEngineerToComplaintModel assing) throws Exception {
		complaintService.assignEngineer(assing);
		return new ResponseEntity<String>("Engineer Assigned", HttpStatus.OK);
	}

}
