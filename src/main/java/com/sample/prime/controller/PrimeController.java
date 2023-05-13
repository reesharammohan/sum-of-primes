package com.sample.prime.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sample.prime.response.PrimeResponse;
import com.sample.prime.service.PrimeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;

@RestController
public class PrimeController {
	
	// Initialize logger
	private static final Logger LOGGER = LoggerFactory.getLogger(PrimeController.class.getName());

	@Autowired
    private PrimeService primeService;
	
	@Operation(summary = "Get the sum of prime numbers")
	@GetMapping("/sumOfPrimes")
	public PrimeResponse sumOfPrimes(@Parameter(description = "Enter the value to be searched not exceeding 10 million") 
	  @RequestParam int number)
	{
		long beginTime = System.currentTimeMillis();
		PrimeResponse primeResponse = primeService.getSumOfPrimes(number);
		LOGGER.info("Sum of primes time taken: " + (System.currentTimeMillis() - beginTime));
		return primeResponse;
		
	}
}
