package forkjoin;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Parallel extends RecursiveTask<List<Integer>> implements Op {
    private static int MAX_SEQUENTIAL = 25;

    private final int lowerBound;
    private final int upperBound;

    public Parallel(int lowerBound, int upperBound) {
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
    }

    public void run() {
        System.out.format("Parallel Primes: %s%n", compute());
    }

    public List<Integer> compute() {
        if (upperBound - lowerBound > MAX_SEQUENTIAL) {
            return runParallel();
        } else {
            return runSequential();
        }
    }

    private List<Integer> runParallel() {
        final int middle = lowerBound + (upperBound - lowerBound) / 2;
        final Parallel left = new Parallel(lowerBound, middle);
        final Parallel right = new Parallel(middle, upperBound);
        left.fork();
        final List<Integer> rightHalf = right.compute();
        final List<Integer> leftHalf = left.join();
        return combine(leftHalf, rightHalf);
    }

    private List<Integer> runSequential() {
        final Serial serial = new Serial(lowerBound, upperBound);
        return serial.findPrimes();
    }

    private List<Integer> combine(List<Integer> left, List<Integer> right) {
        return Stream.concat(left.stream(), right.stream()).collect(Collectors.toList());
    }
}
