/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.vmm_landingpage.gui.components.ToDoAppComponents;

import com.mycompany.vmm_landingpage.gui.CurrentFrame;
import java.awt.*;
import javax.swing.JButton;

/**
 *
 * @author lenovo
 */
public class ButtonCreator extends JButton{
        public ButtonCreator(String text) {
        setPreferredSize(new Dimension(200, 20));
        setBackground(Color.WHITE);
        setFocusable(false);
        setText(text);
//        addActionListener(e -> {
//            CurrentFrame.showCard("LANDING");
//        });
    }
}
