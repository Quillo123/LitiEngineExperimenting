import de.gurkenlabs.litiengine.graphics.IRenderable;
import de.gurkenlabs.litiengine.graphics.Spritesheet;
import de.gurkenlabs.litiengine.graphics.animation.Animation;
import de.gurkenlabs.litiengine.graphics.animation.IAnimationController;
import de.gurkenlabs.litiengine.resources.Resources;

import java.awt.*;

public class Enemy extends Mob implements IRenderable {


    Enemy(String name){
        this.setName(name);
        this.initAnimationController();
    }

    private void initAnimationController() {
        IAnimationController controller = this.getControllers().getAnimationController();
        Spritesheet prepare = Resources.spritesheets().get("Sprite_Cannon_1");
        controller.add(new Animation(prepare, false));
    }

    @Override
    protected void updateAnimationController(){
        super.updateAnimationController();
        //this.initAnimationController();
    }

    @Override
    public void render(Graphics2D g) {

    }
}
