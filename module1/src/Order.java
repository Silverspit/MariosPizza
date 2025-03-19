import java.util.ArrayList;

public class Order {
    private ArrayList <Pizza> pizzaOrders = new ArrayList<>();
    private String name;
    private int ID;
    //Constructor

    public Order(String name){
        this.name = name;
    }

    public Order(int ID) {
        this.ID = ID;
    }
    //Setter


    public void addPizza(String pizzaName, int pizzaPrice){
        pizzaOrders.add(new Pizza(pizzaName, pizzaPrice));


    }
}
