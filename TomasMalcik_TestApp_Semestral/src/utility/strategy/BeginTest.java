/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utility.strategy;

import GUI.Window;
import utility.ButtonStrategy;
import utility.Components.CheckStudent;

/**
 *
 * @author Tomáš Malčík
 */
public class BeginTest implements ButtonStrategy {
    //this class uses strategy method - loads checkStudent panel
    @Override
    public void doAction() {
        Window.getInstance().changePanel(new CheckStudent());
    }
    
}
