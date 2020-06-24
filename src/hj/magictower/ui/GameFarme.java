package hj.magictower.ui;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;

import hj.magictower.logic.Action;
import hj.magictower.logic.GoldFinger;

public class GameFarme extends PlayFrame {
    private static final int Win_Width=720+3*48;
    private static final int Win_Height=480+2*70;
    private GameFarme() throws IOException{};
    public static void main (String[] args) throws IOException{
        StartFrame start=new StartFrame();
        PlayFrame Game=new PlayFrame();
        MainMenu mainMenu=new MainMenu();
        start.setJMenuBar(mainMenu);
        start.setVisible(true);
        start.startMota.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                start.setVisible(false);

        Frame.setContentPane(Game);
        Frame.setSize(Win_Width,Win_Height);
        Frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Frame.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width -Win_Width) / 2,
                (Toolkit.getDefaultToolkit().getScreenSize().height - Win_Height) / 2);
        Frame.setResizable(false);
        Game.add(PlayFrame.battleFrame);
        Game.add(PlayFrame.msgPane);
        Game.add(PlayFrame.forecastFrame);
        Game.add(PlayFrame.flyFrame);
        Frame.setJMenuBar(mainMenu);
        Frame.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}
            @Override
            public void keyPressed(KeyEvent e){
                if(!inConversation)
                {
                    switch (e.getKeyCode())
                    {
                        case 40: //下
                            if(Game.maker.y+1>=0 &&Game.maker.y+1<10)
                            {
                                Game.maker.drct=3;
                                Action.interaction(Game.maker.x+0,Game.maker.y+1);
                                Frame.repaint();
                            }
                            break;
                        case 39: //右
                            if(Game.maker.x+1>=0 &&Game.maker.x+1<10)
                            {
                                Game.maker.drct=2;
                                Action.interaction(Game.maker.x+1,Game.maker.y-0);
                                Frame.repaint();
                            }
                            break;
                        case 38: //上
                            if(Game.maker.y-1>=0 &&Game.maker.y-1<10)
                            {
                                Game.maker.drct=1;
                                Action.interaction(Game.maker.x+0,Game.maker.y-1);
                                Frame.repaint();
                            }
                            break;
                        case 37: //左
                            if(Game.maker.x-1>=0 &&Game.maker.x-1<10)
                            {
                                Game.maker.drct=0;
                                Action.interaction(Game.maker.x-1,Game.maker.y+0);
                                Frame.repaint();
                            }
                            break;
                        case 76:
                            if(forecast)
                            {
                                dispalyForcast();

                            }break;
                        case 74:
                            if(fly)
                            {
                                displayFly();
                            }
                            break;
                        case 81:
                            if(shop)
                            {
                                shop();
                            }

                            break;
                        case 75:
                            if(keyShop)
                            {
                                keyShop();
                            }
                            break;
                        case 69:
                            if(expShop)
                            {
                                expShop();
                            }
                            break;
                        case 89:
                            if(maker.wallBreaker>0){
                                if(maker.drct==0) breaker(maker.x-1,maker.y);
                                if(maker.drct==1) breaker(maker.x,maker.y-1);
                                if(maker.drct==2) breaker(maker.x+1,maker.y);
                                if(maker.drct==3) breaker(maker.x,maker.y+1);}
                            break;
                    }}
                else if (e.getKeyCode()==e.VK_L)
                {
                    inConversation=false;
                    forecastFrame.removeAll();
                    forecastFrame.setVisible(false);
                }
                else if (e.getKeyCode()==e.VK_J)
                {
                    inConversation=false;
                    flyFrame.removeAll();
                    flyFrame.setVisible(false);
                }
                else if (e.getKeyCode()==e.VK_Q)
                {
                    inConversation=false;
                    flyFrame.removeAll();
                    flyFrame.setVisible(false);
                }
                else if (e.getKeyCode()==e.VK_E)
                {
                    inConversation=false;
                    flyFrame.removeAll();
                    flyFrame.setVisible(false);
                }
                else if (e.getKeyCode()==e.VK_K)
                {
                    inConversation=false;
                    flyFrame.removeAll();
                    flyFrame.setVisible(false);
                }

                else return;
            }

            @Override
            public void keyReleased(KeyEvent e) {}});
            Frame.setVisible(true);
            }
        });

    }


}
