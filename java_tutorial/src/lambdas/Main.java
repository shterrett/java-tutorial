package lambdas;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        sorting();
        final String best = TwoStringPred.betterString("hello", "goodbye", (a, b) -> a.charAt(0) < b.charAt(0));
        System.out.format("Best string is %s%n", best);
        final String best_2 = TwoElemPred.betterElem("hello", "goodbye", (a, b) -> a.charAt(0) < b.charAt(0));
        System.out.format("Best generic string is %s%n", best_2);
        final Integer best_3 = TwoElemPred.betterElem(1, 5, (a, b) -> a > b);
        System.out.format("Best generic int is %s%n", best_3);
    }

    private static void sorting() {
        final String[] words = {
                "hello",
                "goodbye",
                "right",
                "left"
        };

        Arrays.sort(words, (a, b) -> a.length() - b.length());
        System.out.format("By Length: %s%n", Arrays.asList(words));

        Arrays.sort(words, (a, b) -> b.length() - a.length());
        System.out.format("By Shorth: %s%n", Arrays.asList(words));

        Arrays.sort(words, (a, b) -> a.charAt(0) - b.charAt(0));
        System.out.format("By first character %s%n", Arrays.asList(words));

        Arrays.sort(words, (a, b) -> {
            if (a.contains("e") && b.contains("e")) {
                return 0;
            } else if (a.contains("e")) {
                return -1;
            } else {
                return 1;
            }
        });
        System.out.format("By containing 'e' %s%n", Arrays.asList(words));
    }
}
