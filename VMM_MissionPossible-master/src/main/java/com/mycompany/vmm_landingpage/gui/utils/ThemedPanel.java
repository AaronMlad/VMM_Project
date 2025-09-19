/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.vmm_landingpage.gui.utils;

import java.awt.LayoutManager;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author lenovo
 */
public class ThemedPanel extends JPanel implements ThemeManager.ThemeChangeListener{
    public ThemedPanel() {
        super();
        setupTheme();
        ThemeManager.getInstance().addThemeChangeListener(this);
    }

    public ThemedPanel(LayoutManager layout) {
        super(layout);
        setupTheme();
        ThemeManager.getInstance().addThemeChangeListener(this);
    }

    private void setupTheme() {
        ThemeManager themeManager = ThemeManager.getInstance();
        setBackground(themeManager.getBackgroundColor());
        setForeground(themeManager.getForegroundColor());
    }

    @Override
    public void onThemeChanged(boolean isDarkMode) {
        SwingUtilities.invokeLater(() -> {
            ThemeManager themeManager = ThemeManager.getInstance();
            setBackground(themeManager.getBackgroundColor());
            setForeground(themeManager.getForegroundColor());
            repaint();
        });
    }

    @Override
    public void removeNotify() {
        super.removeNotify();
        ThemeManager.getInstance().removeThemeChangeListener(this);
    }

}
