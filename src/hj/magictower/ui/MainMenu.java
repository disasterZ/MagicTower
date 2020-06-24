package hj.magictower.ui;

import hj.magictower.logic.GoldFinger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MainMenu extends JMenuBar{
    public static boolean win=false;
    public MainMenu(){

        JMenu
                gameMenu = new JMenu("游戏");

        JMenuItem
                pauseMenuItem =new JMenuItem("暂停"),
                resumeMenuItem = new JMenuItem("恢复"),
                gameInfo = new JMenuItem("关于");
        gameMenu.add(pauseMenuItem);
        gameMenu.add(resumeMenuItem);
        gameMenu.add(gameInfo);

        pauseMenuItem.addActionListener(event->pauseGame());
        resumeMenuItem.addActionListener(event->resumeGame());
        gameInfo.addActionListener(event->about());

        this.add(gameMenu);


    }
    GoldFinger gold=new GoldFinger();
    static JLabel pause=new JLabel();
    public static void pauseGame()
    {
        PlayFrame.inConversation=true;
        pause.setText("暂停游戏");
        pause.setFont(new Font("Serif",0,40));
        pause.setForeground(Color.WHITE);
        if(win) pause.setText("你赢了！！！");
        pause.setBounds(90,150,200,50);
        PlayFrame.flyFrame.add(pause);
        PlayFrame.flyFrame.setVisible(true);

    }
    private void resumeGame()
    {
        GameFarme.displayMessage("恢复游戏");
        PlayFrame.flyFrame.setVisible(false);
        GameFarme.inConversation=false;
    }
    private void about()
    {
        gold.setVisible(true);
        gold.enterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(gold.serect.getText());
                String a=gold.serect.getText();
                if(("博然大佬救救我").equals(a))
                {
                    System.out.println("power");
                    PlayFrame.maker.hp=99999;
                    PlayFrame.maker.atk=9999;
                    PlayFrame.maker.def=9999;
                    PlayFrame.maker.gold=9999;
                    PlayFrame.maker.exp=9999;
                    PlayFrame.maker.Ykey=50;
                    PlayFrame.maker.Gkey=50;
                    PlayFrame.maker.Bkey=50;
                    PlayFrame.maker.Rkey=50;
                    gold.xswl=true;
                    gold.setVisible(false);
                    gold.serect.setText("");
                }
                else if(("black sheep wall").equals(a)) {PlayFrame.sheep=true;
                    System.out.println("no wall");gold.xswl=true;gold.setVisible(false);gold.serect.setText("");}
                else if(("open all").equals(a)){
                    System.out.println("open");
                    PlayFrame.fly=true;
                    PlayFrame.forecast=true;
                    PlayFrame.shop=true;
                    PlayFrame.expShop=true;
                    PlayFrame.keyShop=true;
                    gold.setVisible(false);
                    gold.xswl=true;
                    gold.serect.setText("");
                }
                else {gold.xswl=true;gold.setVisible(false);gold.serect.setText("");}
            }
        });
    }

}
