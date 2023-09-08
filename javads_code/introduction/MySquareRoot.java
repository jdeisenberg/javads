class MySquareRoot {
    
    public static double squareRoot(double n) {
        double root = n / 2.0; // initial guess is 1/2 of n
        for (int iter=0; iter < 20; iter++) {
            root = 0.5 * (root + (n / root));
        }
        return root;
    }

    public static void main(String[] args) {
        System.out.println(squareRoot(9));
        System.out.println(squareRoot(4563));
    }
}
