package hj.magictower.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class StartFrame extends JFrame{
    private static final int Win_Width=720+3*48;
    private static final int Win_Height=480+2*70;
    public static JLabel mota =new JLabel();
    public static JButton startMota=new JButton();
    public StartFrame()throws IOException{
        this.setSize(Win_Width,Win_Height);
        this.setTitle("TTS");
        this.setResizable(false);
        this.setLayout(null);
        this.getContentPane().setBackground(Color.BLACK);
        this.getContentPane().setVisible(true);//如果改为true那么就变成了红色。
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width -Win_Width) / 2,
                (Toolkit.getDefaultToolkit().getScreenSize().height - Win_Height) / 2);
        mota.setLayout(null);
        mota.setBounds(150,50,600,300);
        mota.setText("魔塔 TTS V333");
        mota.setFont(new Font("Serif",0,60));
        mota.setForeground(Color.WHITE);
        this.add(mota);
        startMota.setText("开始游戏");
        startMota.setBorderPainted(false);
        startMota.setFocusPainted(false);
        startMota.setFont(new Font("Serif",0,30));
        startMota.setBackground(null);
        startMota.setBorder(null);
        startMota.setBounds(250,350,170,60);
        startMota.setForeground(Color.WHITE);
        this.add(startMota);
        this.setVisible(true);
    }

}
