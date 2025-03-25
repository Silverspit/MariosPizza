import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class App {

    public static void mainMenu(Scanner scanner, DateTimeFormatter formatter) {
        while (true) {
            System.out.println("\nVælg funktion\n");
            System.out.println("" +
                    "1: Ny ordre\n" +
                    "2: Vis menukort\n" +
                    "3: Vis aktive ordrer\n" +
                    "4: Vis ordrehistorik \n" +
                    "5: Vis statistik \n" +
                    "6: Fjern ordre \n" +
                    "7: Afslut");
            switch (scanner.nextLine().toLowerCase().trim()) {
                case "1" -> newOrder(scanner, formatter);
                case "2" -> printMenu(scanner);
                case "3" -> showOrders(scanner);
                case "4" -> History.showCompletedOrders();
                case "5" -> History.printSortedStatistics();
                case "6" -> removeOrder(scanner);
                case "7" -> {
                    return;
                }
                default -> System.out.println("Forkert input");
            }
        }
    }

    public static void newOrder(Scanner scanner, DateTimeFormatter formatter) {
        // statics metode kaldt på klassen
        Inventory.printItems();
        System.out.println();
        Order order = new Order(formatter);
        boolean addingProducts = true;


        //Det her loop kører så længe addingpizza er true
        while (addingProducts) {
            //Laver en variabel for pizza valg
            int productChoice;
            //Starter nyt loop (indre loop) der kører indtil brugeren har givet et valid input
            while (true) {
                //Spørg brugeren
                System.out.println("Hvilken pizza vil du tilføje?");
                productChoice = numberInput(scanner);

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
                productQuantity = numberInput(scanner);
                if (productQuantity > 0) {
                    break;
                }
                System.out.println("Forkert input");
            }

            //Så har vi defineret vores "ProductQuantity og productChoice
            //Nu kan vi smide dem ind i vores addToOrderLines metoder

            order.addToOrderLines(productQuantity, Inventory.getProduct(productChoice));

            //Spørg brugeren om de vil tilføje flere pizzaer
            //Og laver boolean der virker på samme måde som addingProducts
            boolean inputController = true;
            while (inputController) {
                System.out.println("Vil du tilføje flere pizzaer? j/n, tryk enter for ja");
                String input = scanner.nextLine().toLowerCase().trim();
                //Laver switch statement med input formatteret til valide svar
                switch (input) {
                    //hvis de vil tilføje flere, gør den inputController til false, hvilket stopper inputController loopet
                    //Og går til toppen af det første loop
                    case "j", "ja", "":
                        inputController = false;
                        break;
                    //Gør alle kørevariablerne falske, så loopsne ikke køre igen.
                    case "n", "nej":
                        addingProducts = false;
                        inputController = false;
                        break;
                    //Gives indtil et validt svar er inputtet
                    default:
                        System.out.println("Forkert input");
                }
            }

        }
        System.out.println("hvor lang tid går der før den er klar?");
        order.setHowLongItTakes(numberInput(scanner));
        //Nu da addingProducts er false og loopet er færdigt, tilføjer vi ordren til activeOrders arraylisten.
        History.addToOrders(order);
    }

    public static void showOrders(Scanner scanner) {
        History.showActiveOrders();
        if (History.hasActiveOrders()) {

            System.out.println("Vil du afslutte en ordre? j/n");
            while (true) {

                switch (scanner.nextLine().trim().toLowerCase()) {
                    case "j", "ja": {
                        completeOrder(scanner);
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
        System.out.println("Hvilken ordre vil du afslutte? Skriv 0 for at fortryde");
        int answer = numberInput(scanner);
        if (answer == 0){
            return;
        }
        while (!History.completeOrder(answer)) {
            answer = numberInput(scanner);
        }

    }

    public static int numberInput(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            scanner.nextLine();
            System.out.println("Skal angive tal");

        }
        int numberToReturn = scanner.nextInt();
        scanner.nextLine();
        return numberToReturn;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        mainMenu(scanner, formatter);
    }

    public static void removeOrder (Scanner scanner){
        History.showOrders();
        System.out.println("Hvilken ordre vil du fjerne? Skriv 0 for at fortryde");
        int answer = numberInput(scanner);
        if (answer == 0){
            return;
        }
        History.removeOrder(answer);
    }

    public static void printMenu (Scanner scanner){
        Inventory.printItems();
        System.out.println("\nTryk enter for at fortsætte");
        scanner.nextLine();

    }
}

