/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jaxbparser;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author mani
 */
public class JAXBParser {

    public JAXBParser() {

    }

    OrgMap orgMap = new OrgMap();

    public void addData() {

        Employe employe = new Operator();
        employe.setEmpName("Mani");
        List<Employe> empList = new ArrayList();
        empList.add(employe);

        Depart depart = new Depart();
        depart.setDepName("Dep1");
        depart.setEmploye(empList);
        List<Depart> depList = new ArrayList();
        depList.add(depart);

        employe = new Manager();
        employe.setEmpName("Mani manager");
        employe.setDesig("Manager");
        empList = new ArrayList();
        empList.add(employe);

        depart = new Depart();
        depart.setDepName("Dep2");
        depart.setEmploye(empList);
        depList.add(depart);

        Organ org = new Organ();
        org.setOrgName("Org 1");
        org.setListDep(depList);

        Map<String, Organ> mapOrg = new HashMap();
        mapOrg.put("Org1", org);

        orgMap.setMapOrg(mapOrg);
    }

    public void saveData() {
        try {
            JAXBContext context = JAXBContext.newInstance(OrgMap.class, Operator.class, Manager.class);
            Marshaller marsaller = context.createMarshaller();
            marsaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marsaller.marshal(orgMap, System.out);
            marsaller.marshal(orgMap, new File("/home/mani/jaxbTest.xml"));
        } catch (JAXBException ex) {
            Logger.getLogger(JAXBParser.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void readData() {
        try {
            JAXBContext context = JAXBContext.newInstance(OrgMap.class, Operator.class, Manager.class);
            Unmarshaller unmarsaller = context.createUnmarshaller();
            orgMap = (OrgMap) unmarsaller.unmarshal(new File("/home/mani/jaxbTest.xml"));

        } catch (JAXBException ex) {
            Logger.getLogger(JAXBParser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void printData() {
        Map<String, Organ> mapOrg = orgMap.getMapOrg();
        Organ orgn = mapOrg.get("Org1");
        List<Depart> listDep = orgn.getListDep();

        for (Depart dep : listDep) {
            System.out.println("dep.getDepName() > " + dep.getDepName());
            List<Employe> employe = dep.getEmploye();

            for (Employe emp : employe) {
                
                System.out.println("emp.getEmpName() >" + emp.getEmpName());
                
                if (emp instanceof Manager) {
                    System.out.println("emp.getDesig() >" + emp.getDesig());
                }
            }

        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        JAXBParser jax = new JAXBParser();
        jax.addData();
        jax.saveData();
//        jax.readData();
//        jax.printData();
    }
}

//
//@XmlRootElement specifies the root element for the xml document.
//
//@XmlAttribute specifies the attribute for the root element.
//
//@XmlElement specifies the sub element for the root element.
//
//
// File file = new File("employee.xml");    
//            JAXBContext jaxbContext = JAXBContext.newInstance(Employee.class);    
//         
//            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();    
//            Employee e=(Employee) jaxbUnmarshaller.unmarshal(file);    
//            System.out.println(e.getId()+" "+e.getName()+" "+e.getSalary());  
//import java.io.InputStream;
//import java.util.List;
//
//import javax.xml.bind.JAXBContext;
//import javax.xml.bind.Unmarshaller;
//import javax.xml.bind.annotation.XmlAttribute;
//import javax.xml.bind.annotation.XmlElement;
//import javax.xml.bind.annotation.XmlElementWrapper;
//import javax.xml.bind.annotation.XmlRootElement;
//import javax.xml.bind.annotation.XmlValue;
//
//@XmlRootElement(name = "authStore")
//@XmlAccessorType(XmlAccesssType.FIELD)
//public class AuthStore {
//    public static void main(String []args) throws Exception {
//        InputStream inputStream = AuthStore.class.getResourceAsStream("test.xml");
//        JAXBContext jaxbContext = JAXBContext.newInstance(AuthStore.class);
//        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
//        AuthStore authStore = (AuthStore)unmarshaller.unmarshal(inputStream);
//
//        System.out.println(authStore.getAuthList().get(0).getResource());
//        System.out.println(authStore.getAuthList().get(0).getPrivilege().getRegex());
//        System.out.println(authStore.getAuthList().get(0).getPrivilege().getValue());
//    }
//
//    @XmlElementWrapper(name = "authList")
//    @XmlElement(name = "auth")
//    private List<Auth> authList;
//
//    public List<Auth> getAuthList() {
//        return authList;
//    }
//
//    @XmlAccessorType(XmlAccesssType.FIELD)
//    public static class Auth {
//        @XmlElement(name = "resource")
//        private String resource;
//        @XmlElement(name = "privilege")
//        private Privilege privilege;
//
//        public String getResource() {
//            return resource;
//        }
//
//        public Privilege getPrivilege() {
//            return privilege;
//        }
//
//        @XmlAccessorType(XmlAccesssType.FIELD)
//            public static class Privilege {
//            @XmlAttribute(name = "regex")
//            private Boolean regex;
//            @XmlValue
//            private String value;
//
//            public Boolean getRegex() {
//                return regex;
//            }
//
//            public String getValue() {
//                return value;
//            }
//        }
//    }
//}
