/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.vmm_landingpage.gui.components.ToDoAppComponents;

import com.mycompany.vmm_landingpage.gui.utils.ImageLoader;
import com.mycompany.vmm_landingpage.gui.utils.ThemeManager;
import java.awt.*;
import javax.swing.*;

public class NavigationBarFactory{
    public static JPanel createNavigationBar(int height) {

        JPanel NavigationBar = new JPanel();
        NavigationBar.setPreferredSize(new Dimension(Integer.MAX_VALUE, height));
        NavigationBar.setBackground(ThemeManager.getInstance().getVmmGreen());
        NavigationBar.setLayout(new BorderLayout());
        NavigationBar.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, ThemeManager.getInstance().getComponentColor()));

        // LEFT SECTION
        JPanel NavigationBar_Left = new JPanel();
        NavigationBar_Left.setPreferredSize(new Dimension(100, Integer.MAX_VALUE));
        NavigationBar_Left.setBackground(ThemeManager.getInstance().getVmmGreen());

        JButton menuButton = new JButton();
        menuButton.setPreferredSize(new Dimension(34, 34));
        menuButton.setIcon(new ImageIcon(ImageLoader.getInstance().getMenuIcon().getImage().getScaledInstance(34, 34, Image.SCALE_SMOOTH)));
        menuButton.setOpaque(false);
        menuButton.setContentAreaFilled(false); 
        menuButton.setBorderPainted(false); 
        menuButton.setFocusPainted(false); 

        // center icon vertically
        JPanel leftContainer = new JPanel(new BorderLayout());
        leftContainer.setBackground(ThemeManager.getInstance().getVmmGreen());
        leftContainer.setBorder(BorderFactory.createEmptyBorder(2, 0, 2, 0));
        leftContainer.add(menuButton, BorderLayout.CENTER);

        NavigationBar_Left.add(leftContainer, BorderLayout.CENTER);

        // CENTER SECTION
        JPanel NavigationBar_Center = new JPanel();
        NavigationBar_Center.setPreferredSize(new Dimension(200, Integer.MAX_VALUE));
        NavigationBar_Center.setBackground(ThemeManager.getInstance().getVmmGreen());
        NavigationBar_Center.setLayout(new BorderLayout());

        JTextField searchField = new JTextField();
        searchField.setPreferredSize(new Dimension(500, 38));
        searchField.setBackground(Color.WHITE);
        searchField.setForeground(Color.BLACK);
        searchField.setOpaque(true);

        JPanel searchContainer = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        searchContainer.setBackground(ThemeManager.getInstance().getVmmGreen());
        searchContainer.setBorder(BorderFactory.createEmptyBorder(6, 1, 6, 1)); // padding
        searchContainer.add(searchField);

        NavigationBar_Center.add(searchContainer, BorderLayout.CENTER);

        // RIGHT SECTION
        JPanel NavigationBar_Right = new JPanel();
        NavigationBar_Right.setPreferredSize(new Dimension(100, Integer.MAX_VALUE));
        NavigationBar_Right.setBackground(ThemeManager.getInstance().getVmmGreen());
        NavigationBar_Right.setLayout(new BorderLayout());

        JLabel userLogo = new JLabel();
        userLogo.setPreferredSize(new Dimension(34, 34));
        userLogo.setIcon(new ImageIcon(ImageLoader.getInstance().getUserIcon().getImage().getScaledInstance(34, 34, Image.SCALE_SMOOTH)));
        userLogo.setOpaque(false);

        // center icon vertically
        JPanel rightContainer = new JPanel(new BorderLayout());
        rightContainer.setBackground(ThemeManager.getInstance().getVmmGreen());
        rightContainer.setBorder(BorderFactory.createEmptyBorder(2, 0, 2, 0));
        rightContainer.add(userLogo, BorderLayout.CENTER);

        NavigationBar_Right.add(rightContainer, BorderLayout.CENTER);

        NavigationBar.add(NavigationBar_Left, BorderLayout.WEST);
        NavigationBar.add(NavigationBar_Center, BorderLayout.CENTER);
        NavigationBar.add(NavigationBar_Right, BorderLayout.EAST);

        return NavigationBar;
    }

    public static JButton getMenuButton(JPanel navigationBar) {
        // find and return menu button from navigation bar
        return findButtonInPanel(navigationBar);
    }

    private static JButton findButtonInPanel(JPanel panel) {
        for (Component component : panel.getComponents()) {
            if (component instanceof JButton) {
                return (JButton) component;
            } else if (component instanceof JPanel) {
                JButton found = findButtonInPanel((JPanel) component);
                if (found != null) {
                    return found;
                }
            }
        }
        return null;
    }
}
