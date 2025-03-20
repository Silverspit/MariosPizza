import java.util.ArrayList;
import java.util.Arrays;

public class Inventory {
    private final static ArrayList<Product> inventory = new ArrayList<>(Arrays.asList(
            new Product(1, "Vesuvio", "Tomatsauce, ost, skinke og oregano", 57),
            new Product(2, "Amerikaner", "Tomatsauce, ost, oksefars og oregano", 53),
            new Product(3, "Cacciatore", "Tomatsauce, ost, pepperoni og oregano", 57),
            new Product(4, "Carbons", "Tomatsauce, ost, kødsauce, spaghetti, cocktailpølser og oregano", 63),
            new Product(5, "Dennis", "Tomatsauce, ost, skinke, pepperoni, cocktailpølser og oregano", 65),
            new Product(6, "Bertil", "Tomatsauce, ost, bacon og oregano", 57),
            new Product(7, "Silvia", "Tomatsauce, ost, pepperoni, rød peber, løg, oliven og oregano", 61),
            new Product(8, "Victoria", "Tomatsauce, ost, ananas, champignon, løg og oregano", 61),
            new Product(9, "Toronfo", "Tomatsauce, ost, skinke, bacon, kebab, chili og oregano", 61),
            new Product(10, "Capricciosa", "Tomatsauce, ost, skinke, champignon og oregano", 61),
            new Product(11, "Hawai", "Tomatsauce, ost, skinke, ananas og oregano", 57),
            new Product(12, "Le Blissola", "Tomatsauce, ost, skinke, rejer og oregano", 61),
            new Product(13, "Venezia", "Tomatsauce, ost, skinke, bacon og oregano", 61),
            new Product(14, "Mafia", "Tomatsauce, ost, pepperoni, bacon, løg og oregano", 61),
            new Product(15, "Kebab", "Tomatsauce, ost, kebab, salat og dressing", 61),
            new Product(16, "Tun Pizza", "Tomatsauce, ost, tun, løg, citronsaft og persille", 55),
            new Product(17, "Italiano", "Kødsauce og løg", 78),
            new Product(18, "Sivas", "Tomatsauce, ost, skinke, paprika og chili", 55),
            new Product(19, "Sucuk", "Tomatsauce, ost, hvidløgspølse, æg og paprika", 61),
            new Product(20, "Spinatpizza", "Tomatsauce, ost, spinat, æg, løg og hvidløg", 61),
            new Product(21, "Kylling", "Tomatsauce, ost, kylling, salat og dressing", 57),
            new Product(22, "Vegetar", "Oliven, champignon, løg og paprika", 61),
            new Product(23, "Abis", "Tomatsauce, ost, kødstrimler, løg, champignon, paprika, gorgonzola og hvidløg", 110),
            new Product(24, "Osman Special", "Tomatsauce, ost, bearnaise, kødstrimler, løg, æg, paprika og ananas", 110),
            new Product(25, "Oskar Special", "Gorgonzola, mozzarella, gedeost og strudseæg", 110),
            new Product(26, "Stig Special", "Alle Arlas produkter", 61),
            new Product(27, "Mario", "Tomatsauce, ost, skinke, rejer, champignon og artiskok", 78),
            new Product(28, "Alfonso", "Tomatsauce, ost, hakket oksekød, feta og chili", 67),
            new Product(29, "Abdul", "Tomatsauce, ost, kylling med karry, oliven, jalapeños og pesto", 55),
            new Product(30, "Fiesta", "Tomatsauce, ost, okseshawarma, hvidløg, jalapeños, salat og dressing", 78),
            new Product(31, "Rucola", "Tomatsauce, ost, pepperoni, rucola og pesto", 90)
    ));
    private Inventory(){

    }
    //Metode2:Printer alle vores produkter (For loop)
    public static void printItems() {
        for (Product p : inventory) {
            p.printProduct();
        }
    }
    public static int getInventorySize(){
        return inventory.size();
    }
    //Metode3: Afleverer vores produkt til orderline
        // navn ændring til getProduct
    public static Product getProduct(int choice) {
        return inventory.get(choice - 1);
    }

}






