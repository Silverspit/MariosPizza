import java.time.LocalDateTime;
import java.util.ArrayList;

public class Order {
    private ArrayList<OrderLine> orderLines = new ArrayList<>();
    // name : isReadyForPickUp
    private String name;
    private int sum = 0;

    // tid
    private LocalDateTime time;
    private int tid = 1800;

    // lave konstruktør
    //ordre med navn (telefonisk)
    public Order(String name){
        this.name = name;

    }
    //ordre uden navn (i butikken)
    public Order(){}

    //metode, der tilføjer en orderline til vores orderlines
    public void addToOrderLines(int quantity, Product product) {
        OrderLine orderline = new OrderLine(quantity, product);
        orderLines.add(orderline);
        sum += orderline.getPrice();
    }

    //
        

    // toString der gør printen pæn
    public void printOrder(){
        System.out.println("----------------------");
        if (!name.isEmpty()){
            System.out.println("Navn: " + name);
            System.out.println("---------------");

        }
        for (OrderLine orderLine : orderLines){
            System.out.println(orderLine.getQuantity() + "x " + orderLine.getName() + " " +orderLine.getPrice()+ ",-");
        }
        System.out.println("Total: " + sum + ",-");
    }

    /* 2: Show order
    Order ID: 1
    Navn: Anders
    OrderLines:
            3x Pepperoni * 90
            2x Vesuvio * 80
    Sum: 140 DKK

    Order ID: 2
    Navn: Henrik
    OrderLines:
            1x Calezone * 120
    Sum: 120 DKK

    Type number to edit order
    Press 'Enter'-key to return

     */
}