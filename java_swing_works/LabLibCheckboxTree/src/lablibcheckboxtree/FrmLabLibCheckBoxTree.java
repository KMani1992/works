/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lablibcheckboxtree;

import it.cnr.imaa.essi.lablib.gui.checkboxtree.CheckboxTree;
import it.cnr.imaa.essi.lablib.gui.checkboxtree.CheckboxTreeCellRenderer;
import it.cnr.imaa.essi.lablib.gui.checkboxtree.DefaultCheckboxTreeCellRenderer;
import it.cnr.imaa.essi.lablib.gui.checkboxtree.QuadristateButtonModel;
import it.cnr.imaa.essi.lablib.gui.checkboxtree.TreeCheckingEvent;
import it.cnr.imaa.essi.lablib.gui.checkboxtree.TreeCheckingListener;
import it.cnr.imaa.essi.lablib.gui.checkboxtree.TreeCheckingModel;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

/**
 *
 * @author mani
 */
public class FrmLabLibCheckBoxTree extends javax.swing.JFrame {

    private CheckboxTree checkboxTree;
    /**
     * Creates new form LabLibCheckBoxTree
     */
    public FrmLabLibCheckBoxTree() {
        initComponents();

        checkboxTree = new CheckboxTree();

        checkboxTree.setCellRenderer(new DefaultCheckboxTreeCellRenderer() {

            /**
             * Decorates this renderer based on the passed in components.
             */
            public Component getTreeCellRendererComponent(JTree tree, Object object, boolean selected, boolean expanded, boolean leaf, int row,
                    boolean hasFocus) {
                /*
                * most of the rendering is delegated to the wrapped 
                * DefaultTreeCellRenderer, the rest depends on the TreeCheckingModel 
                 */
                this.label.getTreeCellRendererComponent(tree, object, selected, expanded, leaf, row, hasFocus);
                if (tree instanceof CheckboxTree) {
                    
                    boolean checked=false;
                    if (object instanceof Parent) {
                        
                        Parent par=(Parent)object;
                        checked=1==par.value;
                        System.out.println("in parent dsdsd");
                    }

                    TreeCheckingModel checkingModel = ((CheckboxTree) tree).getCheckingModel();
                    TreePath path = tree.getPathForRow(row);
                    this.checkBox.setEnabled(checkingModel.isPathEnabled(path));
                    //boolean checked = checkingModel.isPathChecked(path);
                    boolean greyed = checkingModel.isPathGreyed(path);
                    if (checked && !greyed) {
                        this.checkBox.setState(QuadristateButtonModel.State.CHECKED);
                    }
                    if (!checked && greyed) {
                        this.checkBox.setState(QuadristateButtonModel.State.GREY_UNCHECKED);
                    }
                    if (checked && greyed) {
                        this.checkBox.setState(QuadristateButtonModel.State.GREY_CHECKED);
                    }
                    if (!checked && !greyed) {
                        this.checkBox.setState(QuadristateButtonModel.State.UNCHECKED);
                    }
                }
                return this;
            }

        });
        
        
        
        
                
        
        
        
        DefaultMutableTreeNode rootNode = new Root("root",1);

        DefaultMutableTreeNode parentNode = new Parent("parent",1);
        rootNode.add(parentNode);
        rootNode.add(new Parent("Parent1",2));
        rootNode.add(new Parent("Parent2",3));

        
        
        DefaultMutableTreeNode childNode = new Child("child",1);
        
        
        TreePath treePath = new TreePath(childNode.getPath());
        
        
        
        
        parentNode.add(childNode);
        
        
        
        

        DefaultTreeModel yourNewTreeModel = new DefaultTreeModel(rootNode);
        
       // yourNewTreeModel.get
        
        
        
        
        
        checkboxTree.setModel(yourNewTreeModel);

        checkboxTree.getCheckingModel().setCheckingMode(
                TreeCheckingModel.CheckingMode.PROPAGATE_PRESERVING_UNCHECK);
        checkboxTree.setSelectsByChecking(true);
        
        checkboxTree.getCheckingModel().addCheckingPath(treePath); 
        checkboxTree.setShowsRootHandles(true);
        checkboxTree.addTreeCheckingListener(new TreeCheckingListener() {
            @Override
            public void valueChanged(TreeCheckingEvent e) {

                System.out.println("Checked paths changed: user clicked on "
                        + (e.getPath().getLastPathComponent()));
                
                
                Parent lastPathComponent = (Parent)(e.getPath().getLastPathComponent());
                
                System.out.println("e" + e.isCheckedPath());
                
                
                System.out.println(lastPathComponent.value);
                        
            }
        });

        checkboxTree.setPreferredSize(new Dimension(300, 300));
        checkboxTree.setSize(new Dimension(300, 300));
        this.getContentPane().add(checkboxTree,BorderLayout.CENTER);
        
        this.pack();

        //checkboxTree.
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        butCheck = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        butCheck.setText("Click");
        butCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butCheckActionPerformed(evt);
            }
        });
        getContentPane().add(butCheck, java.awt.BorderLayout.NORTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void butCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butCheckActionPerformed
        // TODO add your handling code here:
        TreePath[] checkingPaths = checkboxTree.getCheckingModel().getCheckingPaths();
        
        if (checkingPaths[0].getLastPathComponent() instanceof Parent){
            System.out.println("parent");
        }
        
        System.out.println(null==checkingPaths);
        
    }//GEN-LAST:event_butCheckActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmLabLibCheckBoxTree.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmLabLibCheckBoxTree.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmLabLibCheckBoxTree.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmLabLibCheckBoxTree.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmLabLibCheckBoxTree().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton butCheck;
    // End of variables declaration//GEN-END:variables
}
