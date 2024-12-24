package Inputs;

import gameStates.GameState;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import main.GamePanel;

public class MouseInputs implements MouseListener, MouseMotionListener{
    
    private GamePanel panel;
    
    public MouseInputs(GamePanel panel){
        this.panel = panel;
    }
    @Override
    public void mouseDragged(MouseEvent e) {

        //System.out.println("Mouse input: Mouse Dragged");
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        switch (GameState.state) {
            case MENU -> panel.getGame().getMenu().mouseMoved(e);
            default -> {
                break;
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        switch (GameState.state) {
            case PLAYING -> panel.getGame().getPlaying().mouseClicked(e);
            case MENU -> panel.getGame().getMenu().mouseClicked(e);
            default -> {
                break;
            }
        }

    }

    @Override
    public void mousePressed(MouseEvent e) {
        switch (GameState.state) {
            case PLAYING -> panel.getGame().getPlaying().mouseClicked(e);
            case MENU -> panel.getGame().getMenu().mousePressed(e);
            default -> {
                break;
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        switch (GameState.state) {
            case MENU -> panel.getGame().getMenu().mouseReleased(e);
            default -> {
                break;
            }
        }
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {

        
    }

    @Override
    public void mouseExited(MouseEvent e) {
 
        
    }
    
}
