package utility.strategy;

import GUI.Window;
import utility.ButtonStrategy;
import utility.Components.Result_Window;
import utility.FileSystem;

/**
 *
 * @author Tomáš Malčík
 */
public class ShowResults implements ButtonStrategy{
    //this class uses strategy method - loads Results panel
    @Override
    public void doAction() {
        Window.getInstance().changePanel(new Result_Window());
        
    }
    
}
