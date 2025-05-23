public class Product {
    private int id;
    private String name;
    private String description;
    private int price;


    public Product(int id, String name, String description, int price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }

    public void printProduct() {
        // Punktum metode skal laves
        String pad = id + ".";
        for (int i = pad.length(); i < 4; i++) {
            pad += " ";
        }
        String str = pad + name + ": " + description;
        for (int i = str.length(); i <120 ; i++) {
            str += ".";
        }
        System.out.println( str + " " + price + ",-");
    }
}
