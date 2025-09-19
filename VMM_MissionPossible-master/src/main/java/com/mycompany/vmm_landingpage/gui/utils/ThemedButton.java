/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.vmm_landingpage.gui.utils;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.SwingUtilities;

/**
 *
 * @author lenovo
 */
public class ThemedButton extends JButton implements ThemeManager.ThemeChangeListener {
    public ThemedButton(String text) {
        super(text);
        setupTheme();
        ThemeManager.getInstance().addThemeChangeListener(this);
    }

    private void setupTheme() {
        ThemeManager themeManager = ThemeManager.getInstance();
        setBackground(themeManager.getComponentColor());
        setForeground(themeManager.getForegroundColor());
        setBorder(BorderFactory.createLineBorder(Color.GRAY));
        setFocusPainted(false);
    }

    @Override
    public void onThemeChanged(boolean isDarkMode) {
        SwingUtilities.invokeLater(() -> {
            ThemeManager themeManager = ThemeManager.getInstance();
            setBackground(themeManager.getComponentColor());
            setForeground(themeManager.getForegroundColor());
        });
    }

    @Override
    public void removeNotify() {
        super.removeNotify();
        ThemeManager.getInstance().removeThemeChangeListener(this);
    }
}
