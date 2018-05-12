public class Fraction {
    /*
    The Fraction class is an object that holds information about a fraction
    (numerator and denominator). It will have several constructors and both
    private and public methods implementing the behavior of a fraction.
    */
    private int numerator;
    private int denominator;

    /*
    define constructor
     */
    public Fraction(int num, int den){
        if (den == 0) {
            throw new IllegalArgumentException("Denominator cannot be zero");
        }
        else if (den < 0) {
            this.numerator = num * (-1);
            this.denominator = den * (-1);
        } else {
            this.numerator = num;
            this.denominator = den;
        }
    }

    public Fraction(int num){
        this(num, 1);
    }

    public Fraction(){
        this(0, 1);
    }

    /*
    Define Methods
     */

    public int getNumerator(){
        return this.numerator;
    }
    public int getDenominator(){
        return this.denominator;
    }
    public String toString(){
        if (this.denominator == 1){
            return String.valueOf(this.numerator);
        }
        else if (this.numerator == 0){
            return String.valueOf(0);
        }
        else{
            return String.valueOf(this.numerator) + "/" + String.valueOf(this.denominator);
        }
    }
    public double toDouble(){
        double frac = (double)(this.numerator / this.denominator);
        return frac;
    }
    public Fraction add(Fraction other){
        int num = this.numerator*other.denominator + other.numerator*this.denominator;
        int den = this.denominator * other.denominator;
        Fraction results = new Fraction(num, den);
        results.toLowestTerms();
        return results;
    }
    public Fraction subtract(Fraction other){
        int num = this.numerator*other.denominator - other.numerator*this.denominator;
        int den = this.denominator * other.denominator;
        Fraction results = new Fraction(num, den);
        results.toLowestTerms();
        return results;
    }
    public Fraction multiply(Fraction other){
        int num = this.numerator * other.numerator;
        int den = this.denominator * other.denominator;
        Fraction results;
        if (num == 0) {
            results = new Fraction(0);
        }
        else {
            results = new Fraction(num, den);
            results.toLowestTerms();
        }
        return results;
    }
    public Fraction divide(Fraction other){
        if (other.numerator == 0) {
            System.out.println(this.toString() +  " / 0 = Undefined" );
            throw new IllegalArgumentException("divide by 0 is Undefined");
        }
        int num = this.numerator * other.denominator;
        int den = this.denominator * other.numerator;
        Fraction results = new Fraction(num, den);
        results.toLowestTerms();
        return results;
    }
    public boolean equals(Fraction other){
        return this.toDouble() == other.toDouble();
    }
    public void toLowestTerms(){
        int divider = gcd(this.numerator, this.denominator);
        this.numerator /= divider;
        this.denominator /= divider;
    }
    public int gcd(int num, int den){
        while(num != 0 && den != 0 ){
            int rem = num % den;
            num = den;
            den = rem;
        }
        return num;
    }

}
