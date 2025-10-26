/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.vmm_landingpage.gui.utils;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Window;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;

/**
 *
 * @author lenovo
 */
public class ThemeManager {
    private static ThemeManager instance;
    private boolean darkMode = false;
    
    private final List<ThemeChangeListener> listeners = new ArrayList<>();
    
    // Color schemes
    
    // (Currently Unused but a part of the Color Palette)
    private Color VMM_Maroon = new Color(0xBB0000); 
    private Color VMM_Beige = new Color(0xF5DEB3); 
    private Color VMM_Red = new Color(0xFF4500); 
    private Color VMM_Grey = new Color(0xD3D3D3);
    
    
    // (Used Colors)
    private Color VMM_White = Color.WHITE;
    private Color VMM_Green = new Color(0x2E8B57); 
    private Color VMM_Black = new Color(0x161b1f);
    
    private Color VMM_LightGreen = new Color(0x12a52b);
    private Color VMM_DarkGrey = new Color(0x2C2D3D);
    private Color VMM_LightGrey = new Color(0x6F7375);
    
    ////LIGHT COLORS
    
    private Color lightBackground = VMM_White;
    private Color lightForeground = VMM_Green;
    private Color lightComponent = VMM_Black;
    
    private Color lightForegroundSelect = VMM_Red;
    private Color lightBackgroundSelect = VMM_Grey;
    
    ////DARK COLORS
    
    private Color darkBackground = VMM_DarkGrey;
    private Color darkForeground = VMM_LightGreen;
    private Color darkComponent = VMM_White;
    
    private Color darkForegroundSelect = VMM_Red;
    private Color darkBackgroundSelect = VMM_LightGrey;


    private ThemeManager() {
        // Private constructor for singleton
    }

    public static ThemeManager getInstance() {
        if (instance == null) {
            instance = new ThemeManager();
        }
        return instance;
    }
    
    public boolean isDarkMode() {
        return darkMode;
    }
    
    public void toggleDarkMode() {
        darkMode = !darkMode;
        applyThemeToAllComponents();
        notifyListeners();
    }
    
    public void setDarkMode(boolean darkMode) {
        this.darkMode = darkMode;
        applyThemeToAllComponents();
        notifyListeners();
    }
    
    public void addThemeChangeListener(ThemeChangeListener listener) {
        listeners.add(listener);
    }
    
    public void removeThemeChangeListener(ThemeChangeListener listener) {
        listeners.remove(listener);
    }
    
    private void notifyListeners() {
        for (ThemeChangeListener listener : listeners) {
            listener.onThemeChanged(darkMode);
        }
    }
    
    public void applyThemeToAllComponents() {
        // Apply to all existing frames and dialogs
        for (Window window : Window.getWindows()) {
            applyThemeToContainer(window);
        }
    }
    
    public void applyThemeToContainer(Container container) {
        applyThemeToComponent(container);
        
        for (Component comp : container.getComponents()) {
            if (comp instanceof Container) {
                applyThemeToContainer((Container) comp);
            } else {
                applyThemeToComponent(comp);
            }
        }
    }
    
    private void applyThemeToComponent(Component comp) {
        if (darkMode) {
            applyDarkTheme(comp);
        } else {
            applyLightTheme(comp);
        }
    }
    
    private void applyDarkTheme(Component comp) {
        comp.setForeground(darkForeground);
        
        if (comp instanceof JComponent) {
            JComponent jcomp = (JComponent) comp;
            
            if (jcomp instanceof JPanel || jcomp instanceof JLabel) {                
                jcomp.setBackground(darkBackground);
                
            } else if (jcomp instanceof JButton || jcomp instanceof JTextField || 
                       jcomp instanceof JComboBox || jcomp instanceof JList) {
                jcomp.setBackground(darkComponent);
                jcomp.setBorder(BorderFactory.createLineBorder(new Color(100, 100, 100)));
            }
            
            // Special cases
            if (jcomp instanceof JTextArea || jcomp instanceof JTextPane) {
                jcomp.setBackground(darkComponent);
                jcomp.setForeground(darkForeground);
            }
            
            if (jcomp instanceof JScrollPane) {
                jcomp.setBackground(darkBackground);
            }
        }
    }
    
    private void applyLightTheme(Component comp) {
        comp.setForeground(lightForeground);
        
        if (comp instanceof JComponent) {
            JComponent jcomp = (JComponent) comp;
            
            if (jcomp instanceof JPanel || jcomp instanceof JLabel) {
                jcomp.setBackground(lightBackground);
            } else if (jcomp instanceof JButton || jcomp instanceof JTextField || 
                       jcomp instanceof JComboBox || jcomp instanceof JList) {
                jcomp.setBackground(lightComponent);
                jcomp.setBorder(BorderFactory.createLineBorder(Color.GRAY));
            }
            
            // Special cases
            if (jcomp instanceof JTextArea || jcomp instanceof JTextPane) {
                jcomp.setBackground(lightComponent);
                jcomp.setForeground(lightForeground);
            }
            
            if (jcomp instanceof JScrollPane) {
                jcomp.setBackground(lightBackground);
            }
        }
    }
    
    // Color getters
    public Color getBackgroundColor() {
        return darkMode ? darkBackground : lightBackground;
    }
    
    public Color getForegroundColor() {
        return darkMode ? darkForeground : lightForeground;
    }
    
    public Color getComponentColor() {
        return darkMode ? darkComponent : lightComponent;
    }
    
    public Color getButtonBackground() {
        return darkMode ? VMM_White : VMM_Green;
    }
    
    public Color getButtonForeground() {
        return darkMode ? VMM_Black : VMM_White;
    }
    
    public Color getVmmRed() {
        return VMM_Red;
    }
    
    public Color getVmmGreen() {
        return VMM_Green;
    }
    
    public Color getVmmLightGreen() {
        return VMM_LightGreen;
    }
    
    public Color getTextSecondary() {
        return darkMode ? VMM_White : VMM_DarkGrey;
    }
    
    public Color getForegroundSelectColor() {
        return darkMode ? darkForegroundSelect : lightForegroundSelect;
    }
    public Color getBackgroundSelectColor() {
        return darkMode ? darkBackgroundSelect : lightBackgroundSelect;
    }
    
    public interface ThemeChangeListener {
        void onThemeChanged(boolean isDarkMode);
    }
}
