package hj.magictower.ui;

import javax.swing.*;
import java.awt.*;

class MakeFrame extends JFrame implements GameFunction{
    private static final int Win_Width=720+3*48;
    private static final int Win_Height=480+2*48;
    MakeFrame(){
        MainMenu mainMenu = new MainMenu();
        setJMenuBar(mainMenu);
        this.setSize(Win_Width,Win_Height);
        //居中显示
        this.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width - getWidth()) / 2,
        (Toolkit.getDefaultToolkit().getScreenSize().height - getHeight()) / 2);
        //关闭窗口时结束调试
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //命名
        this.setTitle("魔塔创造家 TTS Maker V1.0");
        //添加背景
        ImageIcon background = new ImageIcon("image/background.jpg");
        JLabel bg=new JLabel(background);
        this.add(bg);

        this.setVisible(true);
        }
    @Override
    public void pauseGame(){

        }

    @Override
    public void resumeGame(){

        }

    @Override
    public void stopGame(){

        }

    @Override
    public void returnMenu(){

        }

}