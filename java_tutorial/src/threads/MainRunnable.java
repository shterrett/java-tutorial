package threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MainRunnable implements Runnable {
    public void startThreads() {
        final ExecutorService tasks = Executors.newFixedThreadPool(4);
        for (int i = 0; i < 4; i++) {
            tasks.execute(this);
        }
        tasks.shutdown();
        try {
            tasks.awaitTermination(60, TimeUnit.SECONDS);
        } catch (InterruptedException _e) {}
        System.out.println("\nFinished flipping myself");
    }

    public void run() {
        int consecutiveHeads = 0;

        for (int i = 0; i < 1000; i++) {
            final Coin result = flip();
            if (result == Coin.HEADS) {
                consecutiveHeads += 1;
            } else {
                consecutiveHeads = 0;
            }

            if (consecutiveHeads >= 3) {
                System.out.format(
                        "%s: %d consecutive heads at flip %d%n",
                        Thread.currentThread().getName(),
                        consecutiveHeads,
                        i
                );
                consecutiveHeads = 0;
            }
        }
    }

    private Coin flip() {
        if (Math.random() > 0.5) {
            return Coin.HEADS;
        } else {
            return Coin.TAILS;
        }
    }

    private enum Coin {
        HEADS, TAILS
    }
}
