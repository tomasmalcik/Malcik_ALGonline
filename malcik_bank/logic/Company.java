package logic;

/**
 *
 * @author Tomas Malcik
 */
public class Company extends Client {
    private String nameC;

    public Company(String nameC) {
        this.nameC = nameC;
    }
    
    @Override
    public String getName(){
        return "firma " + nameC;
    }
    
   
}