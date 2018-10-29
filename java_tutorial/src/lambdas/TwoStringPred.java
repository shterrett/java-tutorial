package lambdas;

@FunctionalInterface
public interface TwoStringPred {
    static String betterString(String a, String b, TwoStringPred comparator) {
        if (comparator.better(a, b)) {
            return a;
        } else {
            return b;
        }
    }

    boolean better(String a, String b);
}
