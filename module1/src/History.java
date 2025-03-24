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
    public static void showCompletedOrders() {
        for (Order order : orders) {
            if (order.getOrder()) {
                order.printOrder();
            }
        }
    }

    public static void showNotFinished() {
        for (Order order : orders) {
            if (!order.getOrder()) {
                order.printOrder();
            }
        }
    }

    // metode til at lave en ordre complete
    public static boolean finishedOrder(int costumerId) {
        boolean inList = false;
        for (Order order : orders) {
            if (order.getOrderId() == costumerId) {
                inList = true;
                order.completeOrder();
                System.out.println("ordre " + order.getOrderId() + " er afsluttet :-)");

            }
        }
        if (!inList) {
            System.out.println("Det matcher ikke med et ID i listen");
        }
        return inList;
    }

    public static boolean checkIfOrderListIsEmpty() {
        for (Order order : orders) {
            if (!order.getOrder()) {
                return true;
            }
        }
        return false;
    }

    // show incomplete orders
    //skal kunne sorteres

}
