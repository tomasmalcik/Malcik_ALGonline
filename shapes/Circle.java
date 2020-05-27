package shapes;

/**
 *
 * @author Tomas Malcik
 */
public class Circle extends Shape {
       //data
    private double r;

    private Circle(double r) {
        this.r = r;
    }
    
    //factory method
    public static Circle getInstance(double d){
        return new Circle(d/2);
    }
     
    public static Circle getInstanceR(double r){
        return new Circle(r);
    }
    //To do udelat pomoci tovarni metody
//    public Circle(double d) {
//        this.r = d/2;
//    }

    public double getR() {
        return r;
    }

    @Override
    public String toString() {
        return "Circle{" + "r=" + r + '}';
    }
    
    @Override
    public double area(){
        return Math.PI*r*r;
    }
    public static void main(String[] args) {
        Circle c = Circle.getInstanceR(4);
        System.out.println(c);
        System.out.println(c.area());
    } 

}
