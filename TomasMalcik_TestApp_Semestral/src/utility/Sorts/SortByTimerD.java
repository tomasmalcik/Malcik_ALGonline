/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utility.Sorts;

import db.Results;
import java.util.Comparator;

/**
 *
 * @author Tomáš Malčík
 */
public class SortByTimerD implements Comparator<Results>{
    //This class sorts via comparator given arraylist, sorts by Timer, descending
    @Override
    public int compare(Results t, Results t1) {
        return (int) (t1.getTimer() - t.getTimer());
    }
    
}
