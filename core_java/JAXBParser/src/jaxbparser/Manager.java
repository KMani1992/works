/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jaxbparser;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author mani
 */

@XmlType(propOrder = {"empName","desig"})
public class Manager extends Employe {

    String desig;

    @Override    
    public String getDesig() {
        return desig;
    }

    @Override    
    public void setDesig(String desig) {
        this.desig = desig;
    }

}
