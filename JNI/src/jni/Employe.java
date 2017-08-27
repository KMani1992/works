/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jni;

/**
 *
 * @author mani
 */
public class Employe {
    
    public String name;
    public int age;
    
    public Inner in;
    /**
     *
     * @param name
     * @param age
     */
    public Employe(String name,int age){
        this.name = name;
        this.age = age;
        this.in=new Inner(300);
        
    }
    
}
