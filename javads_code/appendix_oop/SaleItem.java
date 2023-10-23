public class SaleItem extends Item {
    private double discount; // as a decimal
    
    public SaleItem(String name, String sku, double price,
      double discount)  {
        super(name, sku, price);
        this.discount =
            Math.max(0, Math.min(discount, 1.00));
    }

    public double getDiscount() {
        return this.discount;
    }
    
    public void setDiscount(double discount) {
        this.discount =
            Math.max(0, Math.min(discount, 1.00));
    }
    
    /*
    public double purchase(int quantity) {
        return (this.getPrice() * quantity) * (1 - discount / 100.0));
    }
    
    public String toString() {
        return String.format("%s (%s): $%.2f - %.1f%% discount",
            this.getName(), this.getSku(), this.getPrice(),
            this.discount * 100.0);
    }
    
    public boolean equals(SaleItem other) {
        return (this.getName().equals(other.getName()) &&
            this.getSku().equals(other.getSku()) &&
            this.getPrice() == other.getPrice() &&
            this.discount == other.discount);
    }
    */
    
    public double purchase(int quantity) {
        return super.purchase(quantity) * (1 - discount);
    }
    
    public String toString() {
        return String.format("%s - %.1f%% discount",
            super.toString(),
            this.discount * 100.0);
    }
    
    public boolean equals(SaleItem other) {
        return (super.equals(other) &&
            this.discount == other.discount);
    }

}
