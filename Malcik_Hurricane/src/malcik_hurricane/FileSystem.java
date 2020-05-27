package malcik_hurricane;

import java.util.ArrayList;
import java.io.*;


/**
 *
 * @author Tomáš Malčík
 */
public class FileSystem {
    
    ArrayList<String> data;
    
    public FileSystem(String path) {
        data = load(path);
    }
    
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
    
    
    public ArrayList<Hurricane> loadHurricanes() {
        ArrayList<Hurricane> hr = new ArrayList<>();
        
        for(int i = 0; i < data.size(); i++) {
            String[] splits = data.get(i).split("\\s+");
            Hurricane h = new Hurricane(Integer.parseInt(splits[0]),
                                        splits[1],
                                        Integer.parseInt(splits[2]),
                                        Integer.parseInt(splits[3]),
                                        splits[4]);
            hr.add(h);
        }
        
        return hr;
        
    }
}
