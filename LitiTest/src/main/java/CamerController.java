import de.gurkenlabs.litiengine.Game;
import de.gurkenlabs.litiengine.IUpdateable;
import de.gurkenlabs.litiengine.entities.IEntity;
import de.gurkenlabs.litiengine.entities.IEntityController;
import de.gurkenlabs.litiengine.graphics.ICamera;
import de.gurkenlabs.litiengine.input.IKeyboard;
import de.gurkenlabs.litiengine.input.Input;
import de.gurkenlabs.litiengine.input.MousePathController;
import de.gurkenlabs.litiengine.physics.IMovementController;
import de.gurkenlabs.litiengine.physics.MovementController;

import java.awt.event.KeyEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class CamerController{

    ICamera cam;

    CamerController(ICamera camera){
        cam = camera;
        Input.mouse().onWheelMoved(new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                var speed = .005f;
                cam.setZoom(Game.world().camera().getZoom() - e.getUnitsToScroll() * speed, 1);
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
    }

}
