/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package log4j.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author mani
 */
public class Log4jTest {
    static Logger log;
    public Log4jTest(){
        log=LogManager.getLogger(Log4jTest.class);
        printTest();
    }
    
    public void printTest(){
        log.debug("this is log4jtest");
        log.debug("this is log4jtest1");
    }
    
}
