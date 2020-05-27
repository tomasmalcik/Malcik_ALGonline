
package fractions;

public class Fraction {
    
    //data
    private int numerator;
    private int denominator;
    
    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    //functions
    
    /**
     * This function finds the highest common denominator and divides both numerator and denominator
     */
    public void simplify() {
        int h; // - its only function is to store data
        int n = this.numerator;
        int d = this.denominator;
        while(d != 0) {
            h = d;
            d = n%d;
            n = h;
        }
        this.numerator = this.numerator / n;
        this.denominator = this.denominator / n;
    }
    
    //getters & toString
    
    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    @Override
    public String toString() {
        //check is denominator is greater than 0
        if(this.denominator == 0) {
            throw new IllegalArgumentException("Nelze dělit 0");
        }
       
        return numerator + ((numerator != 0) ? " / " + denominator : "" );
        
    }

    
}
