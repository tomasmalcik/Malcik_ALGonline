/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cmd;


/**
 *
 * @author Tomáš Malčík
 */
public interface CmdInterface {

    public boolean isRunning();
    
    //public void setIsRunning(boolean status);

    public String getActualDir();

    public String parseAndExecute(String line);
    
//    public void changeActualDir(File path);
    
}
