package lambdas;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    final static String[] WORDS = {
            "hello",
            "goodbye",
            "right",
            "left"
    };

    public static void main(String[] args) {
        sorting();
        final String best = TwoStringPred.betterString("hello", "goodbye", (a, b) -> a.charAt(0) < b.charAt(0));
        System.out.format("Best string is %s%n", best);
        final String best_2 = TwoElemPred.betterElem("hello", "goodbye", (a, b) -> a.charAt(0) < b.charAt(0));
        System.out.format("Best generic string is %s%n", best_2);
        final Integer best_3 = TwoElemPred.betterElem(1, 5, (a, b) -> a > b);
        System.out.format("Best generic int is %s%n", best_3);

        System.out.format("Words with 5 letters: %s%n",
                allMatches(Arrays.asList(WORDS), (w) -> w.length() == 5));

        System.out.format("Word lengths: %s%n",
                transform(Arrays.asList(WORDS), String::length));
    }

    private static void sorting() {
        Arrays.sort(WORDS, (a, b) -> a.length() - b.length());
        System.out.format("By Length: %s%n", Arrays.asList(WORDS));

        Arrays.sort(WORDS, (a, b) -> b.length() - a.length());
        System.out.format("By Shorth: %s%n", Arrays.asList(WORDS));

        Arrays.sort(WORDS, (a, b) -> a.charAt(0) - b.charAt(0));
        System.out.format("By first character %s%n", Arrays.asList(WORDS));

        Arrays.sort(WORDS, Main::containsE);
        System.out.format("By containing 'e' %s%n", Arrays.asList(WORDS));
    }

    private static int containsE(String a, String b) {
        if (a.contains("e") && b.contains("e")) {
            return 0;
        } else if (a.contains("e")) {
            return -1;
        } else {
            return 1;
        }
    }

    private static <T> List<T> allMatches(List<T> haystack, Predicate<T> needle) {
        return haystack.stream()
                .filter(needle)
                .collect(Collectors.toList());
    }

    private static <T, U> List<U> transform(List<T> xs, Function<T, U> f) {
        return xs.stream()
                .map(f)
                .collect(Collectors.toList());
    }
}
