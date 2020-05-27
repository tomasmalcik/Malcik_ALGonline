
package malcik_hurricane;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author Tomáš Malčík
 */
public class Main {
    static FileSystem fs;
    static ArrayList<Hurricane> hurricanes;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        fs = new FileSystem("C:\\Users\\thomi\\OneDrive\\Dokumenty\\NetBeansProjects\\Malcik_Hurricane\\src\\txt\\hurricanedata.txt");
        hurricanes = fs.loadHurricanes();
        menu();
    }
    
    public static void menu() { 
        int choice = 1;
        int fromYear = 0;
        int toYear = 0;
        String name = "";
        while(choice > 0) {
            System.out.println("################################");
            System.out.println("Vítejte,");
            System.out.println("1) vypsat hurikány v rozmezí");
            System.out.println("2) vypsat hurikán podle jména");
            System.out.println("3) vypsat seřazené hurikány");
            System.out.println("-1) ukončit program");
            System.out.println("#################################");

            choice = sc.nextInt(); 
            
            if(choice == 1) {
                System.out.println("zadejte rozmezí roků (od do)");
                fromYear = sc.nextInt();
                toYear = sc.nextInt();
                printHurricanesInRange(fromYear,toYear);
            }else if(choice == 2){
                    System.out.println("Zadej jméno hurikánu");
                    name = sc.next();
                    System.out.println("j: "+name);
                    printHurricaneByName(name);      
            }else if(choice == 3) {
                Collections.sort(hurricanes, new SortBySpeed());
                printHurricanes();
            }
        
        }
    }

    private static void printHurricanes() {
        for(Hurricane h : hurricanes) {
            System.out.println(h.toString());
        }
    }   
    
    private static void printHurricaneByName(String name) {
        System.out.println("name");
        for(Hurricane h : hurricanes) {
            if(h.getName().equalsIgnoreCase(name)) {
                System.out.println(h.toString());
            }
        }
    }
    
    private static void printHurricanesInRange(int fromYear, int toYear) {
        for(Hurricane h : hurricanes) {
            if(h.getYear() >= fromYear && h.getYear() <= toYear){
                System.out.println(h.toString());
            }
        }
    }
}
