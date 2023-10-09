package com.example.assignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.assignment.entity.Trainee;
import com.example.assignment.response.Response;
import com.example.assignment.service.TraineeService;

@RestController
//Combination of  @Controller and @ResponseBody  annotations that results in web requests returning data

public class TraineeController {
	@Autowired
	private TraineeService traineeService;
	
	@PostMapping("/registerTrainee")
	public Response addResponse(@RequestBody Trainee trainee) {
		return traineeService.addTrainee(trainee);
		
	}
	
	//Show 
	@GetMapping ("/showallRegisterTrainee")
	public List<Trainee> showallRegisterTrainee(){
		return traineeService.allregisteredTrainee();

}
	
	//Get By ID
	@GetMapping("/showById/{traineeId}")
	private Trainee traineebyId(@PathVariable("traineeId") Integer traineeId) {
		return  traineeService.getTraineeById(traineeId);
		
	}
	
	//update By Id
	@PutMapping ("/updateTrainee")
	private Trainee updateTrainee(@RequestBody Trainee trainee, Integer traineeId) {
		traineeService.updateById(trainee, traineeId);
		
		return trainee;
	}
	
	
	//Delete 
	@DeleteMapping ("/traineedelete/{traineeId}")
	private void deleteTrainee(@PathVariable("traineeId") Integer traineeId) {
		traineeService.delete(traineeId);
		
	}
	
	//Login Method 
	
	}





