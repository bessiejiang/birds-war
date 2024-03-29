package TankGame.Loader;

import TankGame.GameObject.ResourceField;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import static TankGame.GameObject.ResourceField.*;

public class SpriteLoader {
    private static final Logger LOGGER = Logger.getLogger(SpriteLoader.class.getName());
    private static Map<ResourceField, String> spritesMap = new HashMap<>();

    public SpriteLoader() {
        spritesMap.put(BACKGROUND, "/TankGame/resources/Background.jpeg");
        spritesMap.put(MENU, "/TankGame/resources/Menu.png");
        spritesMap.put(WIN_OR_LOSE, "/TankGame/resources/WinOrLose.png");
        spritesMap.put(UNBREAKABLE_WALL, "/TankGame/resources/Wall1.png");
        spritesMap.put(BREAKABLE_WALL, "/TankGame/resources/Wall2.png");
        spritesMap.put(TANK1, "/TankGame/resources/Tank1.png");
        spritesMap.put(TANK2, "/TankGame/resources/Tank2.png"  );
        spritesMap.put(BULLET, "/TankGame/resources/Bullet.gif");
        spritesMap.put(BULLET2, "/TankGame/resources/Bullet2.png");
        spritesMap.put(LIFE_POWER_UP, "/TankGame/resources/LifePowerUp.png");
        spritesMap.put(BULLET_POWER_UP, "/TankGame/resources/Strengthen.png");
        spritesMap.put(LIFE_ICON1, "/TankGame/resources/LifeIcon1.png");
        spritesMap.put(LIFE_ICON2, "/TankGame/resources/LifeIcon2.png");
    }

    public BufferedImage loadSprite(ResourceField field) {
        BufferedImage sprite = null;
        try {
            sprite = ImageIO.read(SpriteLoader.class.getResource(spritesMap.get(field)));
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Failed to load sprite for " + field, e);
        }
        return sprite;
    }
}
