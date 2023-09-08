import java.util.Random;

class TenRandomIntegers {
    
    public static void main(String[] args) {
        Random generator = new Random();
        
        for (int i = 0; i < 10; i++) {
            int randomInt = generator.nextInt(100);
            System.out.println(randomInt);
        }
    }
}
