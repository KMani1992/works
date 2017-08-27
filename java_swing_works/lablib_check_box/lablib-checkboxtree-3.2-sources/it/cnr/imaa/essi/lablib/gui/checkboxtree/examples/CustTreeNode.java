/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.cnr.imaa.essi.lablib.gui.checkboxtree.examples;

import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author mani
 */
public class CustTreeNode extends DefaultMutableTreeNode{
    
    private boolean selected;
    
    public CustTreeNode(String name,boolean selected){
        super(name);
        this.selected=selected;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
    
    
    
}
