package oo_advanced;

import lombok.Getter;

public class PaperclipSale implements Sale {
   @Getter private final String color;
   @Getter private final double price;
   @Getter private final int numBoxes;
   @Getter private final double discount;

   public PaperclipSale(String color, double price, int numBoxes, double discount) {
       this.color = color;
       this.price = price;
       this.numBoxes = numBoxes;
       this.discount = discount;
   }

   @Override
    public String toString() {
       return String.format("Paperclips:\n  color: %s\n  price: %f\n  quantity: %d\n  discount: %f%%\n",
                   getColor(),
                   getPrice(),
                   getNumBoxes(),
                   getDiscount() * 100
               );
   }

   public double totalPrice() {
       return getDiscount() * getPrice() * getNumBoxes();
   }
}
