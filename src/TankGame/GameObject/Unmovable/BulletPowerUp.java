package TankGame.GameObject.Unmovable;

import TankGame.GameObject.Moveable.Tank;
import TankGame.PlayerManager;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Observable;

public class BulletPowerUp extends PowerUp {

    public BulletPowerUp(BufferedImage img, int x, int y, PlayerManager playerManager, Observable gameObs) {
        super(img, x, y, playerManager, gameObs);
        gameObs.addObserver(this);
    }

    public void draw(Graphics2D g){
        if(!picked) {
            g.drawImage(this.img, this.x, this.y,null);
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        Tank p1 = playerManager.getPlayer1();
        Tank p2 = playerManager.getPlayer2();

        handleCollisionWithTank(p1, p2);
    }

    private void handleCollisionWithTank(Tank p1, Tank p2) {
        if (p1.isCollision(this) && (!picked)){
            picked = true;
            p1.powerUp();
        }

        if (p2.isCollision(this) && (!picked)){
            picked = true;
            p2.powerUp();
        }
    }
}
