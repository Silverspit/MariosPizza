import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Order {
    private ArrayList<OrderLine> orderLines = new ArrayList<>();
    // name : isReadyForPickUp
    private String customerName = "";
    private int sum = 0;
    private boolean isComplete = false;
    private int orderId;
    private static int nextOrderId = 1;
    private String status = "\u001B[31mAktiv\u001B[0m";
    // tid
    private LocalDateTime now = LocalDateTime.now();
    private String timeOrderMade;

    // afhent tid
    private LocalDateTime pickUpTime;
    private String pickUp;

    // lave konstruktør
    //ordre med navn (telefonisk)

    //ordre uden navn (i butikken)
    public Order(DateTimeFormatter formatter) {
        timeOrderMade = now.format(formatter);

        if (nextOrderId < 1000) {
            orderId = nextOrderId++;
        } else {
            nextOrderId = 1;
            orderId = nextOrderId;
        }
    }

    public void setHowLongItTakes(int howLongItTakes) {
        pickUpTime = now.plusMinutes(howLongItTakes);
        if (pickUpTime.getMinute()<10){
            pickUp = pickUpTime.getHour() + ".0" + pickUpTime.getMinute();
        }
        else {
        pickUp = pickUpTime.getHour() + "." + pickUpTime.getMinute();
        }
    }

    public LocalDateTime getPickUpTime(){
        return pickUpTime;
    }

    // getter og setter for id og navn

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public int getOrderId() {
        return orderId;
    }

    public int getSum() {
        return sum;
    }


    //metode, der tilføjer en orderline til vores orderlines
    public void addToOrderLines(int quantity, Product product) {
        OrderLine orderline = new OrderLine(quantity, product);
        orderLines.add(orderline);
        sum += orderline.getPrice();
    }

    // toString der gør printen pæn
    public void printOrder() {
        System.out.println("Ordre: " + orderId);
        System.out.println(timeOrderMade);
        System.out.println("----------------------------");
        if (!customerName.isEmpty()) {
            System.out.println("Navn: " + customerName);
            System.out.println("----------------------------");

        }
        for (OrderLine orderLine : orderLines) {
            System.out.println(orderLine.getQuantity() + "x " + orderLine.getName() + " " + orderLine.getPrice() + ",-");
        }
        System.out.println("----------------------------");
        System.out.println("Total: " + sum + ",-");
        System.out.println("Afhentningstidspunkt: " + pickUp);
        System.out.println("----------------------------");
        System.out.println(status);
        System.out.println();
    }

    public ArrayList<OrderLine> getOrderLines() {
        return orderLines;
    }

    public void completeOrder() {
        isComplete = true;
        status = "\u001B[32mAfsluttet\u001B[0m";
    }

    public boolean getIsComplete() {
        return isComplete;
    }

}