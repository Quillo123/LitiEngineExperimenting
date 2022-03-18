import de.gurkenlabs.litiengine.Game;
import de.gurkenlabs.litiengine.entities.IEntity;
import de.gurkenlabs.litiengine.entities.IEntityController;
import de.gurkenlabs.litiengine.input.Input;
import de.gurkenlabs.litiengine.input.MousePathController;

import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class CamerController implements IEntityController {
    @Override
    public void update() {
        Input.mouse().onWheelMoved(new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                Game.world().camera().setZoom(Game.world().camera().getZoom() + e.getScrollAmount(), 1);
            }
        });
    }

    @Override
    public void attach() {

    }

    @Override
    public void detach() {

    }

    @Override
    public IEntity getEntity() {
        return null;
    }
}
