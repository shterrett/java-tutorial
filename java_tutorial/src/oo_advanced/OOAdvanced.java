package oo_advanced;

public class OOAdvanced {
    public static void main(String[] args) {
        final CarSale cs1 = new CarSale("honda", 5000, 0.05);
        final CarSale cs2 =  new CarSale("vw", 15000, 0.25);
        final PaperclipSale ps1 = new PaperclipSale("red",1.50,3,0.10);
        final PaperclipSale ps2 = new PaperclipSale("green", 2.50, 2, 0.15);
        final Sale[] sales = { cs1, cs2, ps1, ps2 };
        final Sale cheapest = Sale.cheapest(sales);
        final double totalPrice = Sale.totalCost(sales);
        System.out.println(cheapest);
        System.out.println(totalPrice);

        int heads = 0;
        int tails = 0;
        for (int i = 0; i < 1000; i++) {
            if (Coin.flip() == Coin.HEADS) {
                heads += 1;
            } else {
                tails += 1;
            }
        }

        System.out.format("Heads: %d; Tails: %d\n", heads, tails);
    }
}
