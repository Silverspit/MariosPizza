public class Product {

    private String pizzaName;
    private int price;

    //private ArrayList<Toppings> toppings = new ArrayList<>();

    public Product(String pizzaName, int price){
        this.pizzaName = pizzaName;
        this.price = price;
    }

    public String getPizza(){
        return pizzaName;
    }

    public void setPizzaName(String pizzaName){
        this.pizzaName = pizzaName;
    }

    /* public void setToppings(Toppings t){
        toppings.add(t);
    }
    public ArrayList<Toppings> getToppings(){
        return toppings;
    }*/

   /* public String getPizzaWithToppings(){
        return pizzaName + " with ekstra " + toppings;
    }*/


}
