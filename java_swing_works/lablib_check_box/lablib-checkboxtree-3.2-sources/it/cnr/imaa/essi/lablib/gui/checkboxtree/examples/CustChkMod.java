/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.cnr.imaa.essi.lablib.gui.checkboxtree.examples;

import it.cnr.imaa.essi.lablib.gui.checkboxtree.DefaultTreeCheckingModel;
import it.cnr.imaa.essi.lablib.gui.checkboxtree.TreeCheckingListener;
import it.cnr.imaa.essi.lablib.gui.checkboxtree.TreeCheckingModel;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

/**
 *
 * @author mani
 */
public class CustChkMod extends DefaultTreeCheckingModel implements TreeCheckingModel {
    
    public CustChkMod(TreeModel model) {
        super(model);
    }

    @Override
    public void addCheckingPath(TreePath path) {
        super.addCheckingPath(path);
    }

    @Override
    public void addCheckingPaths(TreePath[] paths) {
        super.addCheckingPaths(paths);
    }

    @Override
    public void addTreeCheckingListener(TreeCheckingListener tcl) {
        super.addTreeCheckingListener(tcl);
    }

    @Override
    public void clearChecking() {
        super.clearChecking();
    }

    @Override
    public CheckingMode getCheckingMode() {
        return super.getCheckingMode();
    }

    @Override
    public TreePath[] getCheckingPaths() {
        return super.getCheckingPaths();
    }

    @Override
    public TreePath[] getCheckingRoots() {
        return super.getCheckingRoots();
    }

    @Override
    public TreePath[] getGreyingPaths() {
        return super.getGreyingPaths();
    }

    @Override
    public boolean isPathChecked(TreePath path) {
        return super.isPathChecked(path);
    }

    @Override
    public boolean isPathEnabled(TreePath path) {
        return super.isPathEnabled(path);
    }

    @Override
    public boolean isPathGreyed(TreePath path) {
        return super.isPathGreyed(path);
    }

    @Override
    public void removeCheckingPath(TreePath path) {
        super.removeCheckingPath(path);
    }

    @Override
    public void removeCheckingPaths(TreePath[] paths) {
        super.removeCheckingPaths(paths);
    }

    @Override
    public void removeTreeCheckingListener(TreeCheckingListener tcl) {
        super.removeTreeCheckingListener(tcl);
    }

    @Override
    public void setCheckingMode(CheckingMode mode) {
        super.setCheckingMode(mode);
    }

    @Override
    public void setCheckingPath(TreePath path) {
        super.setCheckingPath(path);
    }

    @Override
    public void setCheckingPaths(TreePath[] paths) {
        super.setCheckingPaths(paths);
    }

    @Override
    public void setPathEnabled(TreePath path, boolean enable) {
        super.setPathEnabled(path, enable);
    }

    @Override
    public void setPathsEnabled(TreePath[] paths, boolean enable) {
        super.setPathsEnabled(paths, enable);
    }
    
    void addToCheckedPathsSet(TreePath path) {

        Object obj = path.getLastPathComponent();

        if (obj instanceof CustTreeNode) {
            CustTreeNode node = (CustTreeNode) obj;
            node.setSelected(true);
            System.out.println(node.toString());
        }

        this.checkedPathsSet.add(path);
    }

    void removeFromCheckedPathsSet(TreePath path) {

        Object obj = path.getLastPathComponent();

        if (obj instanceof CustTreeNode) {
            CustTreeNode node = (CustTreeNode) obj;
            node.setSelected(false);
            System.out.println(node.toString() + " remove cust");
        }

        this.checkedPathsSet.remove(path);

    }

    @Override
    public void toggleCheckingPath(TreePath pathForRow) {
        super.toggleCheckingPath(pathForRow);
    }
    
}
