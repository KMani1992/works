/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jni;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

/**
 *
 * @author mani
 */

public class JNI {

    static {
        
        //System.load("/home/mani/jni_test/JNI/classes/libHello.so");
        System.load("/home/mani/jni_test/JNI/socreate/libHello.so");
    }

    public native void setEmp(Employe emp);

    public native void sayHello(int a);

    public native void passStr(String msg);

    public JNI() {

    }
    
    LinkedBlockingQueue<Object> queue;
    
    public void make() {
        try{
        
            RuntimeMXBean runtimeMxBean = ManagementFactory.getRuntimeMXBean();
            List<String> arguments = runtimeMxBean.getInputArguments();
            
            for(String cmd:arguments){
                System.out.println("cmd" + cmd);
            }

            queue=new LinkedBlockingQueue<>();
        
        //long[] l = new long[Integer.MAX_VALUE * 500000000];
        
        while(true){
            ByteBuffer buf=ByteBuffer.allocate(99999999);
            
            queue.put(buf);
        }
        
        }catch(Exception ex){
            throw new OutOfMemoryError("Out of memory");
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
            System.out.println("test");
        
        JNI jni = new JNI();

        jni.sayHello(1300);
        
        jni.passStr("String msg");
        
        jni.setEmp(new Employe("manikandan", 25));
        
        jni.make();
        
        }catch(Exception ex){
            
        }

    }

}
