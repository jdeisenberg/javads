public class FindSum2 {
    public static int foo(int tom) {
        int fred = 0;
        for (int nancy = 1; nancy <= tom; nancy++) {
            int joanne = nancy;
            fred = fred + joanne;
        }
        return fred;
    }

    public static void main(String[] args) {
        System.out.println(foo(10));
    }
}
