/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utility.strategy;

import GUI.Window;
import utility.ButtonStrategy;

/**
 *
 * @author Tomáš Malčík
 */
public class Quit implements ButtonStrategy {
    //this class uses strategy method - quits program
    @Override
    public void doAction() {
        System.exit(0);
    }
    
}
