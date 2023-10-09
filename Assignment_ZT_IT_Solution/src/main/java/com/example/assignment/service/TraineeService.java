package com.example.assignment.service;


import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.assignment.entity.Trainee;
import com.example.assignment.repository.TraineeRepository;
import com.example.assignment.response.Response;

@Service
public class TraineeService {
	@Autowired
	private TraineeRepository traineerepo;
	private static Pattern Email_Regex =  Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",Pattern.CASE_INSENSITIVE);
	
	//Service To Add Trainee Information
	
	public Response addTrainee(Trainee trainee) {
		
		Response respon = new Response();
		
		//check data validation before save the data
		
		if(trainee.getName().equals("")) {
		 respon.setStatus("Failed to Store Data");
		 respon.setAlertMessage("Sorry You Do not follow Proper ways to Add The Data");
		 return respon;
		}
		else if(trainee.getPassword().equals("")) {
			respon.setStatus("Failed");
			 respon.setAlertMessage("Sorry You Do not follow Proper ways to Add The Data");
			 return respon;
		}
		else if(trainee.getEmail().equals("")) {
			respon.setStatus("Failed");
			 respon.setAlertMessage("Sorry You Do not follow Proper ways to Add The Data");
			 return respon;
			
		}
		
		Trainee traine= traineerepo.save(trainee);
		
	
	// Response Here Show a Response after successfully  Added The Data
	
	if(traine!=null) {
		respon.setStatus("Success");
		respon.setAlertMessage("Congratualtions You Successfully Registered");
		
	}
	else {
		respon.setStatus("Fail");
		respon.setAlertMessage("Sorry! Try To Proper way for Registration");
	}
	return respon;

	} 
	// Service Method for show The Data 
	public List<Trainee> allregisteredTrainee(){
		return traineerepo.findAll();
		
	}
	//Get By Id 
	public Trainee getTraineeById(Integer traineeId) {
		return  traineerepo.findById(traineeId).get();
	}
	// The Method used To Update Data 
	public Trainee updateById( Trainee trainee, Integer traineeId) {
		 return traineerepo.save(trainee);
	}
	
	// Method For Delete Data 
	public void delete( Integer traineeId) {
	 traineerepo.deleteById(traineeId);
	} 
	
	// Trainee Login
	
	public Trainee traineeLogin(Trainee trainee) {
		return traineerepo.findByUsernameAndPassword(trainee.getUsername(), trainee.getPassword());
	}
	
}
