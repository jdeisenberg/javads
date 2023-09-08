class Fraction {
    
    int numerator;
    int denominator;
    
    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }
    
    public int gcd(int m, int n) {
        while (m % n != 0) {
            int saveM = m;
            m = n;
            n = saveM % n;
        }
        return n;
    }
    
    public Fraction add(Fraction other) {
        int newNumerator = this.numerator * other.denominator +
                this.denominator * other.numerator;
        int newDenominator = this.denominator * other.denominator;
        
        int common = gcd(newNumerator, newDenominator);
        
        return new Fraction(newNumerator / common,
            newDenominator / common);
    }

    public static Fraction add(Fraction fracA, Fraction fracB) {
        return fracA.add(fracB);
    }

    public String toString() {
      return String.format("%d/%d", this.numerator, this.denominator);
    }
    
    public boolean equals(Fraction other) {
        int product1 = this.numerator * other.denominator;
        int product2 = this.denominator * other.numerator;

        return product1 == product2;
    }

    public static void main(String[] args) {
        Fraction myFraction = new Fraction(3, 5);
        System.out.println(myFraction);
        
        Fraction f1 = new Fraction(1, 4);
        Fraction f2 = new Fraction(1, 2);
        Fraction f3 = f1.add(f2);
        System.out.println(f3);
        
        Fraction f4 = new Fraction(3, 5);
        Fraction f5 = f4;
        Fraction f6 = new Fraction(3, 5);
        System.out.println(f4 == f5);       // shallow compare is true
        System.out.println(f4 == f6);       // but references aren't same
        System.out.println(f4.equals(f5)); // deep compare is true
        System.out.println(f4.equals(f6)); // and here also.
        
        Fraction f7 = new Fraction(1, 2);
        Fraction f8 = new Fraction(1, 3);
        Fraction f9 = Fraction.add(f7, f8);
        System.out.println(f9);

    }
}
