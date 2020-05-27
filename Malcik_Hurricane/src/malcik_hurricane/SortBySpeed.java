/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package malcik_hurricane;

import java.util.Comparator;

/**
 *
 * @author thomi
 */
public class SortBySpeed implements Comparator<Hurricane>{

    @Override
    public int compare(Hurricane t, Hurricane t1) {
        return t1.getKnots() - t.getKnots();
    }
    
}
