public class ItemTest {
    
    public static void main(String[] args) {
        Item envelopes = new Item("Letter Size Envelopes - 100 count", "LSE-0100", 5.75);
        SaleItem marker = new SaleItem("Erasable marker - black", "EMB-913",
            2.15, 0.10);

        System.out.println(envelopes);
        double envelopeTotal = envelopes.purchase(10);
        System.out.printf("Ten boxes of envelopes cost $%.2f\n",
            envelopeTotal);
        
        System.out.println(marker);
        double markerTotal = marker.purchase(10);
        System.out.printf("Ten markers cost $%.2f\n",
            markerTotal);
    }
}
