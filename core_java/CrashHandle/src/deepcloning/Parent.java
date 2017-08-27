/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deepcloning;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mani
 */
public class Parent implements Cloneable {
    
    private String key;
    private String value;
    private List<Child> childList;
    
    public Parent(){
        
    }
    
    public Parent(String key,String value,List<Child> childList){
        this.key = key;
        this.value = value;
        this.childList = childList;        
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public List<Child> getChildList() {
        return childList;
    }

    public void setChildList(List<Child> childList) {
        this.childList = childList;
    }
    
    
    @Override
    public Parent clone() throws CloneNotSupportedException{
        super.clone();
        List<Child> cloneChLst=new ArrayList(childList.size());
        
        childList.stream().forEach((ch) -> {
            cloneChLst.add(ch);
        });
        
        Parent clonePar=new Parent(key,value,cloneChLst);
        
        return clonePar;
    }
    
    
    
}
