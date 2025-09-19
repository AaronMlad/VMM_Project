package com.mycompany.vmm_landingpage.gui.panels;

import com.mycompany.vmm_landingpage.gui.utils.ImageLoader;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import com.mycompany.vmm_landingpage.gui.utils.ThemeManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Landing panel that displays the main welcome screen
 */
public class Landing extends JPanel {
    private ThemeManager themeManager;
    private JButton getStartedButton;
    
    private JPanel centerPanel;
    private JPanel leftPanel;
    private JPanel rightPanel;
    
    private JLabel titleLabel;
    private JLabel subtitleLabel;
    private JLabel descriptionLabel;
        
    public Landing() {
        this.themeManager = ThemeManager.getInstance();
        initializeUI();
        themeManager.addThemeChangeListener(isDarkMode -> updateTheme());
    }
    
    private void initializeUI() {
        setLayout(new BorderLayout());
        
        centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(1, 2));
        
        //CENTER : IMAGE SLOGAN PANEL
        leftPanel = new JPanel();
        leftPanel.setBackground(themeManager.getBackgroundColor());
        
        JLabel slogan = new JLabel();
        slogan.setText("Note taking beyond knowledge.");
        slogan.setForeground(Color.BLACK);
        slogan.setFont(new Font("Helvetica Bold", Font.BOLD, 30));
        slogan.setVerticalAlignment(JLabel.CENTER);
        slogan.setHorizontalAlignment(JLabel.CENTER);
        slogan.setPreferredSize(new Dimension(500,100));
        
        leftPanel.add(slogan);
        leftPanel.add(new JLabel(new ImageIcon(ImageLoader.getInstance().getNote().getImage().getScaledInstance(650, 450, Image.SCALE_REPLICATE))));
        
        // Create main content panel with padding
        rightPanel = new JPanel();
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
        
        rightPanel.setBorder(new EmptyBorder(60, 100, 60, 100));
        rightPanel.setOpaque(false);
        
        titleLabel = new JLabel();
        titleLabel.setText("<html>Mission Possible</html>");
        titleLabel.setForeground(themeManager.getForegroundColor());
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 45));
        titleLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        // The actual text and colors will be set in updateTheme()
        
        // Subtitle
        subtitleLabel = new JLabel("<html>Your time.<br>Your goals.<br>You're the boss.</html>");
        subtitleLabel.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        subtitleLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        subtitleLabel.setForeground(themeManager.getTextSecondary());
        subtitleLabel.setBorder(new EmptyBorder(10, 0, 30, 0));
        
        // Description
        descriptionLabel = new JLabel("Start and stop whenever you want.");
        descriptionLabel.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        descriptionLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        descriptionLabel.setForeground(themeManager.getTextSecondary());
        descriptionLabel.setBorder(new EmptyBorder(10, 0, 30, 0));
        
        // Button
        getStartedButton = new JButton("Get Started");
        getStartedButton.setFont(new Font("Segoe UI", Font.BOLD, 16));
        getStartedButton.setAlignmentX(Component.LEFT_ALIGNMENT);
        getStartedButton.setOpaque(true);
        getStartedButton.setContentAreaFilled(true);
        getStartedButton.setBorderPainted(false);
        getStartedButton.setFocusPainted(false);
        getStartedButton.setPreferredSize(new Dimension(150, 45));
        getStartedButton.setMaximumSize(new Dimension(150, 45));
        getStartedButton.setBackground(themeManager.getButtonBackground());
        getStartedButton.setForeground(themeManager.getButtonForeground());
        
        getStartedButton.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                getStartedButton.setBackground(ThemeManager.getInstance().getBackgroundSelectColor());
                getStartedButton.repaint();
            };
            @Override
            public void mouseExited(MouseEvent e){
                getStartedButton.setBackground(themeManager.getButtonBackground());
                getStartedButton.repaint();
            }
            @Override
            public void mouseClicked(MouseEvent e){
                JOptionPane.showMessageDialog(null,"Getting Started!");        
            }
        });

        
        rightPanel.add(titleLabel);
        rightPanel.add(subtitleLabel);
        rightPanel.add(descriptionLabel);
        rightPanel.add(getStartedButton);
        
        centerPanel.add(leftPanel);
        centerPanel.add(rightPanel);
        
        add(centerPanel,BorderLayout.CENTER);
        
        
        //add(rightPanel, BorderLayout.EAST);
        
        updateTheme();
    }
    
    /**
     * Updates the UI components to match the current theme
     */
    public void updateTheme() {
        if (centerPanel != null) {
            centerPanel.setBackground(themeManager.getBackgroundColor());
            
            // Update button colors
            if (getStartedButton != null) {
                getStartedButton.setBackground(themeManager.getButtonBackground());
                getStartedButton.setForeground(themeManager.getButtonForeground());
                getStartedButton.setOpaque(true);
                getStartedButton.setContentAreaFilled(true);
                getStartedButton.setBorderPainted(false);
            }
            subtitleLabel.setForeground(themeManager.getTextSecondary());
            descriptionLabel.setForeground(themeManager.getTextSecondary());
            
            revalidate();
            repaint();
        }
    }
}
