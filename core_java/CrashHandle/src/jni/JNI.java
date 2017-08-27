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

public class JNI {

//    static {
//        
//        //System.load("/home/mani/jni_test/JNI/classes/libHello.so");
//        System.load("/home/mani/jni_test/JNI/socreate/libHello.so");
//    }

    public native void setEmp(Employe emp);

    ///public native void sayHello(int a);

    //public native void passStr(String msg);

    public JNI() {

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
        
        
        //JNI jni = new JNI();

        //jni.sayHello(1300);
        
        //jni.passStr("String msg");
        
        //jni.setEmp(new Employe("manikandan", 25));
        
        Employe emp1=new Employe("manikandan", 25);
        
        Employe emp3=emp1;
        
        emp3.name="changed";
        
            System.out.println("emp1 " + emp1.name);
        
        Employe emp2=new Employe("manikandan k ", 26);
        
        emp1=emp2;
        
        System.out.println("emp " + emp1.name + " , " + emp1.age);
        
        }
        catch(Exception ex){
            ex.printStackTrace();
        }

    }

}
