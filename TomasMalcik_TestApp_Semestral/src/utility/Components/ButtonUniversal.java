package utility.Components;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import utility.ButtonStrategy;

/**
 *
 * @author Tomáš Malčík
 */
public class ButtonUniversal extends JButton {
    
    ButtonStrategy strat;
    
    public ButtonUniversal() {
        
    }
    /**
     * Button with strategy method.
     * @param s - strategy to use.
     */
    public ButtonUniversal(ButtonStrategy s) {
        this.strat = s;
        this.addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent me) {
                strat.doAction();
            }

            @Override
            public void mousePressed(MouseEvent me) {
                
            }

            @Override
            public void mouseReleased(MouseEvent me) {
                
            }

            @Override
            public void mouseEntered(MouseEvent me) {
                
            }

            @Override
            public void mouseExited(MouseEvent me) {
                
            }
        
        });
    }
    
}
