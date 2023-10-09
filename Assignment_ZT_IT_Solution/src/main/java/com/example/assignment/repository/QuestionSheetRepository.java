package com.example.assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.assignment.entity.QuestionSheet;

public interface  QuestionSheetRepository extends JpaRepository<QuestionSheet, Integer> {
 	
	public QuestionSheet findByQuestionIdAndCorrectAnswer(Integer questionId, String correctAnswer);
}

