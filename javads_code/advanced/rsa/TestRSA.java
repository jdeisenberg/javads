package rsa;

import java.util.Arrays;
import java.math.BigInteger;

public class TestRSA {

    public static long gcd(long a, long b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
    
    public static long[] extGcd(long x, long y) {
        if (y == 0) {
            return(new long[] {x, 1, 0});
        } else {
            long[] info = extGcd(y, x % y);
            long d = info[0];
            long a = info[1];
            long b = info[2];
            return(new long[] {d, b, a - (x / y) * b});
        }
    }
     
    public static long modExp(long x, long n, long p) {
        if (n == 0) {
            return 1;
        }
        long t = (x * x) % p;
        long result = modExp(t, n / 2, p);
        if (n % 2 != 0) {
            result = (result * x) % p;
        }
        return result;
    }
    
    public long[] genKeys(long p, long q) {
        long n = p * q;
        long m = (p - 1) * (q - 1);
        long encryptKey = (long) (Math.random() * n);
        while (gcd(m, encryptKey) != 1) {
            encryptKey = (long) (Math.random() * n);
        }
        long[] dab = extGcd(m, encryptKey);
        long decryptKey = dab[0];
        long a = dab[1];
        long b = dab[2];
        
        if (b < 0) {
            decryptKey = m + b;
        } else {
            decryptKey = b;
        }
        return new long[]{encryptKey, decryptKey, n};
    }

    public long[] encrypt(String msg, long encryptKey,
      long n) {
        BigInteger bigN = new BigInteger(Long.toString(n));
        int chunkSize = bigN.bitLength() / 8;

        long [] allChunks = strToChunks(msg, chunkSize);
        System.out.println("Original: " + Arrays.toString(allChunks));
        for (int i = 0; i < allChunks.length; i++) {
            allChunks[i] = modExp(allChunks[i], encryptKey, n);
        }
        
        return allChunks;
    }
    
    public String decrypt(long[] cipherChunks, long decryptKey,
      long n) {
        BigInteger bigN = new BigInteger(Long.toString(n));
        int chunkSize = bigN.bitLength() / 8;
        
        long[] plainChunks = new long[cipherChunks.length];
        for (int i = 0; i < cipherChunks.length; i++) {
            plainChunks[i] = modExp(cipherChunks[i], decryptKey,
                n);
        }
        System.out.println(Arrays.toString(plainChunks));
        return chunksToStr(plainChunks, chunkSize);
    }
    
    public long[] strToChunks(String msg, int chunkSize) {
        byte[] msgBytes;
        msgBytes = msg.getBytes();

        int numChunks = (msgBytes.length + chunkSize - 1) / chunkSize;
        long[] chunkList = new long[numChunks];
       
        int n = 0;
        String hex = "";
        for (int i = 0; i < msgBytes.length; i++) {
            hex += String.format("%02x", msgBytes[i]);
            if (i % chunkSize == chunkSize - 1) {
                chunkList[n] = Long.parseLong(hex, 16);
                n++;
                hex = "";
            }
        }
        if (!hex.equals("")) {
            hex = hex + "00".repeat(chunkSize - hex.length() / 2);
            chunkList[n] = Long.parseLong(hex, 16);
        }
        return chunkList;
    }

    public String chunksToStr(long[] chunkList, int chunkSize) {
        byte[] byteArr = new byte[chunkList.length * chunkSize];
        int n = 0;
        for (long chunk: chunkList) {
            for (int i = 0; i < chunkSize; i++) {
                 byteArr[n + (chunkSize - i - 1)] = 
                    (byte) ((chunk >> (i * 8)) & 0xff);
            }
            n += chunkSize;
        }
        return new String(byteArr);
    }
    
    public static void main(String[] args) {
        String message = "Java Straße ¡olé!";
        TestRSA test = new TestRSA();
        long[] edn = test.genKeys(5563, 8191);
        
        long[] encrypted = test.encrypt(message, edn[0], edn[2]);
        System.out.println("Encrypted: " + Arrays.toString(encrypted));
        
        String recovered = test.decrypt(encrypted, edn[1], edn[2]);
        System.out.println(recovered);
    }
}
