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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author DELL
 */
public class BAI2 extends JFrame implements ActionListener {

    private JPanel p1, p2, p3;
    private JLabel masp, tensp, donvitinh, donia, nhacungcap;
    private JTable tb;
    private JButton btn1, btn2, btn3;
    private JTextField txtmasp, txttensp, txtdongia, txtnhacungcap;
    private DefaultTableModel model;
    private JComboBox cbx;
    private int x = -1;

    public BAI2() {
        this.setTitle("BAI2");
        this.setSize(750, 580);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        p1 = new JPanel();
        p1.setBounds(17, 10, 700, 250);
        p1.setBorder(new TitledBorder(new LineBorder(Color.magenta, 5), "Danh Sách Sản Phẩm", TitledBorder.CENTER, TitledBorder.TOP, new Font("Serif", Font.BOLD, 20), Color.RED));
        String[] cot = {"Mã SP", "Tên SP", "DVT", "Đơn Giá", "Nhà Cung Cấp"};
        Object[][] data = {
            {"1", "thuan1", "Kg", "1000", "Long An"}};
        model = new DefaultTableModel(data, cot);
        tb = new JTable(model);
        tb.setFont(new Font("Serif", Font.BOLD, 17));
        JTableHeader header = tb.getTableHeader();
        Font font = new Font("Serif", Font.BOLD, 20);
        header.setFont(font);
        header.setForeground(Color.red);
        tb.setPreferredScrollableViewportSize(new Dimension(670, 165));
        JScrollPane scrollPane = new JScrollPane(tb);
        p1.add(scrollPane);

        p2 = new JPanel();
        p2.setBounds(17, 270, 700, 200);
        p2.setBackground(Color.PINK);
        p2.setLayout(null);

        masp = new JLabel("Mã Sản Phẩm");
        tensp = new JLabel("Tên Sản Phẩm");
        donvitinh = new JLabel("Đơn Vị Tính");
        donia = new JLabel("Đơn Giá");
        nhacungcap = new JLabel("Nhà Cung Cấp");
        masp.setBounds(30, 30, 130, 30);
        masp.setFont(new Font("Serif", Font.BOLD, 20));
        tensp.setBounds(30, 80, 130, 30);
        tensp.setFont(new Font("Serif", Font.BOLD, 20));
        donvitinh.setBounds(30, 130, 130, 30);
        donvitinh.setFont(new Font("Serif", Font.BOLD, 20));
        donia.setBounds(350, 30, 130, 30);
        donia.setFont(new Font("Serif", Font.BOLD, 20));
        nhacungcap.setBounds(350, 80, 130, 30);
        nhacungcap.setFont(new Font("Serif", Font.BOLD, 20));
        p2.add(masp);
        p2.add(tensp);
        p2.add(donvitinh);
        p2.add(donia);
        p2.add(nhacungcap);
        txtmasp = new JTextField();
        txtmasp.setFont(new Font("Serif", Font.BOLD, 20));
        txtmasp.setPreferredSize(new Dimension(170, 35));
        txtmasp.setBounds(170, 30, 170, 35);
        p2.add(txtmasp);

        txttensp = new JTextField();
        txttensp.setFont(new Font("Serif", Font.BOLD, 20));
        txttensp.setPreferredSize(new Dimension(170, 35));
        txttensp.setBounds(170, 80, 170, 35);
        p2.add(txttensp);

        String[] oj = {"Chai", "Kg", "Lít"};
        cbx = new JComboBox(oj);
        cbx.setFont(new Font("Serif", Font.BOLD, 20));
        cbx.setPreferredSize(new Dimension(170, 35));
        cbx.setBounds(170, 130, 170, 35);
        p2.add(cbx);

        txtdongia = new JTextField();
        txtdongia.setFont(new Font("Serif", Font.BOLD, 20));
        txtdongia.setPreferredSize(new Dimension(170, 35));
        txtdongia.setBounds(490, 30, 170, 35);
        p2.add(txtdongia);

        txtnhacungcap = new JTextField();
        txtnhacungcap.setFont(new Font("Serif", Font.BOLD, 20));
        txtnhacungcap.setPreferredSize(new Dimension(170, 35));
        txtnhacungcap.setBounds(490, 80, 170, 35);
        p2.add(txtnhacungcap);

        p3 = new JPanel();
        p3.setBounds(17, 480, 700, 50);
        p3.setBackground(Color.LIGHT_GRAY);
        btn1 = new JButton("Thêm Sản Phẩm");
        btn2 = new JButton("Xóa Sản Phẩm");
        btn3 = new JButton("Điều Chỉnh TT");
        btn1.setFont(new Font("Serif", Font.BOLD, 20));
        btn2.setFont(new Font("Serif", Font.BOLD, 20));
        btn3.setFont(new Font("Serif", Font.BOLD, 20));
        p3.add(btn1);
        p3.add(btn2);
        p3.add(btn3);
        btn1.addActionListener(this);
        btn2.addActionListener(this);
        btn3.addActionListener(this);
        tb.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                x = tb.getSelectedRow();
                String ma = tb.getValueAt(x, 0).toString();
                String ten = tb.getValueAt(x, 1).toString();
                String dg = tb.getValueAt(x, 3).toString();
                String ncc = tb.getValueAt(x, 4).toString();
                txtmasp.setText(ma);
                txttensp.setText(ten);
                txtdongia.setText(dg);
                txtnhacungcap.setText(ncc);
                if (tb.getValueAt(x, 2).equals("Chai")) {
                    int kk = 0;
                    cbx.setSelectedIndex(kk);
                }
                if (tb.getValueAt(x, 2).equals("Kg")) {
                    int kk = 1;
                    cbx.setSelectedIndex(kk);
                }
                if (tb.getValueAt(x, 2).equals("Lít")) {
                    int kk = 2;
                    cbx.setSelectedIndex(kk);
                }

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        

        this.add(p1);
        this.add(p2);
        this.add(p3);

    }

    public boolean checknull() {
        if (txtmasp.getText().trim().equals("")) {
            return false;
        }
        if (txttensp.getText().trim().equals("")) {
            return false;
        }
        if (txtdongia.getText().trim().equals("")) {
            return false;
        }
        if (txtnhacungcap.getText().trim().equals("")) {
            return false;
        }
        return true;
    }

    

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn1) {
            if (checknull()) {
                Object[] datanew = {txtmasp.getText(), txttensp.getText(), cbx.getSelectedItem(), txtdongia.getText(), txtnhacungcap.getText()};
                model.addRow(datanew);
            } else {
                JOptionPane.showMessageDialog(this, "Vui lòng điền đầy đủ thông tin !");
                return;
            }
        }
        if (e.getSource() == btn2) {
            if (x >= 0) {
                model.removeRow(x);
                JOptionPane.showMessageDialog(this, "Đã Xóa !");

            }
            if (x < 0) {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn dòng muốn xóa!");
            }
        }
        if (e.getSource() == btn3) {
            if (checknull()) {
                model.setValueAt(txtmasp.getText(), x, 0);
                model.setValueAt(txttensp.getText(), x, 1);
                model.setValueAt(cbx.getSelectedItem(), x, 2);
                model.setValueAt(txtdongia.getText(), x, 3);
                model.setValueAt(txtnhacungcap.getText(), x, 4);
            } else {
                JOptionPane.showMessageDialog(this, "Điền đầy đủ thông tin cần sữa !");
            }
        }

    }
}
