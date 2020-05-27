
package fractions;


public class FractionsCalculator {
    
    // functions
    private static int findCommonDenominator(int aDen, int bDen) {
        
        int tmp;
        
        if(aDen != bDen) { 
            if(aDen > bDen) {
                tmp = bDen;
                bDen = aDen;
                aDen = tmp;
            }
            for (int i = aDen; i < aDen*bDen; i++) {
                
                if((aDen*i)%bDen==0) {
                    return aDen*i;
                }
                
            }
        }
        
        return aDen;
        
        
    }
    
    
    public static Fraction plus(Fraction a, Fraction b) {

        
        //get their common denominator
        int denominator = findCommonDenominator(a.getDenominator(), b.getDenominator());
        int nominator = ( ((denominator/a.getDenominator())*a.getNumerator()) + ((denominator/b.getDenominator())*b.getNumerator()) );
        
        return new Fraction(nominator, denominator);
    }
    
    public static Fraction minus(Fraction a, Fraction b) {

        
        //get their common denominator
        int denominator = findCommonDenominator(a.getDenominator(), b.getDenominator());
        int nominator = ( ((denominator/a.getDenominator())*a.getNumerator()) - ((denominator/b.getDenominator())*b.getNumerator()) );
        
        return new Fraction(nominator, denominator);
    }
    
    public static Fraction multiply(Fraction a, Fraction b) {
   
    
        int numerator = (a.getNumerator()*b.getNumerator());
        int denominator = (a.getDenominator()*b.getDenominator());
        
        return new Fraction(numerator, denominator);
        
    }
    
    public static Fraction divide(Fraction a, Fraction b) {
        
        
        int numerator = (a.getNumerator()*b.getDenominator());
        int denominator = (a.getDenominator()*b.getNumerator());
        
        return new Fraction(numerator, denominator);
        
    }
    
}
