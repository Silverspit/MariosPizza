import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class App {

    public static void mainMenu(Scanner scanner, DateTimeFormatter formatter) {
        while (true) {
            System.out.println("\nVælg funktion\n");
            System.out.println("" +
                    "1: New order\n" +
                    "2: Show menu\n" +
                    "3: Show orders\n" +
                    "4: Show history \n" +
                    "5: Quit");
            switch (scanner.nextLine().toLowerCase().trim()) {
                case "1" -> newOrder(scanner, formatter);
                case "2" -> Inventory.printItems();
                case "3" -> showOrders(scanner);
                case "4" -> History.showCompletedOrders();
                case "5" -> {
                    return;
                }
                default -> System.out.println("forkert input");
            }
        }
    }

    public static void newOrder(Scanner scanner, DateTimeFormatter formatter) {
        Inventory.printItems();
        Order order = new Order(formatter);
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
        System.out.println("hvor lang tid går der før den er klar?");
        order.setHowLongItTakes(readNumber(scanner));
        scanner.nextLine();
        //Nu da addingPizzas er false og loopet er færdigt, tilføjer vi ordren til activeOrders arraylisten.
        History.addToOrders(order);
    }

    public static void showOrders(Scanner scanner) {
        History.showNotFinished();
        if (History.checkIfOrderListIsEmpty()) {

            System.out.println("Vil du afslutte en ordre? j/n");
            while (true) {

                switch (scanner.nextLine().trim().toLowerCase()) {
                    case "j", "ja": {
                        completeOrder(scanner);
                        //osman må vide hvad der foregår
                        scanner.nextLine();
                        return;
                    }
                    case "n", "nej": {
                        return;
                    }

                    default: {
                        System.out.println("Indtast et gyldigt svar");
                    }
                }


            }
        } else {
            System.out.println("Ingen aktive ordre");
        }

    }

    public static void completeOrder(Scanner scanner) {
        System.out.println("Hvilken ordre vil du afslutte?");
        int answer = readNumber(scanner);
        while (!History.finishedOrder(answer)) {
            answer = readNumber(scanner);
        }

    }

    public static int readNumber(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            scanner.nextLine();
            System.out.println("Skal angive tal");
        }
        return scanner.nextInt();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        mainMenu(scanner, formatter);
    }
}

