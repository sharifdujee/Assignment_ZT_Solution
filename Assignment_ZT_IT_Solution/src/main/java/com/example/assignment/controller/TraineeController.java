package com.example.assignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin(origins = "*")

//Combination of  @Controller and @ResponseBody  annotations that results in web requests returning data

public class TraineeController {
	@Autowired
	private TraineeService traineeService;

	// The api for Save Data . Follow Some rules to given input name, userName , email is required & Follow the pattern to add userName and email
//	@PostMapping("/addtrainee")
//	public ResponseEntity<?> addResponse( @Valid @RequestBody Trainee trainee) {
//		return traineeService.traineeAdd (trainee);
//
//	}
	@PostMapping ("/traineeadd")
		public Response  traineeadds(@RequestBody Trainee trainee) {
		return traineeService.addTrainee(trainee);
		
	}

	// Show
	@GetMapping("/showallRegisterTrainee")
	public List<Trainee> showallRegisterTrainee() {
		return traineeService.allregisteredTrainee();

	}

	// Get By ID
	@GetMapping("/showById/{traineeId}")
	private Trainee traineebyId(@PathVariable("traineeId") Integer traineeId) {
		return traineeService.getTraineeById(traineeId);

	}

	// Delete
	@DeleteMapping("/traineedelete/{traineeId}")
	private void deleteTrainee(@PathVariable("traineeId") Integer traineeId) {
		traineeService.delete(traineeId);

	}

	// Login Method

	@PostMapping("/traineelogin")
	private Response traineelogins(@RequestBody Trainee trainee) {
		return traineeService.userlogin(trainee);
	}

	// Update Method
	@PutMapping("/update_trainee/{traineeId}")
	public ResponseEntity<Trainee> update_Trainee(@PathVariable Integer traineeId, @RequestBody Trainee trainee) {
		trainee.setTraineeid(traineeId);
		return ResponseEntity.ok().body(this.traineeService.update_trainee(trainee));
	}
	
	// Sazzad Vai
	@GetMapping("trainee/{traineeId}")
	public  ResponseEntity<?> getTraineeById(@PathVariable ("traineeId") Integer traineeId){
		return traineeService.showTraineeById(traineeId);
	}
	
	
	

}


