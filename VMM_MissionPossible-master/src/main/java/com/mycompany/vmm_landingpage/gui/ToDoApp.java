/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.vmm_landingpage.gui;

import com.mycompany.vmm_landingpage.gui.components.ToDoAppComponents.NavigationBarFactory;
import com.mycompany.vmm_landingpage.gui.components.ToDoAppComponents.SidebarFactory;
import com.mycompany.vmm_landingpage.gui.panels.ToDoAppPanels.Bin;
import com.mycompany.vmm_landingpage.gui.panels.ToDoAppPanels.CreateNoteFactory;
import com.mycompany.vmm_landingpage.gui.panels.ToDoAppPanels.Dashboard;
import com.mycompany.vmm_landingpage.gui.panels.ToDoAppPanels.Folders;
import com.mycompany.vmm_landingpage.gui.panels.ToDoAppPanels.Reminders;
import javax.swing.*;
import java.awt.*;


public class ToDoApp extends JFrame{ //MainFrame
    private static CardLayout cardLayout;
    private static JPanel centralPanel;

    private Dimension screenSize;
    private int screenWidth;
    private int screenHeight;

    private JPanel navigationBar;
    private JPanel createNoteBar;
    private JPanel sidebar;
    private JButton menuButton;

    public ToDoApp(){
        initializeFrame();
        setupUI();
    }

    public void initializeFrame(){
        this.setTitle("VMM ToDo Application");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setMinimumSize(new Dimension(800,600));

        this.setLocationRelativeTo(null);
        this.setResizable(false);

        screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        screenWidth = screenSize.width * 3/4;
        screenHeight = screenSize.height * 2/3;

        setSize(screenWidth,screenHeight);
    }

    private void setupUI(){
        cardLayout = new CardLayout();
        centralPanel = new JPanel(cardLayout);
        centralPanel.add(new Dashboard(), "TO-DO");
        centralPanel.add(new Reminders(), "REMINDERS");
        centralPanel.add(new Folders(), "FOLDERS");
        centralPanel.add(new Bin(), "BIN");

        navigationBar = NavigationBarFactory.createNavigationBar(50);
        sidebar = SidebarFactory.createCollapseableSidebar(300, 70, this::handleSidebarEvent);

        // get menu button from navigation bar
        menuButton = NavigationBarFactory.getMenuButton(navigationBar);

        // connect menu button to sidebar 
        if (menuButton != null) {
            menuButton.addActionListener(e -> {
                // toggle sidebar
                boolean isCollapsed = sidebar.getPreferredSize().width <= 70;
                if (isCollapsed) {
                    sidebar.setPreferredSize(new Dimension(300, Integer.MAX_VALUE));
                } else {
                    sidebar.setPreferredSize(new Dimension(70, Integer.MAX_VALUE));
                }
                sidebar.revalidate();
                sidebar.repaint();
            });
        }

        // Create main content area with createNoteBar
        JPanel mainContentArea = createMainContentArea();

        this.add(navigationBar, BorderLayout.NORTH);
        this.add(mainContentArea, BorderLayout.CENTER);
    }

    private JPanel createMainContentArea() {
        JPanel mainArea = new JPanel(new BorderLayout());

        // Create right side content (createNoteBar + central panel stacked vertically)
        JPanel rightSideContent = new JPanel(new BorderLayout());

        // Add createNoteBar at the top of the right side (spans remaining width)
        createNoteBar = CreateNoteFactory.createNotePanel();
        rightSideContent.add(createNoteBar, BorderLayout.NORTH);

        // Add central panel below createNoteBar
        rightSideContent.add(centralPanel, BorderLayout.CENTER);

        // Add sidebar to the left and right side content to the right
        mainArea.add(sidebar, BorderLayout.WEST);
        mainArea.add(rightSideContent, BorderLayout.CENTER);

        return mainArea;
    }

    private void handleSidebarEvent(String text){
        System.out.println("Sidebar clicked: " + text);
        switch(text) {
            case "TO-DO":
                cardLayout.show(centralPanel, "TO-DO");
                break;
            case "REMINDERS":
                cardLayout.show(centralPanel, "REMINDERS");
                break;
            case "FOLDERS":
                cardLayout.show(centralPanel, "FOLDERS");
                break;
            case "BIN":
                cardLayout.show(centralPanel, "BIN");
                break;
            default:
                System.out.println("GOOEY");
        }
    }
}
