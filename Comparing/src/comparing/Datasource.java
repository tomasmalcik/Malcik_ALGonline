/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comparing;


import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Tomáš Malčík
 */
public class Datasource {
    private static Student[] data = {
        new Student("Jan","Maly",1234,20),
        new Student("Alice","Velka",1334,19),
        new Student("Bob","Pech",1954,18)
    };
    
    public static Student[] loadDataAsArray(){
        return Arrays.copyOf(data, data.length);
    }
    public static List<Student> loadDataAsList(){
        return Arrays.asList(data);
    }
}
