import java.util.ArrayList;
import java.util.Scanner;

public class OrderLine {

 private int quantity;
 private Product product;
 private int price;

 // laver konstruktør

    public OrderLine(int quantity,Product product ){
        this.quantity = quantity;
        this.product = product;
        this.price = product.getPrice() * quantity;
    }

    // laver getter

    public int getPrice(){
      return price;
    }

    public int getQuantity(){
        return quantity;
    }

    //

}
