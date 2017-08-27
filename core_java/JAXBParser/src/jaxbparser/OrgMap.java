/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jaxbparser;

import java.util.HashMap;
import java.util.Map;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mani
 */
@XmlRootElement(name="OrganizationMap")
@XmlAccessorType(XmlAccessType.FIELD)
public class OrgMap {
    
    Map<String,Organ> mapOrg=new HashMap();
    
    public OrgMap(){
        
    }

    public Map<String, Organ> getMapOrg() {
        return mapOrg;
    }

    public void setMapOrg(Map<String, Organ> mapOrg) {
        this.mapOrg = mapOrg;
    }
    
    
    
    
}
