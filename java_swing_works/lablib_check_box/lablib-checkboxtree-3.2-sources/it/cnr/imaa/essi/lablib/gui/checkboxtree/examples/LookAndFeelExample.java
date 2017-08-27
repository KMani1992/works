/*
 * Copyright 2007-2010 Enrico Boldrini, Lorenzo Bigagli This file is part of
 * CheckboxTree. CheckboxTree is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or (at your
 * option) any later version. CheckboxTree is distributed in the hope that it
 * will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty
 * of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General
 * Public License for more details. You should have received a copy of the GNU
 * General Public License along with CheckboxTree; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA
 * 02110-1301, USA
 */
package it.cnr.imaa.essi.lablib.gui.checkboxtree.examples;

import it.cnr.imaa.essi.lablib.gui.checkboxtree.CheckList;
import it.cnr.imaa.essi.lablib.gui.checkboxtree.CustCheckModel;
import it.cnr.imaa.essi.lablib.gui.checkboxtree.CheckboxTree;
import it.cnr.imaa.essi.lablib.gui.checkboxtree.DefaultCheckboxTreeCellRenderer;
import it.cnr.imaa.essi.lablib.gui.checkboxtree.DefaultTreeCheckingModel;
import it.cnr.imaa.essi.lablib.gui.checkboxtree.QuadristateButtonModel.State;
import it.cnr.imaa.essi.lablib.gui.checkboxtree.TreeCheckingEvent;
import it.cnr.imaa.essi.lablib.gui.checkboxtree.TreeCheckingListener;
import it.cnr.imaa.essi.lablib.gui.checkboxtree.TreeCheckingModel;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.plaf.metal.DefaultMetalTheme;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.metal.OceanTheme;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

/**
 * An example showcase for the various look and feels. There are issues with
 * dynamically changing the L&F of a CheckboxTree.
 *
 * @author bigagli
 * @author boldrini
 */
public class LookAndFeelExample extends JFrame implements ActionListener {

    private CheckboxTree checkboxTree = null;

    private javax.swing.JPanel jContentPane = null;

