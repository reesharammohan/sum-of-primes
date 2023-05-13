package com.sample.prime.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class PrimeServiceImpl implements PrimeService {

	@Override
	public long getSumOfPrimes(int number) {
		// TODO Auto-generated method stub
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

        return sum;
    }
}
