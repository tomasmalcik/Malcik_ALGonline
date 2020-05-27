package utility.Components;

import GUI.Window;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JPanel;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utility.FileSystem;
import utility.NewHibernateUtil;
import utility.QuestionInterface;
import utility.Questions.MultipleRight;
import utility.Questions.OneRight;
import utility.Questions.Written;
import db.Results;
import java.time.LocalDate;

/**
 *
 * @author Tomáš Malčík
 */
public class Test extends DefaultPanel {
    
    //variables
    ArrayList<QuestionInterface> questions;
    String route = "C:\\Users\\thomi\\Semestral\\test\\test1.txt";
    String studentNum;
    String nameOfTest;
    double percentage;
    int i = 0;
    boolean evaluate = false;
    
    /**
     * Creates new form Test, this panel is the main one for test - it has arraylist of questions
     * It controls everything - going back and forth between questions
     *                        - evaluation
     *                        - starts timer
     */
    public Test(String studentNum) {
        //who is taking the test
        this.studentNum = studentNum;
        
        //defining arraylist, loading questions
        questions = new ArrayList<QuestionInterface>();
        loadQuestions();
        //init
        initComponents();
        initialize();
        this.jButton2.setEnabled(false);
        timer2.start();
        
        //starting with first question
        changePanel((JPanel) (questions.get(0)));
    }
    
    /*
    ------------------
    functions
    ------------------
    */
    
    /**
     * This function swaps questions
     * @param panel - which question to load into test panel
     */
    public void changePanel(JPanel panel) {
        //clear any content
        MainPanel.removeAll();
        
        //set location
        MainPanel.setLocation((MainPanel.getWidth() - panel.getWidth())/2, (MainPanel.getHeight() - panel.getHeight())/2);
        panel.setLocation(85,21);
        
        //add, validate
        MainPanel.add(panel);
        MainPanel.revalidate();
        MainPanel.validate();
        MainPanel.repaint();
        
    }
    
    /**
     * loads questions, separates them by the type
     */
    public void loadQuestions() {
        //load data from file
        ArrayList<String> ar = new ArrayList<String>();
        ar = FileSystem.load(route);
        
        //first line check
        boolean b = true;
        
        //load questions
        for(String line : ar) {
            //split by #
           String[] splits =  line.split("#");
           try {
               if(b) {
                   this.nameOfTest = splits[0];
                   b = false;
                   continue;
               }
               
               //parse the type of question
               int k = Integer.parseInt(splits[0]);
               
               //add to arraylist based on the type
               addQuestion(k,splits);
               
           }catch(Exception e) {
               //catch error
               System.err.print("Couldn't load questions. Error caused by: "+e);
           }
        }
    }
    
