package malcik_hurricane;

/**
 *
 * @author Tomáš Malčík
 */
public class Hurricane {
    
    private int year;
    private String month;
    private int pressure;
    private int knots;
    private double kilometers;
    private String name;
    private int type;
     
    final double knot = 1.852;
    
    public Hurricane(int year, String month, int pressure, int knots, String name) {
        this.year = year;
        this.month = month;
        this.pressure = pressure;
        this.knots = knots;
        this.name = name;
        calculateKilometers();
        setType();
    }

    
    //functions
    
    private void setType() {
        int floored = (int) Math.floor(kilometers);
        
        if(floored >= 252)
             this.type = 5;
        else if (floored >= 209)
            this.type = 4;
        else if (floored >= 178)
            this.type = 3;
        else if (floored >= 154)
            this.type = 2;
        else if (floored >= 119)
            this.type = 1;
        else 
            this.type = 0;
        
    }
    
    private void calculateKilometers() {
        this.kilometers =  this.knots*knot;
    }
    
    //getters and setters
    
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public int getPressure() {
        return pressure;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    public int getKnots() {
        return knots;
    }

    public void setKnots(int knots) {
        this.knots = knots;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public int getType() {
        return type;
    }
    
    @Override
    public String toString() {
        return "[ year="+year+", month="+month+", pressure="+pressure+", speed="+knots+", name="+name+" ]";
    }
    
    
}
