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
		// TODO Auto-generated method stub
		PrimeResponse primeResponse = new PrimeResponse();
		try
		{
			if(number>10000000)
			{
				primeResponse.setMessage("Input value should be less than 10 million");
			} 
			else {
				long sum = 0;
		        List<Integer> primes = new ArrayList<>();
		        primes.add(2);
		        sum += 2;
		
		        for (int i = 3; primes.size() < number; i += 2) {
		            boolean isPrime = true;
		
		            for (int j = 0; j < primes.size(); j++) {
		                int p = primes.get(j);
		
		                if (p * p > i) {
		                    break;
		                }
		
		                if (i % p == 0) {
		                    isPrime = false;
		                    break;
		                }
		            }
		
		            if (isPrime) {
		                primes.add(i);
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
