/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.vmm_landingpage.gui.utils;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author lenovo
 */
public class DarkModeToggle extends JPanel{
    private final JLabel toggleButton;
    
    public DarkModeToggle() {
        setLayout(new FlowLayout(FlowLayout.RIGHT));
        setOpaque(false);
        
        toggleButton = new JLabel();

        toggleButton.setVerticalAlignment(JLabel.CENTER);
        toggleButton.setHorizontalAlignment(JLabel.CENTER);
        toggleButton.setPreferredSize(new Dimension(50,50));;
                
        updateButtonAppearance();
        
        toggleButton.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                toggleButton.setBackground(ThemeManager.getInstance().getBackgroundSelectColor());
                toggleButton.setForeground(ThemeManager.getInstance().getForegroundSelectColor());
                toggleButton.repaint();
            };
            @Override
            public void mouseExited(MouseEvent e){
                toggleButton.setBackground(ThemeManager.getInstance().getBackgroundColor());
                toggleButton.setForeground(ThemeManager.getInstance().getForegroundColor());
                toggleButton.repaint();
            }
            @Override
            public void mouseClicked(MouseEvent e){
                ThemeManager.getInstance().toggleDarkMode();
                updateButtonAppearance();
            }
        });
        toggleButton.setOpaque(true);

        add(toggleButton);
    }
    
    private void updateButtonAppearance() {
        boolean isDarkMode = ThemeManager.getInstance().isDarkMode();
        
        toggleButton.setFont(new Font("Arials",Font.PLAIN,20));
        
        if (isDarkMode) {
            toggleButton.setText("💡️");
        } else {
            toggleButton.setText("🌙");
        }
        toggleButton.setSize(new Dimension(100,100));

        // Style the button to match current theme
        toggleButton.setBackground(ThemeManager.getInstance().getBackgroundColor());
        toggleButton.setForeground(ThemeManager.getInstance().getForegroundColor());
    }
}
