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
    private String status = "\u001B[31m" + "Aktiv" + "\u001B[0m";
    // tid
    private LocalDateTime now = LocalDateTime.now();
    private String timeOrderMade;

    // afhent tid
    private LocalDateTime pickUpTime = LocalDateTime.now();
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

    public void setHowLongItTakes(int howLongItTakes, DateTimeFormatter formatter2) {
        pickUpTime = now.plusMinutes(howLongItTakes);
        pickUp = pickUpTime.format(formatter2);

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
        int totalWitdh = 29;
        int spaces = Math.max(1, totalWitdh - status.length());
        System.out.printf("%s%" + spaces + "s%s%n","Ordre: " + orderId,"",status);
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
        System.out.println();
    }

    public ArrayList<OrderLine> getOrderLines() {
        return orderLines;
    }

    public void setComplete() {
        isComplete = true;
        status = "\u001B[32m" + "Afsluttet" + "\u001B[0m";
    }

    public boolean getIsComplete() {
        return isComplete;
    }

}