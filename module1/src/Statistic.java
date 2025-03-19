import java.util.ArrayList;
import java.util.Scanner;

public class Statistic {
    /* private static ArrayList<Order> orders = new ArrayList<>();


    // Metode der placerer order i listen
    public static void placeOrder(String name, ArrayList<String> pizzas, ArrayList<Integer> price, Scanner scanner) {
        Order order = new Order(name);


        // loop der tilføjer pizza til din ordre
        boolean placingOrder = true;
        while (placingOrder) {
            System.out.println("Hvad for en pizza vil du tilføje til din ordre? ");
            for (int i = 0; i < pizzas.size(); i++) {
                System.out.println((i + 1) + ": " + pizzas.get(i));
            }
            int choice = scanner.nextInt();

            if (choice > 0 && choice < (pizzas.size() + 1)) {
                order.addPizza(pizzas.get(choice), price.get(choice));
            } else {
                System.out.println("not a pizza we make");
            }
            boolean anotherPizza = true;
            while (anotherPizza) {
                System.out.println("would you like to add another pizza? y/n");
                switch (scanner.nextLine().trim().toLowerCase()) {
                    case "y":
                        break;
                    case "n": {
                        anotherPizza = false;
                        placingOrder = false;
                        break;
                    }
                    default: {
                        System.out.println("wrong input");
                    }
                }
            }


        }*/
}
