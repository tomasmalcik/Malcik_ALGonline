/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mycomparing;

import comparing.Student;

/**
 *
 * @author Tomáš Malčík
 */
public class ComparatorI {
     public boolean bigger(Object o1, Object o2){
        return ((Student)o1).getNumber() > ((Student)o2).getNumber();
    }
}
