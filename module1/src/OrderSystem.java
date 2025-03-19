import java.util.ArrayList;
import java.util.Scanner;

public class OrderSystem {
    private static ArrayList<Order> orders = new ArrayList<>();


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


        }

       /*while (true)  {
           System.out.println("Hvad for en pizza vil du tilføje til din ordre? ");
           for (int i = 0; i < pizzas.size() ; i++) {
               System.out.println((i + 1 ) + ": " + pizzas.get(i));
           }
           switch (scanner.nextLine().toLowerCase().trim()){
               case "1": {
                   pizzas.addPizza(pizzas.get(0), price.get(0));
               }
               case "2": {
                   pizzas.addPizza(pizzas.get(1), price.get(1));
               }
               case "3": {
                   pizzas.addPizza(pizzas.get(2), price.get(2));
               }
               case "4": {
                   pizzas.addPizza(pizzas.get(3), price.get(3));
               }
               case "5": {
                   pizzas.addPizza(pizzas.get(4), price.get(4));
               }
               case "6": {
                   pizzas.addPizza(pizzas.get(5), price.get(5));
               }
               case "7": {
                   pizzas.addPizza(pizzas.get(6), price.get(6));
               }
               case "8": {
                   pizzas.addPizza(pizzas.get(7), price.get(7));
               }
               case "9": {
                   pizzas.addPizza(pizzas.get(8), price.get(8));
               }
               case "10": {
                   pizzas.addPizza(pizzas.get(9), price.get(9));
               }
               case "11": {
                   pizzas.addPizza(pizzas.get(10), price.get(10));
               }
               case "12": {
                   pizzas.addPizza(pizzas.get(11), price.get(11));
               }
               case "13": {
                   pizzas.addPizza(pizzas.get(12), price.get(12));
               }
               case "14": {
                   pizzas.addPizza(pizzas.get(13), price.get(13));
               }
               case "15": {
                   pizzas.addPizza(pizzas.get(14), price.get(14));
               }
               case "16": {
                   pizzas.addPizza(pizzas.get(15), price.get(15));
               }
               case "17": {
                   pizzas.addPizza(pizzas.get(16), price.get(16));
               }
               case "18": {
                   pizzas.addPizza(pizzas.get(17), price.get(17));
               }
               case "19": {
                   pizzas.addPizza(pizzas.get(18), price.get(18));
               }
               case "20": {
                   pizzas.addPizza(pizzas.get(19), price.get(19));
               }
               case "21": {
                   pizzas.addPizza(pizzas.get(20), price.get(20));
               }
               case "22": {
                   pizzas.addPizza(pizzas.get(21), price.get(21));
               }
               case "23": {
                   pizzas.addPizza(pizzas.get(22), price.get(22));
               }
               case "24": {
                   pizzas.addPizza(pizzas.get(23), price.get(23));
               }
               case "25": {
                   pizzas.addPizza(pizzas.get(24), price.get(24));
               }
               case "26": {
                   pizzas.addPizza(pizzas.get(25), price.get(25));
               }
               case "27": {
                   pizzas.addPizza(pizzas.get(26), price.get(26));
               }
               case "28": {
                   pizzas.addPizza(pizzas.get(27), price.get(27));
               }
               case "29": {
                   pizzas.addPizza(pizzas.get(28), price.get(28));
               }
               case "30": {
                   pizzas.addPizza(pizzas.get(29), price.get(29));
               }
           }
           order.addPizza(name, price);
       }*/
        orders.add(order);

    }

    // Metode Fjern ordre fra listen


    // metode Afslutte ordre
}
