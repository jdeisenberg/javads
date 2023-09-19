import java.util.ArrayList;

public class ChangeExample4 {
    public static int makeChange4(ArrayList<Integer> coinValues, int change,
        int[] minCoins, int[] coinsUsed) {
        
        for (int cents = 0; cents < change + 1; cents++) {
            int coinCount = cents;
            int newCoin = 1;
            
            int pos = 0;
            while (pos < coinValues.size() && coinValues.get(pos) <= cents) {
                int value = coinValues.get(pos);
                if (minCoins[cents  - value] + 1 < coinCount) {
                    coinCount = minCoins[cents - value] + 1;
                    newCoin = value;
                }
                pos++;
            }
            minCoins[cents] = coinCount;
            coinsUsed[cents] = newCoin;
        }
        return minCoins[change];
    }

    public static void printCoins(int[] coinsUsed, int change) {
        int coin = change;
        while (coin > 0) {
            int thisCoin = coinsUsed[coin];
            System.out.printf("%d ", thisCoin);
            coin = coin - thisCoin;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        ArrayList<Integer> coinValues =  new ArrayList<>();
        coinValues.add(1);
        coinValues.add(5);
        coinValues.add(10);
        coinValues.add(21);
        coinValues.add(25);
        
        int[] coinsUsed = new int[64];
        
        System.out.println("Min # of coins: " +
            makeChange4(coinValues, 63, new int[64], coinsUsed));
        System.out.println("The coins used are as follows: ");
        printCoins(coinsUsed, 63);
    }
}
