/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cmd;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;

/**
 *
 * @author Tomáš Malčík
 */
public class Dir extends Command{

    @Override
    public String execute(File actualDir) {
        File[] files;
        if(params.length == 1){
            files = actualDir.listFiles();
            return dirToString(files);
        }
        else if (params.length == 2  &&  params[1].equals("-o")) {
            files = actualDir.listFiles();
            //Arrays.sort(files,Comparator.comparingLong(File::lastModified));
            
//            (files).toString();
           return dirToString(files);
        }else if (params.length == 2 && params[1].equals("-r")) {
            return recursion(actualDir,"-");
        }
        return null;
    }

    private String recursion(File fil, String level) {
        StringBuilder recursionString = new StringBuilder("");
        File[] files = fil.listFiles();
        for(File f : files) {
            if(f.isDirectory()) {
                recursionString.append(String.format(level+"%s%n"," "+f.getName()));
                File curr = new File(f.getParent() + File.separator + f.getName());
                recursionString.append(recursion(curr,level+"-"));
            }else {
                recursionString.append(String.format(level+"%s%n", " "+f.getName(), " "+f.length()));
            }
        }
        return recursionString.toString();
    }
    
    private String dirToString(File[] files) {
        StringBuilder sb = new StringBuilder("");
        for (File file : files) {
            if(file.isDirectory()){
                sb.append(String.format("%s%n",file.getName()));
            }else{
                sb.append(String.format("%-20s%6d", file.getName(), file.length())); 
                sb.append(new Date(file.lastModified())).append("\n");
            }
            
        }
        String st = sb.toString();
        return st;
    }
    
}
