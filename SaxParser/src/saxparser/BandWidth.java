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
public class BandWidth {
    
    private float BandWidth;
    
    private Map<Integer,NRB> mapNRB;
    
    public BandWidth(){
        
    }

    public float getBandWidth() {
        return BandWidth;
    }

    public void setBandWidth(float BandWidth) {
        this.BandWidth = BandWidth;
    }

    public Map<Integer, NRB> getMapNRB() {
        return mapNRB;
    }

    public void setMapNRB(Map<Integer, NRB> mapNRB) {
        this.mapNRB = mapNRB;
    }
    
    
    
}
