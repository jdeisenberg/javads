import java.util.ArrayList;

public class ChangeExample1 {
    static int totalCalls = 0;
        
    public static int makeChange1(ArrayList<Integer> coinValues, int change) {
        totalCalls++;
        if (coinValues.contains(change)) {
            return 1;
        }
        
        int minCoins = Integer.MAX_VALUE;
        int pos = 0;
        while (pos < coinValues.size() && coinValues.get(pos) <= change) {
            int numCoins = 1 + makeChange1(coinValues,
                change - coinValues.get(pos));
            minCoins = Math.min(numCoins, minCoins);
            pos++;
        }
        return minCoins;

    }
        
    public static void main(String[] args) {
        ArrayList<Integer> coinValues =  new ArrayList<>();
        coinValues.add(1);
        coinValues.add(5);
        coinValues.add(10);
        coinValues.add(25);
        System.out.println("Min # of coins: " + makeChange1(coinValues, 63));
        System.out.println("Number of recursive calls: " + totalCalls);
    }
}
