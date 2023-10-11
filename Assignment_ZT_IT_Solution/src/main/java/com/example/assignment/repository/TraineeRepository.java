package com.example.assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.assignment.entity.Trainee;

public interface TraineeRepository extends JpaRepository<Trainee, Integer> {

	// public Trainee findByUsernameAndPassword(String username, String password);
	public Trainee findByEmailAndPassword(String email, String password);

	// public Trainee getTraineeById(Integer traineeid);
	public Trainee findBytraineeid(Integer traineeid);

}
