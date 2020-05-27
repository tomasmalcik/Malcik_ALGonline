/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polynoms;

/**
 *
 * @author thomi
 */
public class Polynomy {
    private Polynomy(){
        
    }
    public static Polynom sum(Polynom a, Polynom b){
        Polynom max = a.getDegree() > b.getDegree()? a:b;
        Polynom min = a.getDegree() <=b.getDegree()? a:b;
        double[] sum = new double[max.getDegree()+1];
        for (int i = 0; i < sum.length; i++) {
            sum[i] = max.getCoefAt(i);
        }
        for (int i = 0; i <min.getDegree()+1 ; i++) {
            sum[i] = sum[i] + min.getCoefAt(i);
        }
        return Polynom.getInstanceReverted(sum);
    }
    public static void main(String[] args){
        Polynom p1 = Polynom.getInstanceReverted(3,0,2,5);
        Polynom p2 = Polynom.getInstanceReverted(2,1,4);
        System.out.println(sum(p1,p2));
    }
}