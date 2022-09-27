package com.abc_telecom_Ltd.service;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc_telecom_Ltd.entity.Complaint;
import com.abc_telecom_Ltd.entity.Customer;
import com.abc_telecom_Ltd.exceptions.ComplaintNotPresentException;
import com.abc_telecom_Ltd.model.AssingEngineerToComplaintModel;
import com.abc_telecom_Ltd.model.FeedbackModel;
import com.abc_telecom_Ltd.model.UpdateStatusModel;
import com.abc_telecom_Ltd.repository.ComplaintRepository;
import com.abc_telecom_Ltd.repository.CustomerReposisoty;

@Service
public class ComplaintImp implements ComplaintService {

	@Autowired
	private ComplaintRepository complaintRepository;

	@Autowired
	private CustomerReposisoty customerReposisoty;

	@Override
	public Complaint raiseComplaint(Complaint complaint) {
		Customer customer = customerReposisoty.findById(complaint.getCustomer()).get();
		customer.setTicket(UUID.randomUUID().toString());
		return complaintRepository.save(complaint);
	}

	@Override
	public Complaint viewComplaint(Long cust_id) throws Exception {
		Complaint complaint = complaintRepository.findByCustomer(cust_id);
		if(Objects.isNull(complaint)) {
			throw new ComplaintNotPresentException();
		}
		return complaint;
	}

	@Override
	public void provideFeedback(FeedbackModel feedback, Long cust_id) throws Exception {
		// get complaint from DB byCustomerId
		Complaint complaint = complaintRepository.findByCustomer(cust_id);
		if (Objects.nonNull(complaint)) {
			// update feedback and save
			complaint.setFeedback(feedback.getFeedback());
			complaintRepository.save(complaint);
		} else {
			throw new ComplaintNotPresentException();
		}
	}

	@Override
	public List<Complaint> viewComplaints(Long pin_code) {
		return complaintRepository.findAllByPinCode(pin_code);
	}

	@Override
	public void assignEngineer(AssingEngineerToComplaintModel assing) throws Exception {
		//get complaint from DB
		Complaint complaint = complaintRepository.findById(assing.getComplaintId()).get();
		if(Objects.isNull(complaint)) {
			throw new ComplaintNotPresentException();
		}
		//Assign Engineer only if, status is raised
		if(complaint.getStatus().equalsIgnoreCase("Raised")) {	
			complaint.setEngineer(assing.getEngineerId());
			complaintRepository.save(complaint);
		}
	}

	@Override
	public List<Complaint> viewAllComplaints(Long eng_id) {
		return complaintRepository.findByEngineer(eng_id);
	}

	@Override
	public Complaint updateStatus(UpdateStatusModel status) {
		//get complaint
		Complaint complaint = complaintRepository.findById(status.getComplaintId()).get();
		//update complaint
		complaint.setStatus(status.getStatus());
		return complaintRepository.save(complaint);
	}


}
