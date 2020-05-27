
package fractions;

public class Fractions {


    public static void main(String[] args) {
        Fraction f = new Fraction(2,6);
        Fraction g = new Fraction(5,3);
        f.simplify();
        
        //test calculator
        
        //plus
        Fraction test1 = FractionsCalculator.plus(f,g);
        test1.toString();
        
        //minus
        Fraction test2 = FractionsCalculator.minus(f,g);
        test1.toString();
        
        //multiply
        Fraction test3 = FractionsCalculator.multiply(f,g);
        test1.toString();
        
        //divide
        Fraction test4 = FractionsCalculator.divide(f,g);
        test1.toString();
        
    }
    
}
