package fileio;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        final String firstTenLetterString = dictionary((words) ->
                        words.filter(w -> w.length() == 10)
                                .findFirst()
                                .orElse("")
                );
        System.out.format("First 10 letter word: %s%n", firstTenLetterString);

        final String abcEightLetters = dictionary((words) ->
                words.filter(w -> w.length() == 8)
                    .map(String::toLowerCase)
                    .filter(w -> w.contains("a") || w.contains("b") || w.contains("c"))
                    .findFirst()
                    .orElse("")
        );
        System.out.format("First 8 character string containing a, b, or c: %s%n", abcEightLetters);

        final String longAorEless = dictionary((words) ->
                words.map(String::toLowerCase)
                .filter(w -> !w.contains("a"))
                .filter(w -> !w.contains("e"))
                .max(Comparator.comparingInt(String::length))
                .orElse("")
        );
        System.out.format("Longest word without a or e: %s%n", longAorEless);

        final  String shortQful = dictionary((words) ->
                words.map(String::toLowerCase)
                .filter(w -> w.contains("q"))
                .min(Comparator.comparingInt(String::length))
                .orElse("")
        );
        System.out.format("Shortest word with a q: %s%n", shortQful);


        try (PrintWriter w = new PrintWriter(Files.newBufferedWriter(Paths.get("test-write.txt")))) {
            Random rand = new Random();
                DoubleStream.generate(() -> rand.nextDouble() * 100)
                        .limit(17)
                        .forEach(d -> {
                            w.printf("%.3f%n", d);
                        });
        } catch (IOException e) {
            System.out.println(e);
        }

    }

    private static <T> T dictionary(Function<Stream<String>, T> f) {
       try (Stream<String> words = Files.lines(Paths.get("/usr/share/dict/words"))) {
            return f.apply(words);
       } catch (IOException e) {
           System.out.println(e);
           return f.apply(Stream.empty());
       }
    }
}
