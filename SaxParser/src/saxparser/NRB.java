/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saxparser;

import java.util.List;
import java.util.Map;

/**
 *
 * @author mani
 */
public class NRB {
    
    private int idx;
    private int value;
    private Map<String, RBP> lstRBP;
    
    public NRB(){
        
    }

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Map<String, RBP> getMapRBP() {
        return lstRBP;
    }

    public void setMapRBP(Map<String, RBP> mapRBP) {
        this.lstRBP = mapRBP;
    }
    
    
    
}
