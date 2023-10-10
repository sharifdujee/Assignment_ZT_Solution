package com.example.assignment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.assignment.entity.QuestionSheet;
import com.example.assignment.response.Response;
import com.example.assignment.service.QuestionSheetService;
@RestController
public class QuestionSheetController {
	@Autowired 
	// make a variable for service class.
	private QuestionSheetService questionservice;

	// The method used to create Data 
	@PostMapping ("/savequestion")
	public Response addQuestionResponse(@RequestBody QuestionSheet qSheet) {
		return  questionservice.addquestion(qSheet);
	}
	
	
	// Controller Method to retrieve data to check whether the question is correct or incorrect. 
	@GetMapping("/check-answer")
	public boolean addQuestionResponse(@RequestParam Integer qid, String ans) {
		return  questionservice.isCorrect(qid,ans);
	}
	
	@DeleteMapping("/delete_question/{question_id}")
	private void deletequestion(@PathVariable("question_id") Integer question_id) {
		questionservice.question_delete(question_id);
	}
}



