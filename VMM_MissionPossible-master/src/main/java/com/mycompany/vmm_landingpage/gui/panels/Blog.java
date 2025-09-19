/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.vmm_landingpage.gui.panels;

import com.mycompany.vmm_landingpage.gui.utils.ThemeManager;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author lenovo
 */
public class Blog extends JPanel{
    private ThemeManager themeManager;
    private JPanel mainPanel;
    private JLabel titleLabel;
    private JLabel memberLabel;
    
    public Blog(){
        this.themeManager = ThemeManager.getInstance();
        initializeUI();
        //themeManager.addThemeChangeListener(isDarkMode -> updateTheme());
    }
    private void initializeUI(){
        setBackground(themeManager.getBackgroundColor());
        
        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(new EmptyBorder(50, 100, 100, 100));
        mainPanel.setOpaque(false);
        
        titleLabel = new JLabel();
        titleLabel.setText("<html>Recent Updates: </html>");
        titleLabel.setForeground(themeManager.getForegroundColor());
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 45));
        titleLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        memberLabel = new JLabel();
        memberLabel.setText("<html>Update 1.1: added Blog and About Us Pages + Dark Mode<br>Update 1.0: Added Landing Page</html>");
        memberLabel.setForeground(themeManager.getForegroundColor());
        memberLabel.setFont(new Font("Segoe UI", Font.PLAIN, 25));
        memberLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        mainPanel.add(titleLabel);
        mainPanel.add(memberLabel);
        add(mainPanel, BorderLayout.CENTER);
    }
}
