package forkjoin;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Serial implements Op {
    private final int lowerBound;
    private final int upperBound;

    public Serial(int lowerBound, int upperBound) {
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
    }

    public void run() {
        System.out.format("Serial Primes: %s%n", findPrimes());
    }

    public List<Integer> findPrimes() {
        return IntStream.range(lowerBound, upperBound)
                .filter(Primes::isPrime)
                .boxed()
                .collect(Collectors.toList());
    }

}