    /**
     * 
     * @param k - type of question
     * @param splits - line of file splitted.
     */
    private void addQuestion(int k, String[] splits) {
        if(k == 0) {
            //written answer
            Written w = new Written(splits[1], splits[2]);
            this.questions.add(w);
        }else if(k == 1) {
            //one out of four right
            OneRight r = new OneRight(splits[1],splits[2],splits[3],splits[4],splits[5],Integer.parseInt(splits[6]));
            this.questions.add(r);
        }else if(k == 2) {
            //multiple out of four right
            MultipleRight m = new MultipleRight(splits[1],splits[2],splits[3],
            splits[4],splits[5],new ArrayList<String>(Arrays.asList(splits[6].split(","))));
            this.questions.add(m);          
        }   
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MainPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        timer2 = new utility.Components.Timer();

        setBackground(new java.awt.Color(118, 180, 233));
        setMaximumSize(new java.awt.Dimension(1024, 768));
        setMinimumSize(new java.awt.Dimension(1024, 768));
        setPreferredSize(new java.awt.Dimension(1024, 768));

        MainPanel.setBackground(new java.awt.Color(118, 180, 233));
        MainPanel.setPreferredSize(new java.awt.Dimension(971, 643));

        javax.swing.GroupLayout MainPanelLayout = new javax.swing.GroupLayout(MainPanel);
        MainPanel.setLayout(MainPanelLayout);
        MainPanelLayout.setHorizontalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 971, Short.MAX_VALUE)
        );
        MainPanelLayout.setVerticalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 640, Short.MAX_VALUE)
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(162, 62));
        jPanel1.setMinimumSize(new java.awt.Dimension(162, 62));

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(25, 94, 121));
        jButton2.setText("Předchozí otázka");
        jButton2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(25, 94, 121), 2));
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                previousQuestion(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setMaximumSize(new java.awt.Dimension(162, 62));
        jPanel2.setMinimumSize(new java.awt.Dimension(162, 62));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(25, 94, 121));
        jButton1.setText("Další otázka");
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(25, 94, 121), 2));
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nextQuestion(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(java.awt.Color.white);
        jPanel3.setMaximumSize(new java.awt.Dimension(162, 62));
        jPanel3.setMinimumSize(new java.awt.Dimension(162, 62));
        jPanel3.setPreferredSize(new java.awt.Dimension(162, 62));

        timer2.setForeground(new java.awt.Color(25, 94, 121));
        timer2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        timer2.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(timer2, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(timer2, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(MainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(132, 132, 132)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(137, 137, 137)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(MainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 640, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    /**
     * -----------------
     * another functions
     * -----------------
     */
    
    /**
     * This function loads next question in line
     * @param evt 
     */
    private void nextQuestion(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nextQuestion
        this.i++;
        if(this.i < questions.size()) {
            changePanel((JPanel) (questions.get(this.i)));
            this.jButton2.setEnabled(true);
            if( this.i == questions.size()-1 ) {
                this.jButton1.setText("Vyhodnoť");
            }
        }else {
            evaluateAll();
        }
    }//GEN-LAST:event_nextQuestion

    /**
     * This function evaluates every question - uses its function evaluateQuestion()
     */
    public void evaluateAll() {
        //stops timer
        timer2.stop();
        
        if(!evaluate){
            if(!checkFilledQuestions()) {
                return;
            }
        }
        
        //number of correct answers
        int nRight = 0;
        
        //checks which questions are correct
        for (int i = 0; i < questions.size(); i++) {
            if(questions.get(i).evaluateQuestion()) {
                nRight++;
            }
        }
        
        percentage = ((double) (nRight))/((double) (questions.size()))*100;
        
        //saves to db
        saveToDb();
        
        //loads result window
        new ShowTestResult(nRight,questions.size()).setVisible(true);
        Window.getInstance().setVisible(false);
    }
    
    public void setButtonText(String str) {
        timer2.start();
        if(this.i < questions.size()-1) {
            this.jButton1.setText("Další otázka");
            
        }
    }
    
    private boolean checkFilledQuestions() {
        for(int i = 0; i < questions.size(); i++) {
            if(!questions.get(i).checkFilled()) {
                System.out.println("sas "+i);
                new WarningWindow(questions.get(i),this,i).setVisible(true);
                return false;
            }
        }
        return true;
    }
    /**
     * This function saves test result to database
     */
    private void saveToDb() {
        //time - using java.time
        LocalDate l = LocalDate.now();
        
        //begins transaction
        Transaction t = Window.getInstance().session.beginTransaction();
        
        //creates a new row
        Results r = new Results(this.studentNum,this.nameOfTest, percentage, timer2.milisec, l+"");
        
        //save
        Window.getInstance().session.save(r);
        t.commit();
    }
    
    /**
     * This function loads previous question
     * @param evt 
     */
    private void previousQuestion(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_previousQuestion
       if(this.i != 0) {
           this.i--;
           changePanel((JPanel) (questions.get(this.i)));
           this.jButton1.setText("Další otázka");
       }else {
           this.jButton2.setEnabled(false);
       }
    }//GEN-LAST:event_previousQuestion


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel MainPanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private utility.Components.Timer timer2;
    // End of variables declaration//GEN-END:variables
}
