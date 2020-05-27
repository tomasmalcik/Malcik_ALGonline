package shapes;

/**
 *
 * @author Tomas Malcik
 */
public class Square extends Rectangle{
    private double a;
    
    public Square(double a){
        super(a,a);
    }
    public static void main(String[] args) {
        Square s = new Square(4);
        System.out.println(s.area());
    }

}
