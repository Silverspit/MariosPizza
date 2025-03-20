import java.util.ArrayList;

public class Order {
    private ArrayList<OrderLine> orderLines = new ArrayList<>();
    // name : isReadyForPickUp
    private boolean pickUp = false;
    // tid

    //metode, der tilføjer en orderline til vores orderlines
    public void addToOrderLines(int quantity, Product product) {
        OrderLine orderLine = new OrderLine(quantity, product);
        orderLines.add(orderLine);
    }

    //metode for afhentning af orders, skal ligge i controller
    public void pickedUp() {
        
    }
    // toString der gør printen pæn

}