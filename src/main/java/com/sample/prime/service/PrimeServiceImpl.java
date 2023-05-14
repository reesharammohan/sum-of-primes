package com.sample.prime.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.sample.prime.response.PrimeResponse;

@Service
public class PrimeServiceImpl implements PrimeService {
	
	// Initialize logger
	private static final Logger LOGGER = LoggerFactory.getLogger(PrimeServiceImpl.class.getName());

	@Override
	public PrimeResponse getSumOfPrimes(int number) {
		PrimeResponse primeResponse = new PrimeResponse();
		try
		{
			if(number>10000000)
			{
				primeResponse.setMessage("Input value should be less than 10 million");
			} 
			else {
				
				/* We initialize a list of prime numbers with 2 and add it to the sum. 
		        Then we loop through odd numbers starting from 3 until we have generated n prime numbers.
		        For each odd number, we check if it is divisible by any of the previously generated prime numbers.
		        If it is not divisible by any of the primes, then it is a new prime number, and we add it to the list of primes and to the sum.*/
				
				long sum = 0;
		        List<Integer> primesList = new ArrayList<>();
		        primesList.add(2);
		        sum += 2;
		        
		        for (int i = 3; primesList.size() < number; i += 2) {
		            boolean isPrime = true;
		
		            for (int j = 0; j < primesList.size(); j++) {
		                int primeNum = primesList.get(j);
		
		                if (primeNum * primeNum > i) {
		                    break;
		                }
		
		                if (i % primeNum == 0) {
		                    isPrime = false;
		                    break;
		                }
		            }
		
		            if (isPrime) {
		            	primesList.add(i);
		                sum += i;
		            }
		        }
		        
		        LOGGER.info("Sum Value calculated successfully!");
		        primeResponse.setResult(sum);
		        primeResponse.setMessage("Sum Value calculated successfully!");
			}
        
		}
		
		catch(Exception e)
		{
			LOGGER.error("Exception occured!");
			primeResponse.setMessage("Exception occured!");
		}
		
		return primeResponse;
    }
}
