/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.vmm_landingpage.gui.components.ToDoAppComponents;

import com.mycompany.vmm_landingpage.gui.utils.ThemeManager;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.function.Consumer;
import javax.swing.*;

/**
 *
 * @author lenovo
 */
public class SidebarFactory {
    private static Color DEFAULT_BG = ThemeManager.getInstance().getVmmGreen();
    private static Color HIGHLIGHTED = ThemeManager.getInstance().getVmmLightGreen();
    private static JButton activeButton = null;
    public static JPanel createNavigationSidebar(int width, Consumer<String> onItemClicked) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(DEFAULT_BG);
        panel.setPreferredSize(new Dimension(width, Integer.MAX_VALUE));
        panel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 1));
        
        return panel;
    }
    
    public static JPanel createCollapseableSidebar(int expandedWidth, int collapsedWidth, Consumer<String> onItemClicked) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setPreferredSize(new Dimension(expandedWidth,Integer.MAX_VALUE));
        panel.setBackground(DEFAULT_BG);
        
        
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 5));
//        contentPanel.setBackground(new Color(245, 222, 179));
        
        addNavigationItem(contentPanel, "TO-DO", "✅", onItemClicked);
        addNavigationItem(contentPanel, "REMINDERS", "📅", onItemClicked);
        addNavigationItem(contentPanel, "FOLDERS", "📁", onItemClicked);
        addNavigationItem(contentPanel, "BIN", "♻", onItemClicked);
        
        panel.add(contentPanel, BorderLayout.CENTER);
        return panel;
    }
    
    private static void addNavigationItem(JPanel panel, String text, String icon, Consumer<String> onItemClicked) {
        JButton button = new JButton(icon + "  " + text);
        button.setAlignmentX(Component.LEFT_ALIGNMENT);
        button.setMinimumSize(new Dimension(Integer.MAX_VALUE, 10));
        button.setPreferredSize(new Dimension(Integer.MAX_VALUE, 20));
        button.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        button.setHorizontalAlignment(JButton.LEFT); //da text of da button
        button.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15));
        button.setContentAreaFilled(false);
        button.setFocusable(false);
        button.setFocusPainted(false);
        button.setForeground(Color.BLACK);
        button.setFont(button.getFont().deriveFont(Font.BOLD, 14f));


        button.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                if (button != activeButton) {
                    button.setBackground(HIGHLIGHTED);
                    button.setOpaque(true);
                }
            }
            public void mouseExited(MouseEvent e) {
                if (button != activeButton) {
                    button.setBackground(null);
                    button.setOpaque(false);
                }
            }
        });
        button.addActionListener(e -> {
            if (activeButton != null) {
                activeButton.setBackground(null);
                activeButton.setOpaque(false);
            }

            activeButton = button;
            button.setBackground(DEFAULT_BG);
            button.setOpaque(true);

            onItemClicked.accept(text.toUpperCase());
        });
        
        panel.add(button);
        panel.add(Box.createRigidArea(new Dimension(0, 5)));
    }
}
