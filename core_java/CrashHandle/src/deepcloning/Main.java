/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deepcloning;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mani
 */
public class Main {
    
    public Main(){
        fillData();
    }
    
    Parent par;
    
    private void fillData(){
        try {
            Parent par=new Parent();
            
            List<Child> chLst=new ArrayList();
            
            Child ch=new Child();
            ch.setKey("Key1");
            ch.setValue("Val1");
            chLst.add(ch);
            
            ch=new Child();
            ch.setKey("Key2");
            ch.setValue("Val2");
            chLst.add(ch);
            
            par.setChildList(chLst);
            par.setKey("Par Key");
            par.setValue("Par Val");
            
            System.out.println("par" + par);
            
            Parent clone = par.clone();
            clone.setKey("clone Key");
            clone.setValue("clone value");
            clone.getChildList().get(0).setKey("clone child");
                        
            System.out.println("after deep cloning");
            
            this.par=clone;
            
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public static void main(String []args){
        Main main=new Main();
    }
    
}
