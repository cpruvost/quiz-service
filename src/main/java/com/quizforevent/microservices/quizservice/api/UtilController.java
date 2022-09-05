package com.quizforevent.microservices.quizservice.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quizforevent.microservices.quizservice.service.UtilService;
import com.quizforevent.microservices.quizservice.utils.Util;



@RestController
public class UtilController {
	private UtilService utilService;

	@Autowired
	public UtilController(UtilService utilService) {
		super();
		this.utilService = utilService;
	}

	@GetMapping("/edition")
	public Util getEdition() {
		return new Util(utilService.getEdition());
	}
	
}
