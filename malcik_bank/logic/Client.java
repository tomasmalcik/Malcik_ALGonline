package logic;

import java.util.ArrayList;

/**
 *
 * @author Tomas Malcik
 */
public abstract class Client{
   private String name;
   private ArrayList<Account> accounts = new ArrayList<>();

   public void addAccount(double input){
       
       Account a = new Account(input, name);     
       this.accounts.add(a);   
   }
   
   public double giveSumAll(){
       double sum=0;
       for(Account a: accounts){
           sum+=a.getSum();
       }
       return sum;
   }
   public abstract String getName();

   
   
}
