package streams;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Main {
    private static final String[] WORDS = {
            "snow",
            "eggnog",
            "friendly",
            "future",
            "self",
            "spy",
            "questionable",
            "dead",
            "spade",
            "perpetual",
            "faulty",
            "subsequent"
    };

    public static void main(String[] args) {
        Stream.of(WORDS).forEach(w -> System.out.format("  %s%n", w));
        Stream.of(WORDS).forEach(System.out::println);
        System.out.println(Stream.of(WORDS).map(w -> w + "!").collect(toList()));
        System.out.println(Stream.of(WORDS).map(w -> w.replace("i", "eye")).collect(toList()));
        System.out.println(Stream.of(WORDS).map(String::toUpperCase).collect(toList()));
        System.out.println(Stream.of(WORDS).filter(w -> w.length() < 4).collect(toList()));
        System.out.println(Stream.of(WORDS).filter(w -> w.contains("b")).collect(toList()));
        System.out.println(Stream.of(WORDS).filter(w -> w.length() % 2 == 0).collect(toList()));

        Stream.of(WORDS)
                .map(String::toUpperCase)
                .filter(w -> w.contains("E"))
                .forEach(System.out::println);

        System.out.println(Stream.of(WORDS).toArray(String[]::new));

        System.out.println(
                Stream.of(WORDS)
                        .reduce("", (ws, w) -> ws + w.toUpperCase())
        );

        System.out.println(
                Stream.of(WORDS)
                        .map(String::toUpperCase)
                        .reduce("", String::concat)
        );

        System.out.println(
                Stream.of(WORDS)
                        .reduce((ws, w) -> ws + ", " + w)
                        .orElse("")
        );

        System.out.format("Total chars: %d%n",
                Stream.of(WORDS)
                        .map(String::length)
                        .reduce(0, Integer::sum)
        );

        System.out.println(
                Stream.of(WORDS)
                        .filter(w -> w.contains("u"))
                        .count()
        );
    }
}
