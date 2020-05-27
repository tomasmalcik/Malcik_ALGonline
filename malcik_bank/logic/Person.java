package logic;

/**
 *
 * @author Tomas Malcik
 */
public class Person extends Client {
    private String nameP;

    public Person(String nameP) {
        this.nameP = nameP;
    }

    @Override
    public String getName(){
        if(nameP.contains("ova")){
            return "pani " + nameP;
        }
        return "pan " + nameP;
    }
    
}
