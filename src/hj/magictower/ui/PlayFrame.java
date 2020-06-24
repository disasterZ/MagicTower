package hj.magictower.ui;

import hj.magictower.property.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;

public class PlayFrame extends JPanel{
    static JPanel game;
    public static JFrame Frame= new JFrame("TTS");
    public static Player maker = new Player();
    static BufferedImage background;
    static public BufferedImage landImg;
    static public BufferedImage enemyImg;
    static public BufferedImage itemImg;
    static public BufferedImage dialogueImg;
    static public BufferedImage playerImg;
    public static int maxFloor=0;
    public static boolean inConversation=false,fly=false,forecast=false,shop=false,keyShop=false,expShop=false,sheep=false;
    public static int nowFloor=0;
    static BufferedReader mapData;
    static BufferedReader enemy;
    public static JLayeredPane battleFrame=new JLayeredPane(),msgPane=new JLayeredPane(),forecastFrame=new JLayeredPane(),flyFrame=new JLayeredPane();
    public static JLabel msg=new JLabel();
    public static Object[][] enemyDict = new Object[30][6];
    public static Monester[][][] monMap=new Monester[10][10][10];
    public static int[][][] Map=new int[][][]{

            {
                    {3,1,1,1,1,1,1,1,1,1},
                    {0,0,0,0,0,0,0,0,0,1},
                    {1,1,1,1,5,5,5,5,5,1},
                    {1,1,1,1,5,5,5,5,5,1},
                    {7,0,0,1,5,5,5,5,5,1},
                    {1,1,0,1,5,5,5,5,5,1},
                    {1,1,0,1,5,5,5,5,5,1},
                    {9,0,0,1,1,1,1,1,1,1},
                    {1,1,0,0,7,0,0,0,8,0},
                    {1,1,0,1,1,1,0,1,1,1},
            },
            {
                    {1,0,1,0,5,5,5,0,1,3},
                    {1,0,1,0,5,5,5,0,1,1},
                    {1,6,1,0,5,5,5,0,1,1},
                    {1,0,1,0,5,5,5,0,1,1},
                    {0,0,1,0,0,0,0,0,8,0},
                    {1,1,1,1,1,1,1,1,1,1},
                    {0,0,0,0,0,0,0,0,7,0},
                    {0,1,1,1,1,1,1,1,1,0},
                    {0,1,0,7,0,0,0,0,0,0},
                    {0,1,0,1,1,1,1,1,2,0},
            },
            {
                    {3,1,1,1,0,1,0,1,1,1},
                    {0,0,0,1,1,1,0,0,0,8},
                    {1,1,0,1,0,1,1,1,1,1},
                    {0,8,0,1,0,1,0,0,0,1},
                    {1,1,1,1,1,1,1,1,1,1},
                    {0,7,0,1,0,1,0,0,0,1},
                    {0,1,0,1,0,1,0,0,0,1},
                    {1,1,0,1,1,1,1,1,0,1},
                    {1,1,0,4,4,4,4,4,0,1},
                    {1,1,0,4,4,4,4,4,0,2},
            },
            {
                    {1,1,0,1,3,1,0,0,0,0},
                    {1,1,0,1,1,1,0,1,1,1},
                    {1,1,0,0,8,0,0,1,0,1},
                    {9,0,0,1,1,1,0,1,0,1},
                    {1,1,0,0,0,1,0,1,0,1},
                    {0,1,1,1,1,1,0,1,0,1},
                    {0,0,0,0,0,1,1,1,0,1},
                    {1,1,1,1,0,0,7,0,0,1},
                    {0,0,0,1,0,1,1,1,0,1},
                    {2,1,1,1,8,1,1,1,0,1},
            },
            {
                    {1,1,0,1,1,1,0,1,1,2},
                    {1,1,0,1,1,1,0,1,1,1},
                    {1,1,0,1,1,1,0,1,1,1},
                    {6,0,0,0,6,0,0,0,6,0},
                    {1,1,1,1,1,1,1,1,1,1},
                    {1,5,5,5,5,5,5,5,5,5},
                    {1,1,1,1,1,1,1,1,1,1},
                    {0,0,9,0,0,0,9,0,0,9},
                    {0,1,1,1,0,1,1,1,0,1},
                    {0,1,1,1,0,1,1,1,0,3},
            },
            {
                    {4,4,4,4,4,4,4,4,4,4},
                    {4,1,1,7,1,0,1,1,1,4},
                    {4,1,1,0,1,0,1,1,1,4},
                    {4,1,0,0,1,0,0,0,8,4},
                    {4,1,1,0,1,1,1,1,1,4},
                    {4,1,1,0,1,0,0,0,0,4},
                    {4,9,0,0,1,1,1,1,1,1},
                    {4,1,1,0,0,8,0,0,0,1},
                    {4,3,1,0,1,1,1,0,2,1},
                    {4,4,4,4,4,4,4,4,4,4},
            },
            {
                    {1,1,1,1,1,1,1,1,1,3},
                    {1,0,0,0,0,0,0,0,0,0},
                    {1,8,1,0,1,0,1,0,1,0},
                    {1,0,1,0,1,0,1,0,1,0},
                    {1,0,1,0,1,0,1,0,1,0},
                    {1,0,0,0,1,0,1,0,1,0},
                    {1,1,1,8,1,1,1,1,1,0},
                    {1,4,4,4,4,4,1,1,1,0},
                    {1,4,4,4,4,4,1,1,1,0},
                    {1,4,4,4,4,4,2,1,1,0},
            },
            {
                    {3,1,1,1,1,1,1,1,1,1},
                    {0,0,8,0,0,0,0,0,8,0},
                    {1,1,1,1,1,0,1,1,1,1},
                    {0,1,0,0,1,0,1,0,0,1},
                    {0,1,0,0,1,0,0,0,0,1},
                    {0,1,0,0,1,8,1,1,1,1},
                    {0,1,0,0,1,0,0,0,0,0},
                    {0,9,0,0,1,1,1,1,1,1},
                    {1,1,1,0,0,1,0,0,0,8},
                    {2,1,1,0,1,1,1,0,1,1},
            },
            {
                    {1,1,1,0,2,1,1,0,1,1},
                    {1,1,1,0,1,1,1,0,1,1},
                    {1,1,1,0,1,1,1,0,1,1},
                    {6,0,0,0,0,8,0,0,0,7},
                    {1,1,1,1,1,1,1,1,1,1},
                    {1,0,0,0,0,0,0,0,0,0},
                    {1,1,1,1,1,1,1,1,1,1},
                    {1,0,0,8,0,0,0,8,0,0},
                    {1,0,1,1,1,0,1,1,1,0},
                    {3,0,1,1,1,0,1,1,1,0},
            },
            {
                    {2,1,9,1,1,1,7,1,1,1},
                    {1,1,0,1,1,1,0,1,1,1},
                    {1,1,0,1,1,1,0,1,1,1},
                    {4,4,4,4,4,4,4,4,4,8},
                    {1,1,1,1,1,1,1,1,1,1},
                    {1,5,5,5,5,5,5,5,5,5},
                    {1,1,1,1,1,1,1,1,1,1},
                    {4,4,4,4,4,4,4,4,4,7},
                    {4,4,4,4,4,4,4,4,4,1},
                    {4,4,4,4,4,4,4,4,4,1},
            }
    };
    public static int[][] startPos=new int[][]{
            {4,9},{7,9},{9,8},{1,9},{8,0},{9,8},{7,9},{1,9},{5,0},{1,0}
    };
    public static int[][] finPos=new int[][]{
            {1,0},{9,1},{1,0},{3,0},{9,8},{2,8},{8,0},{1,0},{0,8}
    };
    public PlayFrame() throws IOException
    {
        this.setLayout(null);
        //图鉴界面
        forecastFrame.setLayout(null);
        forecastFrame.setBounds(7*48,48,48*10,48*10);
        forecastFrame.setBackground(Color.BLACK);
        forecastFrame.setOpaque(true);
        forecastFrame.setVisible(false);
        //跳层界面
        flyFrame.setLayout(null);
        flyFrame.setBounds(8*48,2*48,8*48,8*48);
        flyFrame.setBorder(BorderFactory.createLineBorder(new Color(204,102,8),8,true));
        flyFrame.setBackground(Color.BLACK);
        flyFrame.setOpaque(true);
        flyFrame.setVisible(false);
        //战斗界面
        battleFrame.setLayout(null);
        battleFrame.setBounds(347,114,452,324);
        JLabel battleLabel=new JLabel((new ImageIcon(ImageIO.read(new File(System.getProperty("user.dir")+"/image/battleFrame.png")))));
        battleLabel.setBounds(0,0,452,324);
        battleFrame.add(battleLabel,1,0);
        battleFrame.add(maker.ehp,2,0);
        battleFrame.add(maker.eatk,3,0);
        battleFrame.add(maker.edef,4,0);
        battleFrame.add(maker.php,5,0);
        battleFrame.add(maker.patk,6,0);
        battleFrame.add(maker.pdef,7,0);
        battleFrame.setOpaque(true);
        battleFrame.setVisible(false);
        //消息界面绘制
        msgPane.setLayout(null);
        msgPane.setBounds(336,230,48*10,75);
        msg.setBounds(0,0,48*10,75);
        msg.setForeground(Color.WHITE);
        msg.setFont(new Font("Serif",0,27));
        msg.setHorizontalAlignment(SwingConstants.CENTER);
        JLabel msgBackground = new JLabel(new ImageIcon(ImageIO.read(new File(System.getProperty("user.dir")+"/image/dialogueBackground.png"))));
        msgBackground.setLayout(null);
        msgBackground.setBounds(0,0,48*10,75);
        msgPane.add(msgBackground,1,0);
        msgPane.add(msg,2,0);
        msgPane.setOpaque(true);
        msgPane.setVisible(false);
        //数据导入
        //敌人参数导入
        InputStreamReader read=new InputStreamReader(new FileInputStream(System.getProperty("user.dir")+"/data/enemy.dat"),"gbk");
        enemy=new BufferedReader(read);
        for(int x=0;x<enemyDict.length;x++)
        {
            enemyDict[x][0]=enemy.readLine();
            for(int y=1;y<6;y++)
            {
                enemyDict[x][y]=Integer.parseInt(enemy.readLine());
            }
        }
        //地图
        mapData=new BufferedReader(new FileReader(System.getProperty("user.dir")+"/data/example/map.dat"));
        //敌人导入
        String line=null;
        BufferedReader enemyMap=new BufferedReader(new FileReader(System.getProperty("user.dir")+"/data/example/enemyMap.dat"));
        while ((line=enemyMap.readLine())!=null)
        {
            String[] temp=line.split(" ");
            monMap[Integer.parseInt(temp[0])][Integer.parseInt(temp[2])][Integer.parseInt(temp[3])]=new Enemy(Integer.parseInt(temp[1]));
        }
        enemyMap.close();
        //人物导入
        BufferedReader dialogueMap=new BufferedReader(new FileReader(System.getProperty("user.dir")+"/data/example/dialogueMap.dat"));
        while ((line=dialogueMap.readLine())!=null)
        {
            String[] temp=line.split(" ");
            monMap[Integer.parseInt(temp[0])][Integer.parseInt(temp[2])][Integer.parseInt(temp[3])]=new Dialogue(Integer.parseInt(temp[1]));
        }
        //道具导入
        BufferedReader itemMap=new BufferedReader(new FileReader(System.getProperty("user.dir")+"/data/example/itemMap.dat"));
        while ((line=itemMap.readLine())!=null)
        {
            String[] temp=line.split(" ");
            monMap[Integer.parseInt(temp[0])][Integer.parseInt(temp[2])][Integer.parseInt(temp[3])]=new Item(Integer.parseInt(temp[1]));
        }

        //图片导入
        background=ImageIO.read(new File(System.getProperty("user.dir")+"/image/background_play.png"));
        landImg=ImageIO.read(new File(System.getProperty("user.dir")+"/image/property.png"));
        enemyImg=ImageIO.read(new File(System.getProperty("user.dir")+"/image/enemyProperty.png"));
        itemImg=ImageIO.read(new File(System.getProperty("user.dir")+"/image/itemProperty.png"));
        dialogueImg=ImageIO.read(new File(System.getProperty("user.dir")+"/image/dialogueProperty.png"));
        playerImg=ImageIO.read(new File(System.getProperty("user.dir")+"/image/player1.png"));
        //动画切换
        new Timer(500, new ActionListener(){
            boolean change=true;
            BufferedImage land1= ImageIO.read(new File(System.getProperty("user.dir")+"/image/property.png"));
            BufferedImage land2= ImageIO.read(new File(System.getProperty("user.dir")+"/image/property2.png"));
            BufferedImage enemy1=ImageIO.read(new File(System.getProperty("user.dir")+"/image/enemyProperty.png"));
            BufferedImage enemy2=ImageIO.read(new File(System.getProperty("user.dir")+"/image/enemyProperty2.png"));
            BufferedImage dialogue1=ImageIO.read(new File(System.getProperty("user.dir")+"/image/dialogueProperty.png"));
            BufferedImage dialogue2=ImageIO.read(new File(System.getProperty("user.dir")+"/image/dialogueProperty2.png"));
            @Override
            public void actionPerformed(ActionEvent e){
                if(change)
                {
                    change=false;
                    landImg=land1;
                    enemyImg=enemy1;
                    dialogueImg=dialogue1;
                }
                else
                {
                    change=true;
                    landImg=land2;
                    enemyImg=enemy2;
                    dialogueImg=dialogue2;
                }
                repaint();
            }
        }).start();
        //动态绘制

    }


    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        //背景绘制
        g2.drawImage(background, 0,0,null);
        //地图绘制
        for (int x=0;x<10;x++)
            for(int y=0;y<10;y++)
            {g2.drawImage(landImg.getSubimage(48*Map[nowFloor][x][y],0,48,48),48*y+48*7,48*x+48,null);}

