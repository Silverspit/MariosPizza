import java.util.ArrayList;

public class Inventory {
    private static ArrayList<Product> inventory = new ArrayList<>();

    public static void productsIntoArray(){
        //Metode1: Adder alle produkterne til "inventory" arraylisten (for-loop?)
    Product p1 = new Product(1, "Vesuvio", "Tomatsauce, ost, skinke og oregano", 57);
    Product p2 = new Product(2, "Amerikaner", "Tomatsauce, ost, oksefars og oregano", 53);
    Product p3 = new Product(3, "Cacciatore", "Tomatsauce, ost, pepperoni og oregano", 57);
    Product p4 = new Product(4, "Carbons", "Tomatsauce, ost, kødsauce, spaghetti, cocktailpølser og oregano", 63);
    Product p5 = new Product(5, "Dennis", "Tomatsauce, ost, skinke, pepperoni, cocktailpølser og oregano", 65);
    Product p6 = new Product(6, "Bertil", "Tomatsauce, ost, bacon og oregano", 57);
    Product p7 = new Product(7, "Silvia", "Tomatsauce, ost, pepperoni, rød peber, løg, oliven og oregano", 61);
    Product p8 = new Product(8, "Victoria", "Tomatsauce, ost, ananas, champignon, løg og oregano", 61);
    Product p9 = new Product(9, "Toronfo", "Tomatsauce, ost, skinke, bacon, kebab, chili og oregano", 61);
    Product p10 = new Product(10, "Capricciosa", "Tomatsauce, ost, skinke, champignon og oregano", 61);
    Product p11 = new Product(11, "Hawai", "Tomatsauce, ost, skinke, ananas og oregano", 57);
    Product p12 = new Product(12, "Le Blissola", "Tomatsauce, ost, skinke, rejer og oregano", 61);
    Product p13 = new Product(13, "Venezia", "Tomatsauce, ost, skinke, bacon og oregano", 61);
    Product p14 = new Product(14, "Mafia", "Tomatsauce, ost, pepperoni, bacon, løg og oregano", 61);
    Product p15 = new Product(15, "Kebab", "Tomatsauce, ost, kebab, salat og dressing", 61);
    Product p16 = new Product(16, "Tun Pizza", "Tomatsauce, ost, tun, løg, citronsaft og persille", 55);
    Product p17 = new Product(17, "Italiano", "Kødsauce og løg", 78);
    Product p18 = new Product(18, "Sivas", "Tomatsauce, ost, skinke, paprika og chili", 55);
    Product p19 = new Product(19, "Sucuk", "Tomatsauce, ost, hvidløgspølse, æg og paprika", 61);
    Product p20 = new Product(20, "Spinatpizza", "Tomatsauce, ost, spinat, æg, løg og hvidløg", 61);
    Product p21 = new Product(21, "Kylling", "Tomatsauce, ost, kylling, salat og dressing", 57);
    Product p22 = new Product(22, "Vegetar", "Oliven, champignon, løg og paprika", 61);
    Product p23 = new Product(23, "Abis", "Tomatsauce, ost, kødstrimler, løg, champignon, paprika, gorgonzola og hvidløg", 110);
    Product p24 = new Product(24, "Osman Special", "Tomatsauce, ost, bearnaise, kødstrimler, løg, æg, paprika og ananas", 110);
    Product p25 = new Product(25, "Oskar Special", "Gorgonzola, mozzarella, gedeost og strudseæg", 110);
    Product p26 = new Product(26, "Stig Special", "Alle Arlas produkter", 61);
    Product p27 = new Product(27, "Mario", "Tomatsauce, ost, skinke, rejer, champignon og artiskok", 78);
    Product p28 = new Product(28, "Alfonso", "Tomatsauce, ost, hakket oksekød, feta og chili", 67);
    Product p29 = new Product(29, "Abdul", "Tomatsauce, ost, kylling med karry, oliven, jalapeños og pesto", 55);
    Product p30 = new Product(30, "Fiesta", "Tomatsauce, ost, oskesharwarma, hvidløg, jalapeños, salat og dressing", 78);
    Product p31 = new Product(31, "Rucola", "Tomatsauce, ost, pepperoni, rucola og pesto", 90);
        inventory.add(p1);
        inventory.add(p2);
        inventory.add(p3);
        inventory.add(p4);
        inventory.add(p5);
        inventory.add(p6);
        inventory.add(p7);
        inventory.add(p8);
        inventory.add(p9);
        inventory.add(p10);
        inventory.add(p11);
        inventory.add(p12);
        inventory.add(p13);
        inventory.add(p14);
        inventory.add(p15);
        inventory.add(p16);
        inventory.add(p17);
        inventory.add(p18);
        inventory.add(p19);
        inventory.add(p20);
        inventory.add(p21);
        inventory.add(p22);
        inventory.add(p23);
        inventory.add(p24);
        inventory.add(p25);
        inventory.add(p26);
        inventory.add(p27);
        inventory.add(p28);
        inventory.add(p29);
        inventory.add(p30);
        inventory.add(p31);
    }
    //Metode2:Printer alle vores produkter (For loop)
    public static void printItems(){
        for (Product p : inventory){
            p.printProduct();
        }
    }
    //Metode3: Afleverer vores produkt til orderline

    public Product transferToOrderLine(int choice){
      return inventory.get(choice - 1);
    }

}






