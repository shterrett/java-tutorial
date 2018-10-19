package oo_advanced;

import lombok.Getter;

public class CarSale implements Sale {
   @Getter private final String model;
   @Getter private final double listPrice;
   @Getter private final double discount;

   public CarSale(String model, double listPrice, double discount) {
       this.model = model;
       this.listPrice = listPrice;
       this.discount = discount;
   }

   @Override
   public String toString() {
       return String.format("Model: %s\nList Price: %f\nDiscount: %f%%\n",
               getModel(),
               getListPrice(),
               getDiscount() * 100
       );
   }

   public double totalPrice() {
       return getListPrice() * getDiscount();
   }
}
