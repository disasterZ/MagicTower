package hj.magictower.property;

import hj.magictower.ui.PlayFrame;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Player extends JPanel{
    public int drct = 1;
    public static int x=4;
    public static int y=9;
    public int lv=1;
    public int hp=1000;
    public int atk=30;
    public int def=30;
    public int gold=0;
    public int exp=0;
    public int Ykey=1;
    public int Bkey=1;
    public int Rkey=1;
    public int Gkey=0;
    public int wallBreaker=0,muteki=0;
    public BufferedImage playerImg;
    public JLabel ehp=new JLabel(),eatk=new JLabel(),edef=new JLabel(),php=new JLabel(),patk=new JLabel(),pdef=new JLabel(),eImg=new JLabel();

    public Player()
    {
        ehp.setBounds(28,128,120,20);
        ehp.setFont(new Font("Serif",0,24));
        ehp.setForeground(Color.WHITE);
        eatk.setBounds(28,208,120,20);
        eatk.setFont(new Font("Serif",0,24));
        eatk.setForeground(Color.WHITE);
        edef.setBounds(28,288,120,20);
        edef.setFont(new Font("Serif",0,24));
        edef.setForeground(Color.WHITE);
        php.setBounds(328,128,120,20);
        php.setFont(new Font("Serif",0,24));
        php.setForeground(Color.WHITE);
        patk.setBounds(328,208,120,20);
        patk.setFont(new Font("Serif",0,24));
        patk.setForeground(Color.WHITE);
        pdef.setBounds(328,288,120,20);
        pdef.setFont(new Font("Serif",0,24));
        pdef.setForeground(Color.WHITE);

    }
    public void battle(Enemy i)
    {
        try{
            eImg=new JLabel(new ImageIcon(i.monDraw()));
        }catch (IOException e){};
        eImg.setBounds(10,30,48,48);
        PlayFrame.battleFrame.add(eImg,8,0);
        ehp.setText(i.hp+"");
        eatk.setText(i.atk+"");
        edef.setText(i.def+"");
        php.setText(hp+"");
        patk.setText(atk+"");
        pdef.setText(def+"");
        PlayFrame.battleFrame.setVisible(true);
        PlayFrame.inConversation=true;
        Timer battleTime = new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                attack(i);
                ehp.setText(i.hp+"");
                php.setText(hp+"");
                repaint();
                if(hp<=0||i.hp<=0)
                {
                    PlayFrame.battleFrame.setVisible(false);
                    PlayFrame.inConversation=false;
                    exp+=i.exp;
                    gold+=i.gold;
                    PlayFrame.displayMessage(("获得 "+i.exp +"经验和 "+i.gold+" 金币"));
                    PlayFrame.battleFrame.remove(eImg);
                    ((Timer)e.getSource()).stop();
                }
            }
        });
        battleTime.start();
    }
    public String forecast(Enemy i)
    {
        if(atk<i.def) return "???";
        else if(def>=i.atk) return 0+"";
        else
        {
            return ((i.hp/(atk-i.def))*(i.atk-def))+"";
        }
    }

    public void attack(Enemy i)
    {
        if(atk>i.def)
            i.hp=i.hp-atk+i.def;
        if(i.hp<=0) return;
        if(i.atk>def)
            hp=hp-i.atk+def;
        if(atk<i.def&&i.atk<def) return;
    }

    public BufferedImage drawPlayer() throws IOException{
        new Timer(0, new ActionListener(){
            int change=3;
            BufferedImage playerImg_2= ImageIO.read(new File(System.getProperty("user.dir")+"/image/player2.png"));
            BufferedImage playerImg_3= ImageIO.read(new File(System.getProperty("user.dir")+"/image/player3.png"));
            BufferedImage playerImg_1= ImageIO.read(new File(System.getProperty("user.dir")+"/image/player1.png"));
            @Override
            public void actionPerformed(ActionEvent e) {
                if(change==1)
                {
                    change=2;
                    playerImg=playerImg_2;
                }
                else if(change==2)
                {
                    playerImg=playerImg_3;
                    change=3;
                }
                else if(change==3)
                {
                    change=1;
                    playerImg=playerImg_1;
                }
                repaint();
            }
        }).start();
        //左
        if(this.drct==0){
            return playerImg.getSubimage(2*48,0,48,48);
        }
        //上
        else if (this.drct==1){
            return playerImg.getSubimage(48,0,48,48);
        }
        //右
        else if (this.drct==2){
            return playerImg.getSubimage(3*48,0,48,48);
        }
        //下
        else {
            return playerImg.getSubimage(0,0,48,48);
        }

    }




    public void move(int mx,int my)
    {
        x=mx;y=my;
    }
}