        //人物、物品绘制
        try{
            g2.drawImage(maker.drawPlayer(),(maker.x+7)*48,(maker.y+1)*48,null);
            for(int x=0;x<monMap[nowFloor].length;x++)
            {
                for(int y=0;y<monMap[nowFloor].length;y++)
                {
                    if(monMap[nowFloor][x][y]!=null)
                        g2.drawImage(monMap[nowFloor][x][y].monDraw(),(x+7)*48,(y+1)*48,null);
                }
            }

        }catch(IOException e){};

        //文本绘制
        g2.setColor(Color.WHITE);
        g2.setFont(new Font("Arial",0,32));
        g2.drawString(maker.lv+"",210,100);
        g2.setFont(new Font("Arial",0,18));
        g2.drawString(maker.hp+"",150,150);
        g2.drawString(maker.atk+"",150,180);
        g2.drawString(maker.def+"",150,210);
        g2.drawString(maker.gold+"",150,270);
        g2.drawString(maker.exp+"",150,240);
        g2.setFont(new Font("Arial",0,24));
        g2.drawString(maker.Ykey+"",140,350);
        g2.drawString(maker.Bkey+"",140,420);
        g2.drawString(maker.Rkey+"",240,420);
        g2.drawString(maker.Gkey+"",240,350);
        g2.drawString(nowFloor+1+"",150,512);

    }

    //信息出现
    public static void displayMessage(String message)
    {
        msgPane.setVisible(true);
        inConversation=true;
        Timer animate = new Timer(500, new ActionListener() {
            int count=0;
            @Override
            public void actionPerformed(ActionEvent e) {
                count++;
                if(count==2)
                {
                    msgPane.setVisible(false);
                    inConversation=false;
                    ((Timer)e.getSource()).stop();
                }
                msg.setText(message);
                Frame.repaint();

            }
        });
        animate.setInitialDelay(0);
        animate.start();
    }

    public static void dispalyForcast()
    {
        inConversation=true;
        forecastFrame.setVisible(true);
        int var1=0;
        ArrayList<Integer> idList=new ArrayList<Integer>();
        for(int x=0;x<monMap[nowFloor].length;x++)
            for(int y=0;y<monMap[nowFloor].length;y++)
            {
                if(monMap[nowFloor][x][y] instanceof Enemy && !idList.contains(monMap[nowFloor][x][y].id))
                {
                    idList.add(monMap[nowFloor][x][y].id);
                    JLabel temp=new JLabel(("名字: "+(enemyDict[monMap[nowFloor][x][y].id][0]).toString()+"HP: "+((Enemy)monMap[nowFloor][x][y]).hp+"ATK: "+((Enemy)monMap[nowFloor][x][y]).atk+"DEF: "+((Enemy)monMap[nowFloor][x][y]).def+"GOLD: "+((Enemy)monMap[nowFloor][x][y]).gold+"EXP: "+((Enemy)monMap[nowFloor][x][y]).exp+"LOST: "+maker.forecast((Enemy)monMap[nowFloor][x][y]))+"HP");
                    temp.setBounds(80,20+60*var1,10*48,24);
                    temp.setForeground(Color.WHITE);
                    temp.setFont(new Font("Serif",0,12));
                    JLabel head=new JLabel();
                    try {
                        head.setIcon(new ImageIcon(monMap[nowFloor][x][y].monDraw()));
                    }catch (IOException e){};
                    head.setBounds(10,20+60*var1,48,48);
                    var1++;
                    forecastFrame.add(temp);
                    forecastFrame.add(head);
                }
            }
    }
    static JLabel[] choices =new JLabel[25];
    public static void displayFly()
    {
        inConversation=true;
        for(int x=0;x<Math.min(3,maxFloor);x++)
        {
            JLabel temp =new JLabel("  "+"第 "+(x+1)+" 层");
            temp.setFont(new Font("Serif",0,15));
            temp.setForeground(Color.WHITE);
            temp.setBounds(60,50+30*(x),200,50);
            flyFrame.add(temp);
            choices[x]=temp;
        }
        if(maxFloor>8)
            for(int x=8;x<Math.min(16,maxFloor);x++)
            {
                JLabel temp =new JLabel("  "+"第 "+(x+1)+" 层");
                temp.setFont(new Font("Serif",0,15));
                temp.setForeground(Color.WHITE);
                temp.setBounds(180,50+30*(x-3),200,50);
                flyFrame.add(temp);
                choices[x]=temp;
            }
        if(maxFloor>16)
            for(int x=16;x<Math.min(25,maxFloor);x++)
            {
                JLabel temp =new JLabel("  "+"第 "+(x+1)+" 层");
                temp.setFont(new Font("Serif",0,15));
                temp.setForeground(Color.WHITE);
                temp.setBounds(300,50+30*(x-6),200,50);
                flyFrame.add(temp);
                choices[x]=temp;
            }

        flyFrame.setVisible(true);

        Frame.addKeyListener(new KeyListener() {
            int select=0;
            @Override
            public void keyTyped(KeyEvent e) {}
            @Override
            public void keyPressed(KeyEvent e) {
                if(select!=25 &&e.getKeyCode()==e.VK_S&&choices[select+1]!=null)
                {
                    choices[select].setText(choices[select].getText().replaceAll("飞行","  "));
                    select=select+1;
                    choices[select].setText(choices[select].getText().replaceAll("  ","飞行"));
                    Frame.repaint();
                }
                if(select!=0 &&e.getKeyCode()==e.VK_W)
                {
                    choices[select].setText(choices[select].getText().replaceAll("飞行","  "));
                    select=select-1;
                    choices[select].setText(choices[select].getText().replaceAll("  ","飞行"));
                    Frame.repaint();
                }
                if(e.getKeyCode()==e.VK_SPACE)
                {
                    choices[select].setText(choices[select].getText().replaceAll("飞行","  "));
                    maker.move(startPos[select][0],startPos[select][1]);
                    nowFloor=select;
                    Frame.repaint();
                    inConversation=false;
                    flyFrame.removeAll();
                    flyFrame.setVisible(false);
                    Frame.removeKeyListener(this);

                }
            }

            @Override
            public void keyReleased(KeyEvent e) {}
        });
    }
    public static void breaker(int x,int y){
        if(Map[nowFloor][y][x]==0) {
            Map[nowFloor][y][x] = 1;
            maker.wallBreaker--;
        }
        else return;
    }
    static String[] choice=new String[4];
    public static void shop()
    {
        choice=new String[]{"  获得1000(30GOLD)","  5ATK(30GOLD)","  5DEF(30GOLD)","  EXIT"};
        inConversation=true;
        JLabel temp =new JLabel("请选择(1为hp，2为atk，3为def，4为退出):");
        temp.setFont(new Font("Serif",0,15));
        temp.setForeground(Color.WHITE);
        temp.setBounds(60,50,300,50);

        flyFrame.add(temp);
        flyFrame.setVisible(true);
        for(int i=0;i<4;i++)
        {
            JLabel templ =new JLabel(""+choice[i]);
            templ.setFont(new Font("Serif",0,20));
            templ.setForeground(Color.WHITE);
            templ.setBounds(100,100+50*i,200,50);
            flyFrame.add(templ);
        }
        Frame.addKeyListener(new KeyListener() {
            int var=0;
            @Override
            public void keyTyped(KeyEvent e) {}
            @Override
            public void keyPressed(KeyEvent e) {

                switch (e.getKeyCode())
                {
                    case 49:if(maker.gold>=30){maker.gold-=30;maker.hp+=1000;}break;
                    case 50:if(maker.gold>=30){maker.gold-=30;maker.atk+=5;}break;
                    case 51:if (maker.gold>=30){maker.gold-=30;maker.def+=5;}break;
                    case 52:break;
                }
                Frame.repaint();
                inConversation=false;
                flyFrame.removeAll();
                flyFrame.setVisible(false);
                Frame.removeKeyListener(this);
            }
            @Override
            public void keyReleased(KeyEvent e) {}
        });
    }
    public static void keyShop()
    {
        choice=new String[]{"  黄钥匙(10GOLD)","  蓝钥匙(30GOLD)","  红钥匙(100GOLD)","  EXIT"};
        inConversation=true;
        JLabel temp =new JLabel("请选择(1为黄钥匙，2为蓝钥匙，3为红钥匙，4为退出):");
        temp.setFont(new Font("Serif",0,15));
        temp.setForeground(Color.WHITE);
        temp.setBounds(10,50,370,50);

        flyFrame.add(temp);
        flyFrame.setVisible(true);
        for(int i=0;i<4;i++)
        {
            JLabel templ =new JLabel(""+choice[i]);
            templ.setFont(new Font("Serif",0,20));
            templ.setForeground(Color.WHITE);
            templ.setBounds(100,100+50*i,200,50);
            flyFrame.add(templ);
        }
        Frame.addKeyListener(new KeyListener() {
            int var=0;
            @Override
            public void keyTyped(KeyEvent e) {}
            @Override
            public void keyPressed(KeyEvent e) {

                switch (e.getKeyCode())
                {
                    case 49:if(maker.gold>=10){maker.gold-=10;maker.Ykey++;}break;
                    case 50:if(maker.gold>=30){maker.gold-=30;maker.Bkey++;}break;
                    case 51:if (maker.gold>=100){maker.gold-=100;maker.Rkey++;}break;
                    case 52:break;
                }
                Frame.repaint();
                inConversation=false;
                flyFrame.removeAll();
                flyFrame.setVisible(false);
                Frame.removeKeyListener(this);
            }
            @Override
            public void keyReleased(KeyEvent e) {}
        });
    }
    public static void expShop()
    {
        choice=new String[]{"  升1级(100EXP)","  5ATK(30EXP)","  5DEF(30EXP)","  EXIT"};
        inConversation=true;
        JLabel temp =new JLabel("请选择(1为升1级，2为+5ATK，3为+5DEF，4为退出):");
        temp.setFont(new Font("Serif",0,15));
        temp.setForeground(Color.WHITE);
        temp.setBounds(10,50,370,50);

        flyFrame.add(temp);
        flyFrame.setVisible(true);
        for(int i=0;i<4;i++)
        {
            JLabel templ =new JLabel(""+choice[i]);
            templ.setFont(new Font("Serif",0,20));
            templ.setForeground(Color.WHITE);
            templ.setBounds(100,100+50*i,200,50);
            flyFrame.add(templ);
        }
        Frame.addKeyListener(new KeyListener() {
            int var=0;
            @Override
            public void keyTyped(KeyEvent e) {}
            @Override
            public void keyPressed(KeyEvent e) {

                switch (e.getKeyCode())
                {
                    case 49:if(maker.exp>=100){maker.exp-=100;PlayFrame.maker.hp+=1000;PlayFrame.maker.atk+=7;PlayFrame.maker.def+=7;PlayFrame.maker.lv+=1;}break;
                    case 50:if(maker.exp>=30){maker.exp-=30;maker.atk+=5;}break;
                    case 51:if (maker.exp>=30){maker.exp-=30;maker.def+=5;}break;
                    case 52:break;
                }
                Frame.repaint();
                inConversation=false;
                flyFrame.removeAll();
                flyFrame.setVisible(false);
                Frame.removeKeyListener(this);
            }
            @Override
            public void keyReleased(KeyEvent e) {}
        });
    }
}
