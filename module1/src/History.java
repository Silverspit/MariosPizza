import java.util.ArrayList;

public class History {
    private static ArrayList<Order> orders = new ArrayList<>();

    public static void addToOrders(Order order) {
        orders.add(order);
    }

    //Show order menu
    public static void showOrders() {
        for (Order order : orders) {
            order.printOrder();
        }
    }

    // show complete orders
    public static void showCompleteOrders() {
        for (Order order : orders) {
            if (order.getOrder()) {
                order.printOrder();
            }
        }
    }

// metode til at lave en ordre complete
    public static void finishedOrder(int costumerId) {
        for (Order order : orders) {
            if (order.getOrderId() == costumerId) {
                order.completeOrder();
            }
        }
    }

    // show incomplete orders
    //skal kunne sorteres

}
