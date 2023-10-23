public class Item {
    private String name;
    private String sku;
    private double price;
    
    public Item(String name, String sku, double price)  {
        this.name = name;
        this.sku = sku;
        this.price = Math.abs(price);
    }
    
    public String getName() {
        return this.name;
    }
    
    public String getSku() {
        return this.sku;
    }
    
    public double getPrice() {
        return this.price;
    }
    
    public void setPrice(double price) {
        this.price = Math.abs(price);
    }
    
    public double purchase(int quantity) {
        return quantity * price;
    }
    
    public String toString() {
        return String.format("%s (%s): $%.2f", this.name,
            this.sku, this.price);
    }
    
    public boolean equals(Item other) {
        return (this.name.equals(other.name) &&
            this.sku.equals(other.sku) &&
            this.price == other.price);
    }
}
