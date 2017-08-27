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
public class RBP {
    
    private String value;
    private List<FieldParam> lstField;
    private int idx;
    public RBP(){
        
    }

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public List<FieldParam> getLstField() {
        return lstField;
    }

    public void setLstField(List<FieldParam> lstField) {
        this.lstField = lstField;
    }
    
    
    
}

