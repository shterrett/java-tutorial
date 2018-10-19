package oo_advanced;

public interface Sale {
    double totalPrice();

    static Sale cheapest(Sale[] sales) {
        if (sales.length == 0) {
            return null;
        }
        Sale lowest = sales[0];
        for (Sale s: sales) {
            if (s.totalPrice() < lowest.totalPrice()) {
                lowest = s;
            }
        }
        return lowest;
    }

    static double totalCost(Sale[] sales) {
        double cost = 0;
        for (Sale s: sales) {
            cost += s.totalPrice();
        }
        return cost;
    }
}
