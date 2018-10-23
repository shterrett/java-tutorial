package generics;

public class Pair<F,S> {
    private F first;
    private S second;

    public Pair(F first, S second) {
       this.first = first;
       this.second = second;
    }

    public F fst() {
        return this.first;
    }

    public S snd() {
        return this.second;
    }

    public String toString() {
        return String.format("( %s, %s )", this.first, this.second);
    }
}
