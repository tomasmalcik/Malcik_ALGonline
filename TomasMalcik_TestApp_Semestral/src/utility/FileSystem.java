package utility;

import java.util.ArrayList;
import java.io.*;


/**
 *
 * @author Tomáš Malčík
 */
public class FileSystem {
    
    /**
     * This function loads data from a given file
     * @param url - where is the file located
     * @return ArrayList filled with each line representing one line (string)
     */
    public static ArrayList load(String url) {
        try{
            ArrayList<String> ar = new ArrayList<String>();
            FileReader fr = new FileReader(url);
            BufferedReader br = new BufferedReader(fr);
            
            String line;
            while ((line = br.readLine()) != null) {
                ar.add(line);
            }
            
            
            br.close();    
            fr.close();  
            
            return ar;
            
        }catch(Exception e) {
            System.err.print("FileSystem couldn't find any file with this name, caused by: "+e);
        }
        return null;
    }
    

    
}
