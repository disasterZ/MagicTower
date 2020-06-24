package hj.magictower.property;

import hj.magictower.ui.PlayFrame;

public class Item extends Monester{
    public Item(int index){id=index;}
    public void  use()
    {
        switch (id)
        {
            case 0:
                PlayFrame.maker.muteki++;PlayFrame.displayMessage("破魔道具+1,下一只怪自动击杀");break;
            case 1:
                PlayFrame.maker.atk+=3;PlayFrame.displayMessage("获得红宝石，攻击+3");break;
            case 2:
                PlayFrame.maker.def+=3;PlayFrame.displayMessage("获得蓝宝石，防御+3");break;
            case 3:
                PlayFrame.maker.atk+=3;PlayFrame.maker.def+=3;PlayFrame.displayMessage("获得黄宝石，攻击+3，防御+3");break;
            case 4:
                PlayFrame.maker.atk+=10;PlayFrame.displayMessage("获得铁剑,攻击+10");break;
            case 5:
                PlayFrame.maker.atk+=30;PlayFrame.displayMessage("获得钢剑，攻击+30");break;
            case 6:
                PlayFrame.maker.atk+=70;PlayFrame.displayMessage("获得皇家剑，攻击+70");break;
            case 7:
                PlayFrame.maker.atk+=120;PlayFrame.displayMessage("获得神圣剑，攻击+120");break;
            case 8:
                PlayFrame.maker.hp+=100;PlayFrame.displayMessage("获得小药水，生命+100");break;
            case 9:
                PlayFrame.maker.hp+=300;PlayFrame.displayMessage("获得大药水，生命+300");break;
            case 10:
                PlayFrame.maker.hp+=1000;PlayFrame.displayMessage("获得超级药水，生命+1000");break;
            case 11:
                PlayFrame.maker.def+=10;PlayFrame.displayMessage("获得铁盾，防御+10");break;
            case 12:
                PlayFrame.maker.def+=30;PlayFrame.displayMessage("获得钢盾，防御+30");break;
            case 13:
                PlayFrame.maker.def+=70;PlayFrame.displayMessage("获得皇家盾，防御+70");break;
            case 14:
                PlayFrame.maker.def+=120;PlayFrame.displayMessage("获得神圣盾，防御+120");break;
            case 15:
                PlayFrame.maker.hp+=1000;PlayFrame.maker.atk+=7;PlayFrame.maker.def+=7;PlayFrame.maker.lv+=1;PlayFrame.displayMessage("获得小飞羽，升1级");break;
            case 16:
                PlayFrame.maker.hp+=3000;PlayFrame.maker.atk+=21;PlayFrame.maker.def+=21;PlayFrame.maker.lv+=3;PlayFrame.displayMessage("获得大飞羽，升3级");break;
            case 17:
                PlayFrame.fly=true;
                PlayFrame.displayMessage("获得传送门，按J跳层");
                break;
            case 18:
                PlayFrame.maker.wallBreaker+=1;PlayFrame.displayMessage("获得破墙镐，按Y破坏1面墙");break;
            case 19:
                PlayFrame.maker.hp=PlayFrame.maker.hp*2;PlayFrame.displayMessage("获得圣水，血量翻倍");break;
            case 20:
                PlayFrame.maker.Ykey+=1;PlayFrame.displayMessage("黄钥匙+1");break;
            case 21:
                PlayFrame.maker.Bkey+=1;PlayFrame.displayMessage("蓝钥匙+1");break;
            case 22:
                PlayFrame.maker.Rkey+=1;PlayFrame.displayMessage("红钥匙+1");break;
            case 23:
                PlayFrame.maker.Gkey+=1;PlayFrame.displayMessage("绿钥匙+1");break;
            case 24:
                PlayFrame.maker.atk+=500;PlayFrame.displayMessage("获得肥宅剑，攻击+500");break;
            case 25:
                PlayFrame.maker.def+=500;PlayFrame.displayMessage("获得肥宅盾，防御+500");break;
            case 26:
                PlayFrame.maker.atk=(PlayFrame.maker.atk/3)+PlayFrame.maker.atk;
                PlayFrame.maker.def=(PlayFrame.maker.def/3)+PlayFrame.maker.def;
                PlayFrame.displayMessage("获得十字架，攻击防御大幅提升");
            case 27:
                PlayFrame.forecast=true;
                PlayFrame.displayMessage("获得怪物图鉴，按L查看");
                break;
            case 28:
                PlayFrame.maker.Ykey+=1;PlayFrame.maker.Bkey+=1;
                PlayFrame.maker.Rkey+=1;PlayFrame.maker.Gkey+=1;
                PlayFrame.displayMessage("获得钥匙套餐，各钥匙+1");break;
            case 29:
                PlayFrame.maker.gold+=300;PlayFrame.displayMessage("获得大金币，金币+300");break;

        }
    }
}
