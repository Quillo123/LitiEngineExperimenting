import de.gurkenlabs.litiengine.Game;
import de.gurkenlabs.litiengine.GameListener;
import de.gurkenlabs.litiengine.entities.*;
import de.gurkenlabs.litiengine.entities.behavior.IBehaviorController;
import de.gurkenlabs.litiengine.environment.Environment;
import de.gurkenlabs.litiengine.environment.EnvironmentListener;
import de.gurkenlabs.litiengine.environment.tilemap.ICustomPropertyProvider;
import de.gurkenlabs.litiengine.graphics.RenderType;
import de.gurkenlabs.litiengine.graphics.animation.IEntityAnimationController;
import de.gurkenlabs.litiengine.gui.screens.Resolution;
import de.gurkenlabs.litiengine.input.IKeyboard;
import de.gurkenlabs.litiengine.input.Input;

import javax.sound.midi.SysexMessage;
import java.awt.event.KeyEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.List;

public class Program {

    public static void main(String[] args){
        Game.init(args);


        Game.screens().add(new TestScreen());

        Game.window().setResolution(Resolution.Ratio4x3.RES_1280x960);

        Game.world().loadEnvironment(new Environment("src/main/TileMaps/TestMap.tmx"));

        Game.world().camera().pan(400, 300, 1);
        Game.world().camera().setZoom(.75f, 1);

        Input.mouse().onWheelMoved(new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                var speed = .005f;
                Game.world().camera().setZoom(Game.world().camera().getZoom() - e.getUnitsToScroll() * speed, 1);
            }
        });

        Input.keyboard().onKeyPressed( new IKeyboard.KeyPressedListener() {
            @Override
            public void keyPressed(KeyEvent event) {
                var cam = Game.world().camera();
                var speed = 1f;
                if(event.getKeyChar() == 'w'){
                    cam.pan(cam.getFocus().getX(), cam.getFocus().getY() - Game.loop().getDeltaTime() * speed, 1);
                }
                if(event.getKeyChar() == 'a'){
                    cam.pan(cam.getFocus().getX() - Game.loop().getDeltaTime() * speed, cam.getFocus().getY(), 1);
                }
                if(event.getKeyChar() == 's'){
                    cam.pan(cam.getFocus().getX(), cam.getFocus().getY() + Game.loop().getDeltaTime() * speed, 1);
                }
                if(event.getKeyChar() == 'd'){
                    cam.pan(cam.getFocus().getX() + Game.loop().getDeltaTime() * speed, cam.getFocus().getY(), 1);
                }
                if(event.getKeyCode() == 27){
                    Game.exit();
                }
            }
        });


        Game.start();
    }



}
