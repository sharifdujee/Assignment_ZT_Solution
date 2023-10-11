package com.example.assignment.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.assignment.entity.Trainee;
import com.example.assignment.repository.TraineeRepository;
import com.example.assignment.response.Response;

@Service
public class TraineeService {
	Response response = new Response();
	@Autowired
	private TraineeRepository traineerepo;

	// Service To Add Trainee Information

	public Response addTrainee(Trainee trainee) {

		// create an object for Response Class.
		Response respon = new Response();

		// check data validation Using Regular Expression before save the data

		// create variables to check email validation.
		Pattern p = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,}$", Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(trainee.getEmail());
		Pattern password = Pattern.compile("^[A-Z0-9]+@[A-Z0-9]{6,12}$", Pattern.CASE_INSENSITIVE);
		Matcher passwordmatch = password.matcher(trainee.getPassword());

		if (trainee.getName().equals("")) {
			respon.setStatus("Fail");
			respon.setAlertMessage("The Name Field Is Required Mininum 6 character is Needed");
			return respon;
		} else if (trainee.getUsername().equals("")) {
			respon.setStatus("Fail");
			respon.setAlertMessage("Null Value is Not Allowed");
			return respon;
		}

		else if (trainee.getPassword().equals("") || !passwordmatch.matches()) {
			respon.setStatus("Fail");
			respon.setAlertMessage("The Password Field is Required");
			return respon;
		} else if (!m.matches()) {
			respon.setStatus("Fail");
			respon.setAlertMessage("Give The Correct Email Account Follow The Standard Email Pattern");
			return respon;

		}

		Trainee traine = traineerepo.save(trainee);

		// Response Here Show a Response after successfully Added The Data

		if (traine != null) {
			respon.setStatus("Success");
			respon.setAlertMessage("Congratualtions You Successfully Registered");
			trainee.setEmail(trainee.getEmail());
			trainee.setName(trainee.getName());

		} else {
			respon.setStatus("Fail");
			respon.setAlertMessage("Sorry! Try To Proper way for Registration");
		}
		return respon;

	}

	// Service Method for show The Data
	public List<Trainee> allregisteredTrainee() {
		Response response = new Response();
		response.setStatus("Trainee Id was Not Found");
		response.setAlertMessage("Please enter a Id That exist on databases");
		return traineerepo.findAll();

	}

	// Get By Id
	public Trainee getTraineeById(Integer traineeId) {
		Response response = new Response();
		response.setStatus("Trainee Id was Not Found");
		response.setAlertMessage("Please enter a Id That exist on databases");
		return traineerepo.findById(traineeId).get();
	}

	// Method For Delete Data
	public Response delete(Integer traineeId) {
		Response respon = new Response();
		traineerepo.deleteById(traineeId);
		response.setAlertMessage("Your Data is Successfully Remove");
		return respon;

	}

	// Trainee Login
	public Response userlogin(Trainee trainee) {
		Response repond = new Response();

		Trainee authcheck = traineerepo.findByEmailAndPassword(trainee.getEmail(), trainee.getPassword());
		if (authcheck != null) {
			repond.setAlertMessage("Login Success");
			repond.setStatus("Sucess");
			return repond;
		} else {
			repond.setAlertMessage("Failed to Login");
			repond.setStatus("Fail");
			return repond;
		}
	}

	// Update

	public Trainee update_trainee(Trainee trainee) {
		Optional<Trainee> traineedata = this.traineerepo.findById(trainee.getTraineeid());
		if (traineedata.isPresent()) {
			Trainee traineeupdate = traineedata.get();
			traineeupdate.setTraineeid(trainee.getTraineeid());
			traineeupdate.setName(trainee.getName());
			traineeupdate.setUsername(trainee.getUsername());
			traineeupdate.setEmail(trainee.getEmail());
			traineeupdate.setPassword(trainee.getPassword());
			return traineeupdate;

		}
		return trainee;

	}

	// update and save

	// New way of insert using validation package of Spring Boot
	public ResponseEntity<?> traineeAdd(Trainee trainee) {

		try {
			traineerepo.save(trainee);
			Response respond = new Response();
			respond.setStatus("Fail");
			return new ResponseEntity<Response>(
					new Response("Success", "New Trainee Is Added", Collections.singletonList(trainee)),
					HttpStatus.CREATED);

		} catch (DataIntegrityViolationException e) {
			return new ResponseEntity<Response>(new Response("Error", "Already Register"), HttpStatus.CONFLICT);
			// TODO: handle exception
		}
	}

	// Show Individual Trainee Information

	public ResponseEntity<Response> showTraineeById(Integer traineeId) {
		Optional<Trainee> traineeOptional = traineerepo.findById(traineeId);
		if (traineeOptional.isPresent()) {
			Trainee trainee = traineeOptional.get();
			Response responseentity = new Response(1000, "Success", "Success to show",
					Collections.singletonList(trainee));
			return new ResponseEntity<Response>(responseentity, HttpStatus.OK);

		} else {
			Response responseentity = new Response(200, "Failed", "Not Found", Collections.emptyList());
			return new ResponseEntity<Response>(responseentity, HttpStatus.OK);
		}
	}
	
	//Update 
	
	public ResponseEntity<?>  updateTrainee(Integer traineeId, String name, String username, String email, String Password){
		try {
			Trainee trainee = traineerepo.findById(traineeId).get();
			trainee.setName(username);
			trainee.setUsername(username);
			trainee.setEmail(email);
			trainee.setPassword(Password);
			traineerepo.save(trainee);
			return new ResponseEntity <Response>(new Response("success", "Trainee Updated"), HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<Response>(new Response("error", e.toString()), HttpStatus.INTERNAL_SERVER_ERROR);
			// TODO: handle exception
		}
	}

}
