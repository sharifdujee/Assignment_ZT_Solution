package com.example.assignment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.assignment.entity.QuestionSheet;
import com.example.assignment.repository.QuestionSheetRepository;
import com.example.assignment.response.Response;

@Service
public class QuestionSheetService {
	@Autowired
	private  QuestionSheetRepository  questionrepo;
	
	public Response addquestion(QuestionSheet questionsheet) {
		Response respond = new Response();
	
	
	//check validation 
		if(questionsheet.getCorrectAnswer().equals("")) {
			respond.setStatus("Fail");
			respond.setAlertMessage("Add The Correct Answer Before Add The Question ");
			return respond;
		}
		else if(questionsheet.getQuestion().equals("")) {
			respond.setStatus("Fail");
			respond.setAlertMessage(" Please Add  The Question ");
			return respond;
			
		}
		QuestionSheet savequestion = questionrepo.save(questionsheet);
		
		//response
		
		if(savequestion!=null) {
			respond.setStatus("Sucess");
			respond.setAlertMessage("Congratualtions Your Submission is Successfull");
		}
		return  respond;	 
			
	}
	
	//Create a Method To Check correct answer
	
	public boolean isCorrect(Integer questionId, String answer){
		
		QuestionSheet que = questionrepo.findByQuestionIdAndCorrectAnswer(questionId, answer);
		
		if(que != null) {
			return true;
		}
		return false;
	}
	
	
}


