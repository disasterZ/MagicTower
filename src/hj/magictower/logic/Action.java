package hj.magictower.logic;

import hj.magictower.property.Dialogue;
import hj.magictower.property.Enemy;
import hj.magictower.property.Item;
import hj.magictower.property.Player;
import hj.magictower.ui.PlayFrame;

import java.io.IOException;

public class Action extends PlayFrame{
    public static void interaction (int x,int y)
    {
        if(monMap[nowFloor][x][y] instanceof Enemy && (maker.forecast((Enemy)monMap[nowFloor][x][y]).equals("???")||Integer.parseInt(maker.forecast((Enemy)monMap[nowFloor][x][y]))>=maker.hp))
            return;
        else if (monMap[nowFloor][x][y] instanceof Enemy)
        {
            if (maker.muteki>0)
            {
                maker.muteki--;
                PlayFrame.monMap[nowFloor][x][y]=null;
            }
            maker.battle((Enemy)monMap[nowFloor][x][y]);
            System.out.println((enemyDict[monMap[nowFloor][x][y].id][0].toString()));
            PlayFrame.monMap[nowFloor][x][y]=null;
        }
        else if(monMap[nowFloor][x][y] instanceof Item)
        {
            ((Item)monMap[nowFloor][x][y]).use();
            monMap[nowFloor][x][y]=null;
        }
        else if(monMap[nowFloor][x][y] instanceof Dialogue)
        {
            ((Dialogue)monMap[nowFloor][x][y]).perform();
            if(((Dialogue)monMap[nowFloor][x][y]).id==3)
            {
                monMap[nowFloor][x-1][y]=null;
                monMap[nowFloor][x+1][y]=null;
            }
            monMap[nowFloor][x][y]=null;
        }
        else
        switch (Map[nowFloor][y][x])
        {
            case 1:maker.move(x,y); break;
            case 0:
                if(sheep==true) {maker.move(x,y);}
                break;
            case 2:
                nowFloor--;
                maker.move(finPos[nowFloor][0],finPos[nowFloor][1]);
                break;
            case 3:
                nowFloor++;
                PlayFrame.maxFloor=Math.max(maxFloor,nowFloor);
                maker.move(startPos[nowFloor][0],startPos[nowFloor][1]);
                break;
            case 6:
                if(maker.Gkey>0){
                    Map[nowFloor][y][x]=1;
                    maker.Gkey--;
                    maker.move(x,y);
                }
                break;
            case 7:
                if(maker.Ykey>0){
                    Map[nowFloor][y][x]=1;
                    maker.Ykey--;
                    maker.move(x,y);
                }
                break;
            case 8:
                if(maker.Bkey>0){
                    Map[nowFloor][y][x]=1;
                    maker.Bkey--;
                    maker.move(x,y);
                }
                break;
            case 9:
                if(maker.Rkey>0){
                    Map[nowFloor][y][x]=1;
                    maker.Rkey--;
                    maker.move(x,y);
                }
                break;
            case 10:
                Map[nowFloor][y][x]=1;
                maker.move(x,y);
                break;
        }
    }
    public Action() throws IOException{

    }
}
