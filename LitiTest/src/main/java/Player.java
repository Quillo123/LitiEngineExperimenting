import de.gurkenlabs.litiengine.Game;
import de.gurkenlabs.litiengine.IUpdateable;
import de.gurkenlabs.litiengine.entities.Creature;
import de.gurkenlabs.litiengine.graphics.IRenderable;
import de.gurkenlabs.litiengine.graphics.Spritesheet;
import de.gurkenlabs.litiengine.graphics.animation.IAnimationController;
import de.gurkenlabs.litiengine.input.KeyboardEntityController;
import de.gurkenlabs.litiengine.physics.IMovementController;
import de.gurkenlabs.litiengine.resources.Resources;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Player extends Creature implements IRenderable, IUpdateable {


    public Player(){
        super("Sprite_Cannon_1");


        KeyboardEntityController<Player> movementController = new KeyboardEntityController<>(this);
        movementController.addUpKey(KeyEvent.VK_UP);
        movementController.addDownKey(KeyEvent.VK_DOWN);
        movementController.addLeftKey(KeyEvent.VK_LEFT);
        movementController.addRightKey(KeyEvent.VK_RIGHT);

        this.setController(IMovementController.class, movementController);
    }

    @Override
    public void update() {

    }

    @Override
    public void render(Graphics2D g) {
        updateAnimationController();
    }

    @Override
    protected void updateAnimationController() {
        super.updateAnimationController();

        this.createAnimationController();
        IAnimationController controller = getControllers().getAnimationController();
        controller.setDefault(controller.get("Sprite_Cannon_1"));
    }
}
