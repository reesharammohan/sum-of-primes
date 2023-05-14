package com.sample.prime.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sample.prime.response.PrimeResponse;
import com.sample.prime.service.PrimeService;

@SpringBootTest
public class PrimeApplicationTests {

	@Autowired
	PrimeService primeService;
	
	
	@Test
	public void testPrimeSum_ForLessThanTenMillion() {
		
		PrimeResponse expectedResponse = new PrimeResponse();
		expectedResponse.setMessage("Sum Value calculated successfully!");
		expectedResponse.setResult(3682913);
		PrimeResponse actualResponse = primeService.getSumOfPrimes(1000);
		assertEquals(expectedResponse.getResult(), actualResponse.getResult());
		assertEquals(expectedResponse.getMessage(), actualResponse.getMessage());
	}

	@Test
	public void testPrimeSum_ForMoreThanTenMillion() {
		
		PrimeResponse expectedResponse = new PrimeResponse();
		expectedResponse.setMessage("Input value should be less than 10 million");
		expectedResponse.setResult(0);
		PrimeResponse actualResponse = primeService.getSumOfPrimes(100000000);
		assertEquals(expectedResponse.getResult(), actualResponse.getResult());
		assertEquals(expectedResponse.getMessage(), actualResponse.getMessage());
	}
}
