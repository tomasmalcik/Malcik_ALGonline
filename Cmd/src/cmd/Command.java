package cmd;

import java.io.File;

/**
 *
 * @author Tomáš Malčík
 */
public abstract class Command {
    public static String COMMAND_PACKAGE = "cmd";
    
    protected String[] params; //dir | -e | .java
    
    public void setParams(String[] params){
        this.params = new String[params.length];
        System.arraycopy(params, 0, this.params, 0, params.length);
    }
    
    public abstract String execute(File actualDir);

}
