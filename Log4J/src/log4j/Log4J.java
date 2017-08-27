/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package log4j;

import java.text.SimpleDateFormat;
import java.util.Date;
import log4j.test.Log4jTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author mani
 */
public class Log4J {

    static {
        System.setProperty("hname", "mani");
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
        System.setProperty("current.date.time", dateFormat.format(new Date()));
    }

    static Logger logger = LogManager.getLogger(Log4J.class);
    public Log4jTest log4jTest;

    public Log4J() {
        log4jTest = new Log4jTest();
        for (int i = 0; i < 1000; i++) {
            foo();
        }
    }

    private void foo() {

        // TODO code application logic here
        logger.debug("hai Hello log4j");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Log4J log = new Log4J();
    }

}
