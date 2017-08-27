/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roundprogressbar;

import java.awt.Dimension;

/**
 *
 * @author mani
 */
public class RoundProgressBar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {

                Frame_ProgressBar rndProg = new Frame_ProgressBar();
                Dimension dim = new Dimension(500, 500);
                rndProg.setMinimumSize(dim);
                rndProg.setMaximumSize(dim);
                rndProg.setSize(dim);
                rndProg.setPreferredSize(dim);
                rndProg.setVisible(true);
            }
        });

    }

}
