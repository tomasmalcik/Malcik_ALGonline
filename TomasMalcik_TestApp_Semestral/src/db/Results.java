package db;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="Results")

/**
 * @author Tomáš Malčík
 * This class is representing one row of database result - you use it while selecting.
 */
public class Results  implements java.io.Serializable {


     private Integer idR;
     private String testDate;
     private String studentNum;
     private String testName;
     private double percentage;
     private long timer;

    public Results() {
    }

    public Results(String studentNum, String testName, double percentage, long timer, String testDate) {
       this.studentNum = studentNum;
       this.testName = testName;
       this.percentage = percentage;
       this.timer = timer;
       this.testDate = testDate;
    }
    
    /*
    --------------------
    Getters and setters
    --------------------
    */
    
    @Id @GeneratedValue(strategy=IDENTITY)
    @Column(name="idR", nullable=false)
    public Integer getIdR() {
        return this.idR;
    }
    public void setIdR(Integer idR) {
        this.idR = idR;
    }
    
    @Column(name="testDate", nullable=false)
    public String getTestDate() {
        return this.testDate;
    }
    public void setTestDate(String testDate) {
        this.testDate = testDate;
    }

    @Column(name="studentNum", nullable=false)
    public String getStudentNum() {
        return this.studentNum;
    }
    public void setStudentNum(String studentNum) {
        this.studentNum = studentNum;
    }
    
    @Column(name="testName", nullable=false)
    public String getTestName() {
        return this.testName;
    }
    public void setTestName(String testName) {
        this.testName = testName;
    }
    
    @Column(name="percentage", nullable=false)
    public double getPercentage() {
        return this.percentage;
    }
    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }
    
    @Column(name="timer", nullable=false)
    public long getTimer() {
        return this.timer;
    }
    public void setTimer(long timer) {
        this.timer = timer;
    }




}


