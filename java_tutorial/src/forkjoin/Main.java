package forkjoin;

public class Main {
    private static final double ONE_BILLION = 1_000_000_000;

    public static void main(String[] args) {
        for (int i = 10; i <= 1_000_000; i = i * i) {
            System.out.format("Primes less than %d%n", i);
            final Op serial = new Serial(0, i);
            final Op parallel = new Parallel(0, i);
            time(serial);
            time(parallel);
        }
    }

    private static void time(Op operation) {
        long start = System.nanoTime();
        operation.run();
        long end = System.nanoTime();
        double elapsed = (end - start) / ONE_BILLION;
        System.out.format("Finished in %f seconds%n", elapsed);
    }
}
