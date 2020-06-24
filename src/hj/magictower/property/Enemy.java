package hj.magictower.property;

import hj.magictower.ui.PlayFrame;

public class Enemy extends Monester{
    public int hp;
    public int atk;
    public int def;
    public int gold;
    public int exp;

    public Enemy(int i){
        this.id=i;
        hp=(int) PlayFrame.enemyDict[i][1];
        atk=(int) PlayFrame.enemyDict[i][2];
        def=(int) PlayFrame.enemyDict[i][3];
        gold=(int) PlayFrame.enemyDict[i][4];
        exp=(int)PlayFrame.enemyDict[i][5];
    }
}
