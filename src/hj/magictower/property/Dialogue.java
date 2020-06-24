package hj.magictower.property;

import hj.magictower.ui.MainMenu;
import hj.magictower.ui.PlayFrame;

import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Dialogue extends Monester {
    public Dialogue(int index) { id=index;}
    public void perform()
    {
        switch (id)
        {
            case 0:
                PlayFrame.expShop=true;
                PlayFrame.displayMessage("解锁升级，按E打开");break;
            case 1:
                PlayFrame.keyShop=true;
                PlayFrame.displayMessage("解锁钥匙商店，按K打开");break;
            case 3:
                PlayFrame.shop();
                PlayFrame.displayMessage("解锁商店，按Q打开");
                break;
            case 5:
                MainMenu.win=true;MainMenu.pauseGame();PlayFrame.Frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);break;
        }
    }

}
