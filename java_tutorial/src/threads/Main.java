package threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        separateClass();
        selfRunnable();
    }

    private static void separateClass() {
        final ExecutorService tasks = Executors.newFixedThreadPool(4);
        for (int i = 0; i < 4; i++) {
            tasks.execute(new Flipper());
        }
        tasks.shutdown();
        try {
            tasks.awaitTermination(60, TimeUnit.SECONDS);
        } catch (InterruptedException _e) {}
        System.out.println("\nFinished flipping coins");
    }

    private static void selfRunnable() {
        final MainRunnable selfRunnable = new MainRunnable();
        selfRunnable.startThreads();
    }
}
