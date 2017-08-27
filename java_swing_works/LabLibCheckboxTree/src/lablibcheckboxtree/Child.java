/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lablibcheckboxtree;

import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author mani
 */
public class Child extends DefaultMutableTreeNode{

    String name;
    int value;

    public Child(String name, int value) {
        this.name = name;
        this.value = value;

    }

    @Override
    public String toString() {
        return name;
    }

}
