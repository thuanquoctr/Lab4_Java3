/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LAB4;

import javax.swing.UIManager;

/**
 *
 * @author DELL
 */
public class TestBai1 {

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            BAI1 b1 = new BAI1();
            b1.setVisible(true);
        } catch (Exception e) {
        }
    }
}
