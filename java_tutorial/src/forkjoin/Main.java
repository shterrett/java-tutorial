package forkjoin;

public class Main {

    public static void main(String[] args) {
        for (int i = 10; i <= 1_000_000; i = i * i) {
            System.out.format("Primes less than %d%n", i);
            final Op serial = new Serial(0, i);
            final Op parallel = new Parallel(0, i);
            Timer.time(serial);
            Timer.time(parallel);
        }
    }
}
