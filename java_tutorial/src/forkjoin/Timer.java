package forkjoin;

public class Timer {
    private static final double ONE_BILLION = 1_000_000_000;

    public static void time(Op operation) {
        long start = System.nanoTime();
        operation.run();
        long end = System.nanoTime();
        double elapsed = (end - start) / ONE_BILLION;
        System.out.format("Finished in %f seconds%n", elapsed);
    }
}
