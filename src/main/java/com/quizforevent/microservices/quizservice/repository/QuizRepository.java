package com.quizforevent.microservices.quizservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quizforevent.microservices.quizservice.domain.Quiz;

public interface QuizRepository extends JpaRepository<Quiz, Long> {

}
