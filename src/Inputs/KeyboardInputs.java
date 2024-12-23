package Inputs;

import gameStates.GameState;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import main.GamePanel;

public class KeyboardInputs implements KeyListener{

    private GamePanel panel;

    public KeyboardInputs(GamePanel panel){
        this.panel = panel;
    }

    @Override
    public void keyTyped(KeyEvent e) {
  
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (GameState.state) {
            case MENU:
                panel.getGame().getMenu().keyPressed(e);
                break;
            case PLAYING:
                panel.getGame().getPlaying().keyPressed(e);
                break;
            default:
                break;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

        switch (GameState.state) {
            case MENU:
                panel.getGame().getMenu().keyReleased(e);
                break;
            case PLAYING:
                panel.getGame().getPlaying().keyReleased(e);
                break;
            default:
                break;
        }
    }
    
}
