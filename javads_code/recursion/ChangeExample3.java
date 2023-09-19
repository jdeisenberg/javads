import java.util.ArrayList;

public class ChangeExample3 {
    public static int makeChange3(ArrayList<Integer> coinValues, int change,
        int[] minCoins) {
        
        for (int cents = 0; cents < change + 1; cents++) {
            int coinCount = cents;
            
            int pos = 0;
            while (pos < coinValues.size() && coinValues.get(pos) <= cents) {
                int value = coinValues.get(pos);
                if (minCoins[cents  - value] + 1 < coinCount) {
                    coinCount = minCoins[cents - value] + 1;
                }
                pos++;
            }
            minCoins[cents] = coinCount;
        }
        return minCoins[change];
    }

    public static void main(String[] args) {
        ArrayList<Integer> coinValues =  new ArrayList<>();
        coinValues.add(1);
        coinValues.add(5);
        coinValues.add(10);
        coinValues.add(25);
        System.out.println("Min # of coins: " +
            makeChange3(coinValues, 63, new int[64]));
    }
}
