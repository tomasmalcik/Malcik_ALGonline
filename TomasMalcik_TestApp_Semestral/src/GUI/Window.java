package GUI;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utility.Components.Settings;
import utility.NewHibernateUtil;

/**
 *
 * @author Tomáš Malčík
 */
public class Window extends javax.swing.JFrame {

    /**
     * Creates window with singleton 
     */
    
    private static Window o;
    public static Session session;
    
    private Window() {
        initComponents();
        //basic setup - centering the window, setting size
        this.setSize(1024,768);
        this.setTitle("Aplikace na Testy v.1");
        this.setLocationRelativeTo(null);
        changePanel(new Settings());
        //database session
        session = NewHibernateUtil.getSessionFactory().openSession();
    }

    //returns link to Window (singleton)
    public static Window getInstance() {
        if(o == null) {
            o = new Window();
        }
            return o;
    }
    
    
    //functions
    
    /**
     * This functions swaps panels and repaints the main window.
     * @param panel - which panel to load into main window. 
     */
    public void changePanel(JPanel panel) {
        //
        jPanel1.removeAll();
        panel.setLocation((jPanel1.getWidth() - panel.getWidth())/2, (jPanel1.getHeight() - panel.getHeight())/2);
        jPanel1.add(panel);
        jPanel1.revalidate();
        jPanel1.validate();
        jPanel1.repaint();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1024, 768));
        setResizable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
