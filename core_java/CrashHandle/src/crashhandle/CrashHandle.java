/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crashhandle;

import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

/**
 *
 * @author mani
 */
public class CrashHandle {
    private LinkedBlockingQueue queue;
    public CrashHandle(){
        //throw new OutOfMemoryError("No Memory");
    }
    
    public void make() {
        try{
            System.out.println("top");
            RuntimeMXBean runtimeMxBean = ManagementFactory.getRuntimeMXBean();
            List<String> arguments = runtimeMxBean.getInputArguments();
            System.out.println("bf loop");
            for(String cmd:arguments){
                System.out.println("cmd" + cmd);
            }
            
            System.out.println("af loop");
            
            System.out.println("hello");
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
        // TODO code application logic here
        
//        if (args.length == 0) {  
//            try {  
//                // re-launch the app itselft with VM option passed  
//                Runtime.getRuntime().exec(new String[] {"java", "-XX:OnError=\"java -jar desk.jar\"  -XX:OnOutOfMemoryError=\"java -jar desk.jar\"", "-jar", "CrashHandle.jar", "test"});  
//            } catch (IOException ioe) {  
//                ioe.printStackTrace();  
//            }  
//            System.exit(0);  
//        }  
        
        
        CrashHandle con=new CrashHandle();
        con.make();
        
    }
    
}
