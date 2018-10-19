package oo_advanced;

public enum Coin {
    HEADS, TAILS;

    public static Coin flip() {
        if (Math.random() < 0.5) {
            return HEADS;
        } else {
            return TAILS;
        }
    }
}
