package com.sample.prime.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sample.prime.service.PrimeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;

@RestController
public class PrimeController {

	@Autowired
    private PrimeService primeService;
	
	@Operation(summary = "Get the sum of prime numbers")
	@GetMapping("/sumOfPrimes")
	public long sumOfPrimes(@Parameter(description = "Enter the value to be searched not exceeding 10 million") 
	  @RequestParam int number)
	{
		long sumValue = primeService.getSumOfPrimes(number);
		return sumValue;
		
	}
}
