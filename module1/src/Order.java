import java.time.LocalDateTime;
import java.util.ArrayList;

public class Order {
    private ArrayList<OrderLine> orderLines = new ArrayList<>();
    // name : isReadyForPickUp
    private String customerName = "";
    private int sum = 0;
    private boolean isComplete = false;
    private int orderId;
    private static int nextOrderId = 1;



    // tid
    private LocalDateTime time;
    private int tid = 1800;

    // lave konstruktør
    //ordre med navn (telefonisk)

    //ordre uden navn (i butikken)
    public Order(){
        if (nextOrderId < 1000){
        orderId = nextOrderId++;
        } else {
            nextOrderId = 1;
            orderId = nextOrderId;
        }
    }

    // getter og setter for id og navn

    public void setCustomerName(String customerName){
        this.customerName = customerName;
    }

    public void setOrderId(int orderId){
        this.orderId = orderId;
    }

    public String getCustomerName(){
        return customerName;
    }

    public int getOrderId(){
        return orderId;
    }

    //metode, der tilføjer en orderline til vores orderlines
    public void addToOrderLines(int quantity, Product product) {
        OrderLine orderline = new OrderLine(quantity, product);
        orderLines.add(orderline);
        sum += orderline.getPrice();
    }


    //
        

    // toString der gør printen pæn
    public void printOrder(){
        System.out.println("Order: " + orderId);
        System.out.println("----------------------");
        if (!customerName.isEmpty()){
            System.out.println("Navn: " + customerName  );
            System.out.println("---------------");

        }
        for (OrderLine orderLine : orderLines){
            System.out.println(orderLine.getQuantity() + "x " + orderLine.getName() + " " +orderLine.getPrice()+ ",-");
        }
        System.out.println("Total: " + sum + ",-");
        System.out.println("-----------------");
        System.out.println();
    }

    public ArrayList<OrderLine> getOrderLines(){
        return orderLines;
    }

    public void completeOrder(){
        isComplete = true;
    }

    public boolean getOrder(){
       return isComplete;
    }

    /* 2: Show order
    Order ID: 1
    Navn:           Anders
    OrderLines:
                    3x Pepperoni * 90
                    2x Vesuvio * 80
    Sum:            140 DKK

    Order ID: 2
    Navn: Henrik
    OrderLines:
            1x Calezone * 120
    Sum: 120 DKK

    Type number to edit order
    Press 'Enter'-key to return

     */
}