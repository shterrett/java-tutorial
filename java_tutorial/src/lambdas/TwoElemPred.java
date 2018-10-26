package lambdas;

public interface TwoElemPred<T> {
    static <T> T betterElem(T a, T b, TwoElemPred<T> comparator) {
        if (comparator.better(a, b)) {
            return a;
        } else {
            return b;
        }
    }

    boolean better(T a, T b);
}
