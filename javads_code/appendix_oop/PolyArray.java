public class PolyArray {
    public static void main(String[] args) {
        Item [] foods = {
            new Item("Rye Bread", "RB-010", 3.95),
            new SaleItem("Tomato Soup", "TS-882", 1.29, 0.05),
            new SaleItem("Canned Lima Beans", "CLB-104",
                2.98, 0.155),
            new SaleItem("Frozen Pizza", "FP-326",
                5.90, 0.12),
            new Item("Organic Salsa", "OS-245", 3.79)
        };
        
       for (Item food: foods) {
            System.out.printf("%s: ", food.getName());
                
            if (food instanceof SaleItem) {
                SaleItem saleFood = (SaleItem) food;
                double amountSaved = saleFood.getPrice() *
                    saleFood.getDiscount();
                System.out.printf("$%.2f - you save $%.2f\n",
                    saleFood.getPrice() - amountSaved,
                    amountSaved);
            } else {
                System.out.printf("$%.2f\n", food.getPrice());
            }
        }

    }
}
