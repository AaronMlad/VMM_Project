/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.vmm_landingpage.gui;

import com.mycompany.vmm_landingpage.gui.panels.Start;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author lenovo
 */
public class CurrentFrame extends JFrame{
    private static CardLayout cardLayout;
    private static JPanel centralPanel;
    
    private Dimension screenSize;
    private int screenWidth;
    private int screenHeight;
    
    public CurrentFrame(){
        initializeFrame();
        setupUI();
    }
    
    public void initializeFrame(){
        this.setTitle("VMM_LandingPage");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setMinimumSize(new Dimension(800,600));
        
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        
        screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        screenWidth = screenSize.width * 3/4;
        screenHeight = screenSize.height * 2/3;
        
        setSize(screenWidth,screenHeight);
    }
    public void setupUI(){
        cardLayout = new CardLayout();
        centralPanel = new JPanel(cardLayout);
        
        centralPanel.add(new Start());
        
        this.add(centralPanel,BorderLayout.CENTER);
        this.showCard("Landing");
    }
    public static void showCard(String text){
        cardLayout.show(centralPanel, text);
    }   
}
