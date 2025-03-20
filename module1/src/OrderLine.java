import java.util.ArrayList;
import java.util.Scanner;

public class OrderLine {

    private int quantity;
    private Product product;
    private int price;
    private String name;

    // laver konstruktør

    public OrderLine(int quantity, Product product) {
        this.quantity = quantity;
        this.product = product;
        this.price = product.getPrice() * quantity;
        this.name = product.getName();
    }

    // laver getter

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getName(){
        return name;
    }

    //   laver en toString metode
    public String toString(){
        return quantity +" " +product.getName() +" " + price;
    }

}
