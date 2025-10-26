/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.vmm_landingpage.gui.panels.ToDoAppPanels;

import com.mycompany.vmm_landingpage.gui.utils.ThemeManager;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author lenovo
 */
public class CreateNoteFactory {
    public static JPanel createNotePanel() {

        JPanel createNoteBar = new JPanel();
        createNoteBar.setPreferredSize(new Dimension(Integer.MAX_VALUE, 60));
        createNoteBar.setBackground(new Color(245, 222, 179));
        createNoteBar.setLayout(new BorderLayout());
        createNoteBar.setBorder(BorderFactory.createEmptyBorder());

        // LEFT SECTION
        JPanel createNoteBar_Left = new JPanel();
        createNoteBar_Left.setPreferredSize(new Dimension(100, Integer.MAX_VALUE));
        createNoteBar_Left.setBackground(new Color(245, 222, 179));

        // CENTER SECTION
        JPanel createNoteBar_Center = new JPanel();
        createNoteBar_Center.setBackground(new Color(245, 222, 179));
        createNoteBar_Center.setLayout(new FlowLayout(FlowLayout.LEFT));

        JButton createNoteButton = new JButton("+");
        createNoteButton.setPreferredSize(new Dimension(45, 45));
        createNoteButton.setBackground(new Color(0, 0, 0, 0));
        createNoteButton.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));
        createNoteButton.setFont(createNoteButton.getFont().deriveFont(Font.BOLD, 30f));
        createNoteButton.setForeground(Color.BLACK);
        createNoteButton.setContentAreaFilled(true);
        createNoteButton.setOpaque(false);
        createNoteButton.setFocusable(false);

        JTextField noteTitleField = new JTextField("Enter note title...");
        noteTitleField.setPreferredSize(new Dimension(250, 45));
        noteTitleField.setBackground(Color.WHITE);
        noteTitleField.setForeground(Color.GRAY);
        noteTitleField.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(ThemeManager.getInstance().getVmmGreen(), 1),
            BorderFactory.createEmptyBorder(8, 12, 8, 12)
        ));
        noteTitleField.setFont(noteTitleField.getFont().deriveFont(Font.PLAIN, 14f));

        // placeholder for note creation text field
        noteTitleField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (noteTitleField.getText().equals("Enter note title...")) {
                    noteTitleField.setText("");
                    noteTitleField.setForeground(Color.BLACK);
                } else if (noteTitleField.getText().equals("Please enter a note title...")) {
                    noteTitleField.setText("");
                    noteTitleField.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (noteTitleField.getText().isEmpty()) {
                    noteTitleField.setText("Enter note title...");
                    noteTitleField.setForeground(Color.GRAY);
                } else if (noteTitleField.getText().equals("Please enter a note title...")) {
                    noteTitleField.setForeground(Color.RED);
                }
            }
        });

        createNoteButton.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                createNoteButton.setBackground(ThemeManager.getInstance().getVmmGreen());
                createNoteButton.setOpaque(true);
            }
            public void mouseExited(MouseEvent evt) {
                createNoteButton.setBackground(new Color(0, 0, 0, 0));
                createNoteButton.setOpaque(false);
            }
        });

        // note creation
        createNoteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String noteTitle = noteTitleField.getText();
                if (noteTitle.equals("Enter note title...") || noteTitle.trim().isEmpty()) {
                    // feedback that title is required
                    noteTitleField.setText("Please enter a note title...");
                    noteTitleField.setForeground(Color.RED);
                } else {
                    // placeholder for actual note creation
                    System.out.println("Creating note with title: " + noteTitle);
                    // reset the text field after creating note
                    noteTitleField.setText("Enter note title...");
                    noteTitleField.setForeground(Color.GRAY);
                }
            }
        });

        createNoteBar_Center.add(createNoteButton);
        createNoteBar_Center.add(noteTitleField);

        // RIGHT SECTION empty space for alignment
        JPanel createNoteBar_Right = new JPanel();
        createNoteBar_Right.setPreferredSize(new Dimension(100, Integer.MAX_VALUE));
        createNoteBar_Right.setBackground(new Color(245, 222, 179)); // F5DEB3 beige color

        createNoteBar.add(createNoteBar_Left, BorderLayout.WEST);
        createNoteBar.add(createNoteBar_Center, BorderLayout.CENTER);
        createNoteBar.add(createNoteBar_Right, BorderLayout.EAST);

        return createNoteBar;
    }
}
