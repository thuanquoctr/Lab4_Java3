/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LAB4;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;

/**
 *
 * @author DELL
 */
public class BAI1 extends JFrame implements ActionListener {

    JButton btn1, btn2, btn3;
    JTextArea txtare;
    JTextField txtfpoly;

    public BAI1() {
        this.setTitle("BAI1");
        this.setSize(1000, 800);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setResizable(false);
        JMenuBar jMenuBar = new JMenuBar();
        JMenu jMenu_file = new JMenu("File");
        ImageIcon iconnew = new ImageIcon(new ImageIcon("D:\\new.png").getImage().getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH));
        JMenuItem jMenuItem_new = new JMenuItem("New   Ctrl+N", iconnew);
        jMenuItem_new.addActionListener(this);
        ImageIcon iconopen = new ImageIcon(new ImageIcon("D:\\open.png").getImage().getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH));
        JMenuItem jMenuItem_open = new JMenuItem("Open   Ctrl+O", iconopen);
        jMenuItem_open.addActionListener(this);
        ImageIcon iconsave = new ImageIcon(new ImageIcon("D:\\save.png").getImage().getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH));
        JMenuItem jMenuItem_save = new JMenuItem("Save   Ctrl+S", iconsave);
        jMenuItem_save.addActionListener(this);
        jMenu_file.add(jMenuItem_new);
        jMenu_file.add(jMenuItem_open);
        jMenu_file.add(jMenuItem_save);

        JMenu jMenu_color = new JMenu("Color");
        ImageIcon iconred = new ImageIcon(new ImageIcon("D:\\red.png").getImage().getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH));
        JMenuItem jMenuItem_red = new JMenuItem("Red", iconred);
        jMenuItem_red.addActionListener(this);
        ImageIcon icongreen = new ImageIcon(new ImageIcon("D:\\green.png").getImage().getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH));
        JMenuItem jMenuItem_green = new JMenuItem("Green", icongreen);
        jMenuItem_green.addActionListener(this);
        ImageIcon iconblue = new ImageIcon(new ImageIcon("D:\\blue.png").getImage().getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH));
        JMenuItem jMenuItem_blue = new JMenuItem("Blue", iconblue);
        jMenuItem_blue.addActionListener(this);
        JMenuItem jMenuItem_textcolor = new JMenuItem("Text Color");
        jMenuItem_textcolor.addActionListener(this);
        jMenu_color.add(jMenuItem_red);
        jMenu_color.add(jMenuItem_green);
        jMenu_color.add(jMenuItem_blue);
        jMenu_color.addSeparator();
        jMenu_color.add(jMenuItem_textcolor);

        JMenu jMenu_system = new JMenu("System");
        JMenuItem jMenuItem_aboutus = new JMenuItem("About us");
        jMenuItem_aboutus.addActionListener(this);
        ImageIcon iconexit = new ImageIcon(new ImageIcon("D:\\exit.png").getImage().getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH));
        JMenuItem jMenuItem_exit = new JMenuItem("Exit", iconexit);
        jMenuItem_exit.addActionListener(this);
        jMenu_system.add(jMenuItem_aboutus);
        jMenu_system.add(jMenuItem_exit);

        ImageIcon iconabout = new ImageIcon(new ImageIcon("D:\\about.png").getImage().getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH));
        JToolBar tba = new JToolBar();
        tba.addSeparator(new Dimension(0, 400));

        btn1 = new JButton(new ImageIcon("D:\\new.png"));
        btn2 = new JButton(new ImageIcon("D:\\about.png"));
        btn3 = new JButton(new ImageIcon("D:\\exit.png"));
        tba.add(btn1);
        tba.add(btn2);
        tba.add(btn3);
        tba.setBounds(5, 5, 450, 125);

        jMenuBar.add(jMenu_file);
        jMenuBar.add(jMenu_color);
        jMenuBar.add(jMenu_system);

        this.setJMenuBar(jMenuBar);

        txtare = new JTextArea("Lab4");
        txtare.setFont(new Font("Serif", Font.PLAIN, 30));
        txtare.setBounds(15, 150, 950, 420);

        txtfpoly = new JTextField("Fpoly - Java 3");
        txtfpoly.setHorizontalAlignment(JTextField.CENTER);
        txtfpoly.setFont(new Font("Serif", Font.BOLD, 30));
        txtfpoly.setBounds(15, 600, 950, 120);
        btn1.addActionListener(this);
        btn2.addActionListener(this);
        btn3.addActionListener(this);
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                int confirmed = JOptionPane.showConfirmDialog(null, "Bạn có muốn lưu thay đổi trước khi thoát không?", "Xác nhận", JOptionPane.YES_NO_CANCEL_OPTION);
                if (confirmed == JOptionPane.YES_OPTION) {
                    if (txtare.getText().equals("")) {
                        System.exit(0);
                    }
                    JFileChooser jFileChooser = new JFileChooser();
                    jFileChooser.setCurrentDirectory(new File("D:\\"));
                    int kiemtra = jFileChooser.showSaveDialog(null);
                    if (kiemtra == JFileChooser.APPROVE_OPTION) {
                        try {
                            File selectdFile = jFileChooser.getSelectedFile();
                            String docdulieunew = txtare.getText();
                            Files.write(selectdFile.toPath(), docdulieunew.getBytes());
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }

                    }
                } else if (confirmed == JOptionPane.NO_OPTION) {
                    System.exit(0);
                } else {
                    setDefaultCloseOperation(0);
                }
            }
        }
        );
        this.setLayout(null);
        this.add(tba);
        this.add(txtare);
        this.add(txtfpoly);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String click = e.getActionCommand();
        if (click.equals("New   Ctrl+N")) {
            txtare.setText("");
            txtare.requestFocus();
            return;
        }
        if (click.equals("Open   Ctrl+O")) {
            JFileChooser jFileChooser = new JFileChooser();
            jFileChooser.setCurrentDirectory(new File("D:\\"));
            int kiemtra = jFileChooser.showOpenDialog(null);
            if (kiemtra == JFileChooser.APPROVE_OPTION) {
                try {
                    File selectdFile = jFileChooser.getSelectedFile();
                    String docdulieu = new String(Files.readAllBytes(selectdFile.toPath()));
                    txtare.setText(docdulieu);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

            }
        }
        if (click.equals("Save   Ctrl+S")) {
            JFileChooser jFileChooser = new JFileChooser();
            jFileChooser.setCurrentDirectory(new File("D:\\"));
            int kiemtra = jFileChooser.showSaveDialog(null);
            if (kiemtra == JFileChooser.APPROVE_OPTION) {
                try {
                    File selectdFile = jFileChooser.getSelectedFile();
                    String docdulieunew = txtare.getText();
                    Files.write(selectdFile.toPath(), docdulieunew.getBytes());
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

            }
        }
        if (click.equals("Text Color")) {
            JColorChooser colorChooser = new JColorChooser();
            Color color = JColorChooser.showDialog(null, "Chọn màu", Color.white);
            txtfpoly.setBackground(color);
            return;
        }
        if (click.equals("Red")) {
            txtfpoly.setBackground(Color.red);
            return;
        }
        if (click.equals("Green")) {
            txtfpoly.setBackground(Color.green);
            return;
        }
        if (click.equals("Blue")) {
            txtfpoly.setBackground(Color.blue);
            return;
        }
        if (click.equals("About us")) {
            SimpleDateFormat fm = new SimpleDateFormat("dd/MM/yyyy - hh:mm:ss");
            JOptionPane.showMessageDialog(null, "Program Lab4\nAuthor: TranQuocThuan\nLastUpdate: " + fm.format(new Date()) + "\nEducation: Fpoly", "Giới Thiệu", JOptionPane.INFORMATION_MESSAGE);
        }
        if (click.equals("Exit")) {
            int lc = JOptionPane.showConfirmDialog(this, "Thoat", "Ban muon thoat", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (lc == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        }
        if (e.getSource() == btn1) {
            txtare.setText("");
            txtare.requestFocus();
            return;
        }
        if (e.getSource() == btn2) {
            SimpleDateFormat fm = new SimpleDateFormat("dd/MM/yyyy - hh:mm:ss");
            JOptionPane.showMessageDialog(null, "Program Lab4\nAuthor: TranQuocThuan\nLastUpdate: " + fm.format(new Date()) + "\nEducation: Fpoly", "Giới Thiệu", JOptionPane.INFORMATION_MESSAGE);
        }
        if (e.getSource() == btn3) {
            int lc = JOptionPane.showConfirmDialog(this, "Thoat", "Ban muon thoat", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (lc == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        }

    }

}
