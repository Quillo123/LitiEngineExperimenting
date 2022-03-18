import de.gurkenlabs.litiengine.Game;
import de.gurkenlabs.litiengine.GameListener;
import de.gurkenlabs.litiengine.entities.IEntity;
import de.gurkenlabs.litiengine.environment.Environment;
import de.gurkenlabs.litiengine.gui.screens.Resolution;
import de.gurkenlabs.litiengine.input.Input;

public class Program {

    public static void main(String[] args){
        Game.init(args);


        Game.screens().add(new TestScreen());

        Game.window().setResolution(Resolution.Ratio4x3.RES_1280x960);

        Game.world().loadEnvironment(new Environment("src/main/TileMaps/TestMap.tmx"));

        Game.world().camera().pan(400, 300, 1);
        Game.world().camera().setZoom(.75f, 1);


        Game.start();
    }



}
