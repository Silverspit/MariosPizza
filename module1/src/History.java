import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class History {
    private static ArrayList<Order> orders = new ArrayList<>();
    private static HashMap<String, Integer> statistics = new HashMap<>();
    private static int totalSales = 0;

    public static void addToOrders(Order order) {
        orders.add(order);
        orders.sort(Comparator.comparing(Order::getPickUpTime));

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
            if (order.getIsComplete()) {
                order.printOrder();
            }
        }
        System.out.println("Ordre total: " + totalSales + ",-");
    }

    public static void showActiveOrders() {
        for (Order order : orders) {
            if (!order.getIsComplete()) {
                order.printOrder();
            }
        }
    }

    // metode til at lave en ordre complete
    public static boolean completeOrder(int costumerId) {
        boolean inList = false;
        for (Order order : orders) {
            if (order.getOrderId() == costumerId && !order.getIsComplete()) {
                inList = true;
                order.setComplete();
                for (OrderLine orderLine : order.getOrderLines()) {
                    int count = statistics.getOrDefault(orderLine.getName(), 0);
                    statistics.put(orderLine.getName(), count + orderLine.getQuantity());
                }

                totalSales += order.getSum();
                System.out.println("ordre " + order.getOrderId() + " blev afsluttet :-)");
            } else if (order.getOrderId() == costumerId && order.getIsComplete()) {
                System.out.println("ordre " + order.getOrderId() + " er allerede afsluttet :-)");
                inList = true;
            }
        }
        if (!inList) {
            System.out.println("Det matcher ikke med et ID i listen");
        }
        return inList;
    }

    public static void printStatistics() {
        for (Map.Entry<String, Integer> entry : statistics.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void printSortedStatistics() {
        statistics.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())) // Reverse order for highest first
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue() + ", Total: " + (Inventory.getProductprice(entry.getKey()) * entry.getValue())));
        System.out.println("Ordre total: " + totalSales + ",-");
    }

    public static boolean hasActiveOrders() {
        for (Order order : orders) {
            if (!order.getIsComplete()) {
                return true;
            }
        }
        return false;
    }

    public static void removeOrder(int customerId) {
        for (Order order : orders) {
            if (customerId == order.getOrderId()){
                orders.remove(order);
                System.out.println("Ordre " + order.getOrderId() + " er blevet fjernet.");
                return;
            }
        }
        System.out.println("Ugyldigt ordreid. Prøv igen.");

    }

}
