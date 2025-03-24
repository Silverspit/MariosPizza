import java.util.ArrayList;
import java.util.Scanner;

public class App {
    //private static ArrayList<Order> activeOrders = new ArrayList<>();

    //Main menu
    public static void mainMenu(Scanner scanner) {
        while (true) {
            System.out.println("\nVælg funktion\n");
            System.out.println("" +
                    "1: New order\n" +
                    "2: Show menu\n" +
                    "3: Show orders\n" +
                    "4: Show history \n" +
                    "5: Quit");
            switch (scanner.nextLine().toLowerCase().trim()) {
                case "1" -> newOrder(scanner);
                case "2" -> Inventory.printItems();
                case "3" -> History.showOrders();
                //case "4" -> Show active orders
                //case "5" -> Show inactive orders
                case "6" -> {
                    return;
                }
            }
        }
    }

    //  1. New order
    public static void newOrder(Scanner scanner) {
        Inventory.printItems();
        Order order = new Order();
        boolean addingPizzas = true;


        //Det her loop kører så længe addingpizza er true
        while (addingPizzas) {
            //Laver en variabel for pizza valg
            int productChoice;
            //Starter nyt loop (indre loop) der kører indtil brugeren har givet et valid input
            while (true) {
                //Spørg brugeren
                System.out.println("Hvilken pizza vil du tilføje?");
                productChoice = readNumber(scanner);
                scanner.nextLine();

                //if statement der tjekker om brugerinputtet er større end 0 og er indenfor pizzamenuen
                if (productChoice > 0 && productChoice <= Inventory.getInventorySize()) {
                    //Hvis det er valid, så breaker den ud af det indre while loop
                    break;
                }
                //BLiver ved med at give denne besked, indtil productchoice er valid
                System.out.println("Forkert input");
            }
            int productQuantity;

            //Gør det samme som foroven bare med productQuantity.
            while (true) {
                System.out.println("Hvor mange styk?");
                productQuantity = readNumber(scanner);
                scanner.nextLine();
                if (productQuantity > 0) {
                    break;
                }
                System.out.println("Forkert input");
            }

            //Så har vi defineret vores "ProductQuantity og productChoice
            //Nu kan vi smide dem ind i vores addToOrderLines metoder

            order.addToOrderLines(productQuantity, Inventory.getProduct(productChoice));

            //Spørg brugeren om de vil tilføje flere pizzaer
            //Og laver boolean der virker på samme måde som addingPizzas
            boolean addMore = true;
            while (addMore) {
                System.out.println("Vil du tilføje flere pizzaer? j/n, default j");
                String input = scanner.nextLine().toLowerCase().trim();
                //Laver switch statement med input formatteret til valide svar
                switch (input) {
                    //hvis de vil tilføje flere, gør den addMore til false, hvilket stopper flerePizzaer loopet
                    //Og går til toppen af det første loop
                    case "j", "ja", "":
                        addMore = false;
                        break;
                    //Gør alle kørevariablerne falske, så loopsne ikke køre igen.
                    case "n", "nej":
                        addingPizzas = false;
                        addMore = false;
                        break;
                    //Gives indtil et validt svar er inputtet
                    default:
                        System.out.println("Forkert input");
                }
            }
        }
        //Nu da addingPizzas er false og loopet er færdigt, tilføjer vi ordren til activeOrders arraylisten.
        History.addToOrders(order);
    }

    public static int readNumber(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            scanner.nextLine();
            System.out.println("Skal angive tal");
        }
        return scanner.nextInt();
    }

/*  2: Show order
    Order ID: 1
    Navn: Anders
    OrderLines:
        3x Pepperoni * 90
        2x Vesuvio * 80
    Sum: 140 DKK

    Order ID: 2
    Navn: Henrik
    OrderLines:
        1x Calezone * 120
    Sum: 120 DKK

    Type number to edit order
    Press 'Enter'-key to return
 * */

    /* Edit order #xx
        1: Add order line
        2: Remove order line
        3: Make ready for pick-up
        4: Return
     * */


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        mainMenu(scanner);
    }


}

