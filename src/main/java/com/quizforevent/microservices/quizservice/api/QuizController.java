package com.quizforevent.microservices.quizservice.api;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quizforevent.microservices.quizservice.domain.Quiz;
import com.quizforevent.microservices.quizservice.domain.QuizAggregator;
import com.quizforevent.microservices.quizservice.repository.QuizRepository;

@RestController
public class QuizController {
	private Logger logger = LoggerFactory.getLogger(QuizController.class);

	@Autowired
	private QuizRepository quizRepository;
	
	@Autowired
	private Environment environment;
	
	@GetMapping("/quizzes")
	public ResponseEntity<List<Quiz>> getAllQuizzes() {
		try {
		    logger.info("getAllQuizzes");
			
		    String host = environment.getProperty("HOSTNAME");
			String version = "V1.2";
			String port = environment.getProperty("local.server.port");
		    
		    List<Quiz> quizzes = new ArrayList<Quiz>();
		    List<Quiz> quizzesFinal = new ArrayList<Quiz>();
		    quizRepository.findAll().forEach(quizzes::add);
		    
		    for (Quiz quiz : quizzes) {
		    	quiz.setEnvironment(port + " " + version + " " + host);
		    	quizzesFinal.add(quiz);
		    }
		    
		    if (quizzes.isEmpty()) {
		        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		    }
		      
		    return new ResponseEntity<>(quizzesFinal, HttpStatus.OK);
		      
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	}
	
	@GetMapping("/quizaggregator")
	public ResponseEntity<QuizAggregator> getQuizAggregator() {
		try {
		    logger.info("getQuizAggregator");
			
		    String host = environment.getProperty("HOSTNAME");
			String version = "V1.2";
			String port = environment.getProperty("local.server.port");
		    
		    List<Quiz> quizzes = new ArrayList<Quiz>();
		    QuizAggregator quizAggregator = new QuizAggregator();
		    int nbQuiz = 0;
		    int nbQuestion = 0;
		    String env = null;
		    
		    quizRepository.findAll().forEach(quizzes::add);
		    
		    for (Quiz quiz : quizzes) {
		    	nbQuiz = nbQuiz + 1;
		    	nbQuestion = nbQuestion + quiz.getQuestions().size();
		    }
		    
		    quizAggregator.setNbQuiz(nbQuiz);
		    quizAggregator.setNbQuestions(nbQuestion);
		    quizAggregator.setEnvironment(port + " " + version + " " + host);
		      
		    return new ResponseEntity<>(quizAggregator, HttpStatus.OK);
		      
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	}
	
	
}
