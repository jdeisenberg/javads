import java.util.ArrayList;

public class ChangeExample2 {
    static int totalCalls = 0;
        
    public static int makeChange2(ArrayList<Integer> coinValues, int change,
        int[] knownResults) {
        totalCalls++;
        if (coinValues.contains(change)) {
            knownResults[change] = 1;
            return 1;
        } else if (knownResults[change] != 0) {
            return knownResults[change];
        } else {
            int minCoins = Integer.MAX_VALUE;
            int pos = 0;
            while (pos < coinValues.size() && coinValues.get(pos) <= change) {
                int numCoins = 1 + makeChange2(coinValues,
                    change - coinValues.get(pos), knownResults);
                minCoins = Math.min(numCoins, minCoins);
                knownResults[change] = minCoins;
                pos++;
            }
            return minCoins;
        }
    }
        
    public static void main(String[] args) {
        ArrayList<Integer> coinValues =  new ArrayList<>();
        coinValues.add(1);
        coinValues.add(5);
        coinValues.add(10);
        coinValues.add(25);
        System.out.println("Min # of coins: " +
            makeChange2(coinValues, 63, new int[64]));
        System.out.println("Number of recursive calls: " + totalCalls);
    }
}
