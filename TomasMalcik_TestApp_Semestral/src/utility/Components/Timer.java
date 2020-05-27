package utility.Components;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JLabel;

//this class creates a timer independent to everything, uses another thread

/**
 * 
 * @author Tomáš Malčík
 */

public class Timer extends JLabel{
    //init
    public int milisec=0;
    public int celkovycas=0;
    public long cas=0;
    public boolean stopnuto=false;
    public boolean zapnuto=false;
    public Thread t;
    
    /**
     * This function starts the Timer
     */
    public void start(){
        if(!zapnuto){
            if(stopnuto){
                stopnuto=false;
                celkovycas=milisec;
            }
            cas=System.currentTimeMillis();
        }
            zapnuto=true;
    }
    
    /**
     * This function stops Timer
     */
    public void stop(){
        stopnuto=true;
        zapnuto=false;
    }
    
    
    /**
     * This function resets timer
     */
    public void reset(){
        stopnuto=false;
        zapnuto=false;
        celkovycas=0;
        milisec=0;
        this.setText("00:00:000");
        t=new Thread(){
            @Override
            public void run(){
                for(;;){
                    try {
                        if(!Timer.this.isValid() && Timer.this.getSize().width!=0){
                            this.stop();
                        }
                        if(zapnuto){
                        milisec=(int)(System.currentTimeMillis()-cas)+celkovycas;
                        updateCas();}
                        this.sleep(75);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }
            }
        };
        t.start();
    }
    
    /**
     * This method is used to print the duration of timer running
     */
    public void updateCas(){
        this.setText((new SimpleDateFormat("mm:ss:SSS")).format(new Date(milisec)));
        this.repaint();
    }
    
    public Timer(){
        super();
        this.setText("00:00:000");
        //uses a new thread
        t=new Thread(){
            @Override
            public void run(){
                for(;;){
                    try {
                        //check if the resolution is valid
                        if(!Timer.this.isValid() && Timer.this.getSize().width!=0){
                            this.stop();
                        }
                        //running
                        if(zapnuto){
                        milisec=(int)(System.currentTimeMillis()-cas)+celkovycas;
                        updateCas();}
                        this.sleep(75);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }
            }
        };
        t.start();
    }
}

