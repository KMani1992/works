/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jaxbparser;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mani
 */

public class Depart {
    
    String depName;
    List<Employe> employe=new ArrayList();
    
    public Depart(){
        
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    public List<Employe> getEmploye() {
        return employe;
    }

    public void setEmploye(List<Employe> employe) {
        this.employe = employe;
    }
    
    
    
    
    
}
