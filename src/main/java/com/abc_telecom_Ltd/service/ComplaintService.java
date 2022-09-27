package com.abc_telecom_Ltd.service;

import java.util.List;

import com.abc_telecom_Ltd.entity.Complaint;
import com.abc_telecom_Ltd.model.AssingEngineerToComplaintModel;
import com.abc_telecom_Ltd.model.FeedbackModel;
import com.abc_telecom_Ltd.model.UpdateStatusModel;

public interface ComplaintService {

	Complaint raiseComplaint(Complaint complaint);

	Complaint viewComplaint(Long cust_id);

	void provideFeedback(FeedbackModel feedback, Long cust_id);

	List<Complaint> viewComplaints(Long pin_code);

	void assignEngineer(AssingEngineerToComplaintModel assing);

	List<Complaint> viewAllComplaints(Long eng_id);

	Complaint updateStatus(UpdateStatusModel status);


}
