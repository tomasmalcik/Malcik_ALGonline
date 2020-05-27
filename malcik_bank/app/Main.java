package app;

import java.util.ArrayList;
import logic.Client;
import logic.Company;
import logic.Person;

/**
 *
 * @author Tomas Malcik
 */
public class Main {
    public static ArrayList<Client> clients = new ArrayList<>();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //init (1)
        Person zednik = new Person("Zednik");
        Person kovar = new Person("Kovar");
        Company nissan = new Company("Nissan");
        
        clients.add(zednik); 
        clients.add(kovar); 
        clients.add(nissan); 
        
        //add acc (2)
        zednik.addAccount(1000);
        zednik.addAccount(500);
        
        kovar.addAccount(1200);
        
        nissan.addAccount(120);
        
        
        //display (3)
        System.out.println(clients.get(0).getName() + " a castka je: " + clients.get(0).giveSumAll());
        System.out.println(clients.get(1).getName() + " a castka je: " + clients.get(1).giveSumAll());
        System.out.println(clients.get(2).getName() + " a castka je: " + clients.get(2).giveSumAll());
    }
    
}
