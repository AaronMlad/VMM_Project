/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.vmm_landingpage;

import com.mycompany.vmm_landingpage.gui.CurrentFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 *
 * @author lenovo
 */
public class VMM_LandingPage{
    public static void main(String[] args) {
        System.out.println("Hello World!");
        SwingUtilities.invokeLater(()->{
            try{
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            }catch(Exception ex){
                ex.printStackTrace();
            }
            CurrentFrame currentFrame = new CurrentFrame();
            currentFrame.setVisible(true);
        });
    }
}
