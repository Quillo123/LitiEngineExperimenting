import de.gurkenlabs.litiengine.Game;
import de.gurkenlabs.litiengine.IUpdateable;
import de.gurkenlabs.litiengine.entities.Creature;
import de.gurkenlabs.litiengine.graphics.IRenderable;
import de.gurkenlabs.litiengine.graphics.Spritesheet;
import de.gurkenlabs.litiengine.graphics.animation.Animation;
import de.gurkenlabs.litiengine.graphics.animation.IAnimationController;
import de.gurkenlabs.litiengine.input.KeyboardEntityController;
import de.gurkenlabs.litiengine.physics.IMovementController;
import de.gurkenlabs.litiengine.resources.Resources;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Player extends Creature implements IRenderable {


    public Player(String name){
        this.setName(name);

        this.initAnimationController();
        KeyboardEntityController<Player> movementController = new KeyboardEntityController<>(this);
        movementController.addUpKey(KeyEvent.VK_UP);
        movementController.addDownKey(KeyEvent.VK_DOWN);
        movementController.addLeftKey(KeyEvent.VK_LEFT);
        movementController.addRightKey(KeyEvent.VK_RIGHT);

        this.setController(IMovementController.class, movementController);
        //this.createAnimationController();
    }

    @Override
    public void render(Graphics2D g) {

    }

    private void initAnimationController() {
        IAnimationController controller = this.getControllers().getAnimationController();
        Spritesheet prepare = Resources.spritesheets().get("Sprite_Cannon_1");
        controller.add(new Animation(prepare, false));
    }

    @Override
    protected void updateAnimationController() {
        super.updateAnimationController();
        //this.initAnimationController();
    }
}
