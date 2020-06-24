package hj.magictower.logic;

import hj.magictower.ui.PlayFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GoldFinger extends JFrame {
    boolean[] a = new boolean[12];
    public boolean xswl = false;
    public JButton enterButton = new JButton();
    public static JTextField serect = new JTextField();

    public GoldFinger() {
        this.setSize(500, 200);
        this.setLayout(null);
        this.setTitle("这是一个有秘密的窗口");
        this.setResizable(false);
        this.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width - 200) / 2,
                (Toolkit.getDefaultToolkit().getScreenSize().height - 100) / 2);
        this.setVisible(false);
        JLabel temp = new JLabel();
        temp.setLayout(null);
        String text = "作者937934696@qq.com";
        temp.setText(text);
        temp.setFont(new Font("Serif", 0, 12));
        temp.setBounds(10, -20, 200, 100);
        this.add(temp);
        JLabel temp1 = new JLabel();
        temp.setLayout(null);
        String text1 = "最近觉得魂斗罗挺好玩的";
        temp1.setText(text1);
        temp1.setFont(new Font("Serif", 0, 12));
        temp1.setBounds(10, 0, 200, 100);
        this.add(temp1);
        serect.setLayout(null);
        serect.setBounds(10, 100, 200, 20);
        serect.setVisible(false);
        enterButton.setText("金手指输入处");
        enterButton.setLayout(null);
        enterButton.setBounds(300, 100, 150, 20);
        this.addKeyListener(new KeyListener() {
            int b = 0;

            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case 38:
                        System.out.println(b);
                        if (b == 0 || b == 1) {
                            b++;
                            a[b] = true;
                        } else {
                            for (int x = 0; x <= b; x++) {
                                a[x] = false;
                            }
                            b = 0;
                        }
                        break;
                    case 40:
                        System.out.println(b);
                        if (b == 2 || b == 3) {
                            b++;
                            a[b] = true;
                        } else {
                            for (int x = 0; x <= b; x++) {
                                a[x] = false;
                            }
                            b = 0;
                        }
                        break;
                    case 37:
                        System.out.println(b);
                        if (b == 4 || b == 6) {
                            b++;
                            a[b] = true;
                        } else {
                            for (int x = 0; x <= b; x++) {
                                a[x] = false;
                            }
                            b = 0;
                        }
                        break;
                    case 39:
                        System.out.println(b);
                        if (b == 5 || b == 7) {
                            b++;
                            a[b] = true;
                        } else {
                            for (int x = 0; x <= b; x++) {
                                a[x] = false;
                            }
                            b = 0;
                        }
                        break;
                    case 66:
                        System.out.println(b);
                        if (b == 8 || b == 10) {
                            b++;
                            a[b] = true;
                        } else {
                            for (int x = 0; x <= b; x++) {
                                a[x] = false;
                            }
                            b = 0;
                        }
                        break;
                    case 65:
                        System.out.println(b);
                        if (b == 9 || b == 11) {
                            if (b != 11) {
                                b++;
                            }
                            a[b] = true;
                        } else {
                            for (int x = 0; x <= b; x++) {
                                a[x] = false;
                            }
                            b = 0;
                        }
                        if (a[11] == true) {
                            add1();
                            System.out.println(e.VK_ENTER);
                            xswl = true;
                        }
                        break;
                    default:
                        for (int x = 0; x <= b; x++) {
                            a[x] = false;
                            b = 0;
                            break;
                        }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        this.add(enterButton);
        this.add(serect);
        if(xswl)
        {
            enterButton.setVisible(true);
            serect.setVisible(true);
        }
        else{
            enterButton.setVisible(false);
            serect.setVisible(false);
        }
    }

    public void add1() {
        serect.setVisible(true);
        enterButton.setVisible(true);
    }

}
