
package utility.Components;

import javax.swing.JPanel;

/**
 *
 * @author Tomáš Malčík
 */
public abstract class DefaultPanel extends JPanel {
    //This class serves as a default panel with default size.
    public void initialize() {
      this.setSize(1024,768);
      
    }
    
}