    public static void main(String[] args) {
        // Schedule a job for the event dispatch thread:
        // creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                    System.out.println(info);
                }
                System.out.println("Cross-platform L&F: " + UIManager.getCrossPlatformLookAndFeelClassName());
                createAndShowGUI();
            }
        });
    }

    /**
     * Create the GUI and show it. For thread safety, this method should be
     * invoked from the event dispatch thread.
     */
    private static void createAndShowGUI() {
        // Set the look and feel
        try {
            String lafName = "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel";
            // String lafName = UIManager.getSystemLookAndFeelClassName();
            System.out.println("Setting the L&F: " + lafName);
            UIManager.setLookAndFeel(lafName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        // Make sure we have nice window decorations
        // JFrame.setDefaultLookAndFeelDecorated(true);
        // Create and set up the window
        JFrame frame = new LookAndFeelExample();
        // Display the window
        frame.pack();
        frame.setVisible(true);
    }

    /**
     * Creates the frame.
     */
    public LookAndFeelExample() {
        this.setContentPane(getJContentPane());
        this.setTitle("CheckboxTree");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setJMenuBar(getLAFMenuBar());
    }

    /**
     * This method initializes jContentPane
     *
     * @return javax.swing.JPanel
     */
    private JPanel getJContentPane() {
        if (this.jContentPane == null) {
            this.jContentPane = new JPanel();
            this.jContentPane.setLayout(new BorderLayout());
            this.jContentPane.add(getCheckboxTree(), BorderLayout.CENTER);
        }
        return this.jContentPane;
    }

    /**
     * This method initializes the CheckboxTree
     *
     * @return it.cnr.imaa.essi.lablib.gui.checkboxtree.CheckboxTree
     */
    private JScrollPane getCheckboxTree() {
        if (this.checkboxTree == null) {
            this.checkboxTree = new CheckboxTree();
            
            
            
            DefaultMutableTreeNode root = (DefaultMutableTreeNode) this.checkboxTree.getModel().getRoot();

            CustTreeNode ravioli = new CustTreeNode("Test",true);// ravioli;

            ravioli.add(new CustTreeNode("al tartufo",true));
            
            ravioli.add(new CustTreeNode("alla salvia",true));
            for (int i = 2; i < 10; i++) {
                ravioli.add(new CustTreeNode("ai " + i + " formaggi",false));
                
                
            }
            //checkboxTree.setModel(null);
            //((DefaultTreeModel) this.checkboxTree.getModel()).nodeStructureChanged(root);
            //this.checkboxTree.addCheckingPath(new TreePath(ravioli.getPath()));

            DefaultTreeModel yourNewTreeModel = new DefaultTreeModel(ravioli);
            checkboxTree.setModel(yourNewTreeModel);
            checkboxTree.expandAll();
            
            
            this.checkboxTree.getCheckingModel().setCheckingMode(TreeCheckingModel.CheckingMode.PROPAGATE_PRESERVING_UNCHECK);
            DefaultTreeCheckingModel checkModel=(DefaultTreeCheckingModel) checkboxTree.getCheckingModel();
            
            checkModel.setCheckList(new CheckList() {
                @Override
                public void rmpath(TreePath path) {
                    System.out.println("list rm");
                }
            });

            //DefaultTreeCheckingModel checkModel=new DefaultTreeCheckingModel(yourNewTreeModel);           
            //checkModel.addCheckingPath(new TreePath(ravioli.getPath()));
//            checkboxTree.setCheckingModel(checkModel);
            //checkModel.setCheckingPath(new TreePath(ravioli.getPath()));
            
            
            checkModel.setCheckingMode(TreeCheckingModel.CheckingMode.PROPAGATE_PRESERVING_UNCHECK);             
            checkModel.addCheckingPath(new TreePath(ravioli.getPath()));
            
                        
            
            //checkSubTree();
            
            
        }
        return new JScrollPane(this.checkboxTree);
    }
    
    
    private TreeCheckingModel checkModel;
//    
//    
//    private void test(){
//        checkboxTree.setCellRenderer(new DefaultCheckboxTreeCellRenderer() {
//                /**
//                 * Decorates this renderer based on the passed in components.
//                 */
//                @Override
//                public Component getTreeCellRendererComponent(JTree tree, Object object, boolean selected, boolean expanded, boolean leaf, int row,
//                        boolean hasFocus) {
//                    /*
//	 * most of the rendering is delegated to the wrapped
//	 * DefaultTreeCellRenderer, the rest depends on the TreeCheckingModel
//                     */
//                    this.label.getTreeCellRendererComponent(tree, object, selected, expanded, leaf, row, hasFocus);
//                    if (tree instanceof CheckboxTree) {
//                        TreePath path = tree.getPathForRow(row);
//                        TreeCheckingModel checkingModel = ((CheckboxTree) tree).getCheckingModel();
//                        this.checkBox.setEnabled(checkingModel.isPathEnabled(path) && tree.isEnabled());
//                        boolean checked = checkingModel.isPathChecked(path);
//                        boolean greyed = checkingModel.isPathGreyed(path);
//                        
//                        CustTreeNode node=null;
//                        if (null != path) {
//
//                            Object lastPathComponent = path.getLastPathComponent();
//                            if(lastPathComponent instanceof CustTreeNode){
//                                node=((CustTreeNode)lastPathComponent);
//                                checked=node.isSelected();
//                            }
//                            System.out.println(lastPathComponent);
//
//                        }
//
//                        System.out.println("check 1 " + checked + " select " + selected);
//
//                        if (checked && !greyed) {
//                            this.checkBox.setState(State.CHECKED);
//                        }
//                        if (!checked && greyed) {
//                            this.checkBox.setState(State.GREY_UNCHECKED);
//                        }
//                        if (checked && greyed) {
//                            this.checkBox.setState(State.GREY_CHECKED);
//                        }
//                        if (!checked && !greyed) {
//                            this.checkBox.setState(State.UNCHECKED);
//                        }
//                        if(!selected){
//                        if(checked){
//                            this.checkBox.setState(State.CHECKED);
//                        }
//                        }else{
//                            if(null!=node){
//                                node.setSelected(selected);
//                                this.checkBox.setState(selected ? State.CHECKED :State.UNCHECKED);
//                            }
//                        }
//                    }
//                    return this;
//                }
//            });
//    }

    private JMenuBar getLAFMenuBar() {
        JMenuBar retVal = new JMenuBar();
        // Define and add the drop down menu to the menubar
        JMenu lafMenu = new JMenu("Look&Feel");
        retVal.add(lafMenu);

        // Create and add Radio Buttons as simple menu items to one of the drop
        // down menu
        JRadioButtonMenuItem radioAction3 = new JRadioButtonMenuItem("System");
        radioAction3.setSelected(true);
        JRadioButtonMenuItem radioAction1 = new JRadioButtonMenuItem("Metal-default-theme");
        JRadioButtonMenuItem radioAction2 = new JRadioButtonMenuItem("Metal-ocean-theme");
        JRadioButtonMenuItem radioAction4 = new JRadioButtonMenuItem("CDE/Motif");
        JRadioButtonMenuItem radioAction5 = new JRadioButtonMenuItem("GTK");
        JRadioButtonMenuItem radioAction6 = new JRadioButtonMenuItem("Nimbus");
        // Create a ButtonGroup and add both radio Button to it. Only one radio
        // button in a ButtonGroup can be selected at a time.
        ButtonGroup bg = new ButtonGroup();
        bg.add(radioAction1);
        bg.add(radioAction2);
        bg.add(radioAction3);
        bg.add(radioAction4);
        bg.add(radioAction5);
        bg.add(radioAction6);
        lafMenu.add(radioAction1);
        lafMenu.add(radioAction2);
        lafMenu.add(radioAction3);
        lafMenu.add(radioAction4);
        lafMenu.add(radioAction5);
        lafMenu.add(radioAction6);
        // Add a listener to the New menu item. actionPerformed() method will
        // invoked, if user triggered this menu item
        radioAction1.addActionListener(this);
        radioAction2.addActionListener(this);
        radioAction3.addActionListener(this);
        radioAction4.addActionListener(this);
        radioAction5.addActionListener(this);
        radioAction6.addActionListener(this);
        return retVal;
    }

    public void actionPerformed(ActionEvent action) {
        String actionName = action.getActionCommand();
        String lafName = null;
        if (actionName.equals("Metal-default-theme")) {
            lafName = "javax.swing.plaf.metal.MetalLookAndFeel";
            MetalLookAndFeel.setCurrentTheme(new DefaultMetalTheme());
        } else if (actionName.equals("Metal-ocean-theme")) {
            lafName = "javax.swing.plaf.metal.MetalLookAndFeel";
            MetalLookAndFeel.setCurrentTheme(new OceanTheme());
        } else if (actionName.equals("System")) {
            lafName = UIManager.getSystemLookAndFeelClassName();
        } else if (actionName.equals("CDE/Motif")) {
            lafName = "com.sun.java.swing.plaf.motif.MotifLookAndFeel";
        } else if (actionName.equals("GTK")) {
            lafName = "com.sun.java.swing.plaf.gtk.GTKLookAndFeel";
        } else if (actionName.equals("Nimbus")) {
            lafName = "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel";
        }
        try {
            System.out.println("Setting L&F to " + lafName);
            UIManager.setLookAndFeel(lafName);
            SwingUtilities.updateComponentTreeUI(this);
        } catch (ClassNotFoundException e) {
            System.err.println("Couldn't find class for specified look and feel: " + lafName);
            System.err.println("Did you include the L&F library in the class path?");
            System.err.println("Using the default look and feel.");
        } catch (UnsupportedLookAndFeelException e) {
            System.err.println("Can't use the specified look and feel (" + lafName + ") on this platform.");
            System.err.println("Using the default look and feel.");
        } catch (Exception e) {
            System.err.println("Couldn't get specified look and feel (" + lafName + "), for some reason.");
            System.err.println("Using the default look and feel.");
            e.printStackTrace();
        }
    }

}
