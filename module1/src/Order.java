import java.util.ArrayList;

public class Order {

    ArrayList<Pizza> pizzaOrders = new ArrayList<>();


    public void addPizza(String pizzaName, int pizzaPrice) {

        pizzaOrders.add(new Pizza(pizzaName,pizzaPrice));
    }
    /*public void addPizzaWithTopppings(String pizzaName,int pizzaPrice, ArrayList<Toppings> toppingsName, int toppingsPrice, int nrOftoppings){
            Pizza p1 = new Pizza(pizzaName,pizzaPrice);
        for (int i = 0; i < nrOftoppings; i++) {
            p1.setToppings(toppingsName());
        }
            pizzaOrders.add(p1);

    }*/
}
