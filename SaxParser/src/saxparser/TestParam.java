/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saxparser;

import java.util.Map;

/**
 *
 * @author mani
 */
public class TestParam {
    
    private String testName;
    
    private Map<Float,BandWidth> mapTestParam;
    
    public TestParam(){
        
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public Map<Float, BandWidth> getMapTestParam() {
        return mapTestParam;
    }

    public void setMapTestParam(Map<Float, BandWidth> mapTestParam) {
        this.mapTestParam = mapTestParam;
    }
    
    
    
}
