import de.gurkenlabs.litiengine.Game;
import de.gurkenlabs.litiengine.entities.Creature;
import de.gurkenlabs.litiengine.entities.IEntity;
import de.gurkenlabs.litiengine.environment.CollisionBoxMapObjectLoader;
import de.gurkenlabs.litiengine.environment.CreatureMapObjectLoader;
import de.gurkenlabs.litiengine.environment.Environment;
import de.gurkenlabs.litiengine.environment.IMapObjectLoader;
import de.gurkenlabs.litiengine.environment.tilemap.IMapObject;
import de.gurkenlabs.litiengine.graphics.Camera;
import de.gurkenlabs.litiengine.graphics.PositionLockCamera;
import de.gurkenlabs.litiengine.graphics.Spritesheet;
import de.gurkenlabs.litiengine.gui.screens.GameScreen;
import de.gurkenlabs.litiengine.gui.screens.Resolution;
import de.gurkenlabs.litiengine.resources.Resources;

import java.awt.image.BufferedImage;
import java.util.Collection;

public class Program {

    public static void main(String[] args){


        Game.init(args);

        Resources.load("game.litidata");

        Game.screens().add(new GameScreen());

        Game.window().setResolution(Resolution.Ratio4x3.RES_1280x960);

        Game.world().loadEnvironment(new Environment("src/main/TileMaps/TestMap.tmx"));
        Game.world().environment().init();

        Game.world().camera().pan(400, 300, 1);
        Game.world().camera().setZoom(.75f, 1);

        GameController.init();



        Enemy enemy = new Enemy("Enemy");
        Game.world().environment().add(enemy);
        enemy.setLocation(100, 100);

        CamerController camerController = new CamerController(Game.world().camera());

        //Camera cam = new PositionLockCamera(GameController.player);
        //Game.world().setCamera(cam);


        Game.start();
    }
}
