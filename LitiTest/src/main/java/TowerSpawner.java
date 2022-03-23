import de.gurkenlabs.litiengine.Game;
import de.gurkenlabs.litiengine.IUpdateable;
import de.gurkenlabs.litiengine.input.IKeyboard;
import de.gurkenlabs.litiengine.input.IMouse;
import de.gurkenlabs.litiengine.input.Input;
import de.gurkenlabs.litiengine.input.Keyboard;
import net.java.games.input.Component;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class TowerSpawner implements IUpdateable, IMouse.MouseClickedListener, IKeyboard.KeyPressedListener {

    Tower.TowerType selectedTower = Tower.TowerType.Cannon;

    TowerSpawner(){
        Input.mouse().onClicked(this);
        Input.keyboard().onKeyPressed(this);
        Game.loop().attach(this);
    }

    @Override
    public void mouseClicked(MouseEvent event) {
        if(event.getButton() == MouseEvent.BUTTON1){

        }
    }

    @Override
    public void keyPressed(KeyEvent event) {
        if(event.getKeyCode() == KeyEvent.VK_1){
            selectedTower = Tower.TowerType.Cannon;
            System.out.println("Selected " + selectedTower);
        }
        else if (event.getKeyCode() == KeyEvent.VK_2){
            selectedTower = Tower.TowerType.FlameThrower;
            System.out.println("Selected " + selectedTower);
        }
    }

    @Override
    public void update() {

    }
}
