import java.util.ArrayList;

public class Order {
    private ArrayList<OrderLine>orderLines = new ArrayList<>();
    private boolean pickUp = false;

    //metode, der tilføjer en orderline til vores orderlines
    public void addToOrderLines(int quantity, Product product) {
        OrderLine orderLine = new OrderLine(quantity, product);
        orderLines.add(orderLine);
    }
    //metode for afhentning af orders
    public void pickedUp(){

    }

}