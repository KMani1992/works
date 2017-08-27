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


public class Organ {

    String orgName;

    List<Depart> listDep = new ArrayList();

    public Organ() {

    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public List<Depart> getListDep() {
        return listDep;
    }

    public void setListDep(List<Depart> listDep) {
        this.listDep = listDep;
    }

}
