/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utility.strategy;

import GUI.Window;
import utility.ButtonStrategy;
import utility.Components.CheckStudent;
import utility.Components.Settings;

/**
 *
 * @author Tomáš Malčík
 */
public class Settings_load implements ButtonStrategy {
    //this class uses strategy method - loads settings
    @Override
    public void doAction() {
       Window.getInstance().changePanel(new Settings());
    }
    
}
