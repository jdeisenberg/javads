import java.util.ArrayList;

public class ChangeExample2 {
    static int totalCalls = 0;
        
    public static int makeChange2(ArrayList<Integer> coinDenoms, int change,
        int[] knownResults) {
        totalCalls++;
        if (coinDenoms.contains(change)) {
            knownResults[change] = 1;
            return 1;
        } else if (knownResults[change] != 0) {
            return knownResults[change];
        } else {
            int minCoins = Integer.MAX_VALUE;
            int pos = 0;
            while (pos < coinDenoms.size() && coinDenoms.get(pos) <= change) {
                int numCoins = 1 + makeChange2(coinDenoms,
                    change - coinDenoms.get(pos), knownResults);
                minCoins = Math.min(numCoins, minCoins);
                knownResults[change] = minCoins;
                pos++;
            }
            return minCoins;
        }
    }
        
    public static void main(String[] args) {
        ArrayList<Integer> denoms =  new ArrayList<>();
        denoms.add(1);
        denoms.add(5);
        denoms.add(10);
        denoms.add(25);
        System.out.println("Min # of coins: " +
            makeChange2(denoms, 63, new int[64]));
        System.out.println("Number of recursive calls: " + totalCalls);
    }
}
