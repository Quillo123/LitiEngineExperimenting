import de.gurkenlabs.litiengine.Game;
import de.gurkenlabs.litiengine.IUpdateable;
import de.gurkenlabs.litiengine.entities.Creature;
import de.gurkenlabs.litiengine.environment.CreatureMapObjectLoader;
import de.gurkenlabs.litiengine.environment.Environment;

import javax.rmi.ssl.SslRMIClientSocketFactory;

public class GameController{

    public static Player player;
    public static TowerSpawner towerSpawner;

    public static void init(){
        CreatureMapObjectLoader.registerCustomCreatureType(Enemy.class);
        CreatureMapObjectLoader.registerCustomCreatureType(Player.class);

        towerSpawner = new TowerSpawner();
    }


}
