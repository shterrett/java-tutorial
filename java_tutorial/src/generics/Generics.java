package generics;

import java.util.ArrayList;
import java.util.List;

public class Generics {
    public static void main(String[] args) {
        List<Integer> ints = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            ints.add(i);
        }
        System.out.format("Last int is %d%n", Generics.last(ints));

        Integer[] otherInts = { 100, 101, 102, 103, 104, 105 };
        System.out.format("Last int is %d%n", Generics.last(otherInts));

        Pair<String, Integer> pair = new Pair("hi", 2);
        System.out.format("Pair %s has first value %s and second value %d%n", pair, pair.fst(), pair.snd());

        Generics.alignBalances("Juanita", 2345678.99);
        Generics.alignBalances("Juan", 15455.26);
    }

    public static <E> E last(List<E> xs) {
        return xs.get(xs.size() - 1);
    }
    public static <E> E last(E[] xs) {
        return xs[xs.length - 1];
    }

    public static void alignBalances(String name, double balance) {
        System.out.format("%7s's bank account balance is $%10.2f%n", name, balance);
    }
}
