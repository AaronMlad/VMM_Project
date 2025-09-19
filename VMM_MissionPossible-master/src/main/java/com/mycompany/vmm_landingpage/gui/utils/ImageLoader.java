/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.vmm_landingpage.gui.utils;

import javax.swing.ImageIcon;

/**
 *
 * @author lenovo
 */
public class ImageLoader {
    private static ImageLoader instance;
        
    private ImageIcon TwitterIcon = new ImageIcon("src\\main\\resources\\twitter-x-logo-png-9.png");
    private ImageIcon FacebookIcon = new ImageIcon("src\\main\\resources\\facebook-logo.png");
    private ImageIcon InstagramIcon = new ImageIcon("src\\main\\resources\\1658587303instagram-png.png");
    private ImageIcon Logo = new ImageIcon("src\\main\\resources\\MP_Logo.png");
    private ImageIcon NoteTaking = new ImageIcon("src\\main\\resources\\notetaking.jpeg");
    
    private ImageLoader(){
    }
    
    public static ImageLoader getInstance() {
        if (instance == null) {
            instance = new ImageLoader();
        }
        return instance;
    }

    public ImageIcon getTwitterIcon() {
        return TwitterIcon;
    }
    public ImageIcon getFacebookIcon() {
        return FacebookIcon;
    }
    public ImageIcon getInstagramIcon() {
        return InstagramIcon;
    }
    public ImageIcon getLogo() {
        return Logo;
    }
    public ImageIcon getNote() {
        return NoteTaking;
    }
}
