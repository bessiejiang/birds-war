package TankGame.GameObject.Unmovable;

import TankGame.PlayerManager;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Observable;

public class PowerUp extends Unmovable{

    boolean picked = false;
    PlayerManager playerManager;

    public PowerUp(BufferedImage img, int x, int y, PlayerManager playerManager, Observable gameObs) {
        super(img, x, y);
        gameObs.addObserver(this);
        this.playerManager = playerManager;
    }

    public void draw(Graphics2D g){
        if(!picked) {
            g.drawImage(this.img, this.x, this.y,null);
        }
    }
}
