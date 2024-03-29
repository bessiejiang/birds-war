package TankGame.GameObject.Unmovable;

import TankGame.GameObject.Moveable.Tank;
import TankGame.PlayerManager;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Observable;

public abstract class Wall extends Unmovable {
    PlayerManager playerManager;

    public Wall(BufferedImage img, int x, int y, PlayerManager playerManager) {
        super(img, x, y);
        this.playerManager = playerManager;
    }

    @Override
    public void update(Observable o, Object arg) {
        super.update(o, arg);
    }

    public void draw(Graphics2D g) {
        g.drawImage(img, x, y, null);
    }

    protected void handleCollisionWithTank(Tank p1, Tank p2) {
        if (p1.isCollision(this)) {
            if (p1.getX() > getX()) {
                p1.setX(p1.getX() + p1.getSpeed() + 1); // set back (speed + 1) distance that tank can be "bounced" back from wall
            } else if (p1.getX() < (getX())) {
                p1.setX(p1.getX() - p1.getSpeed() - 1);
            }
            if (p1.getY() > getY()) {
                p1.setY(p1.getY() + p1.getSpeed() + 1);
            } else if (p1.getY() < getY()) {
                p1.setY(p1.getY() - p1.getSpeed() - 1);
            }
        }
        if (p2.isCollision(this)) {
            if (p2.getX() > getX()) {
                p2.setX(p2.getX() + p2.getSpeed() + 1);
            } else if (p2.getX() < (getX())) {
                p2.setX(p2.getX() - p2.getSpeed() - 1);
            }
            if (p2.getY() > getY()) {
                p2.setY(p2.getY() + p2.getSpeed() + 1);
            } else if (p2.getY() < getY()) {
                p2.setY(p2.getY() - p2.getSpeed() - 1);
            }
        }
    }

}
