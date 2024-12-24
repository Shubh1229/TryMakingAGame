package Inputs;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import GameStates.GameState;
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

        //System.out.println("Mouse input: Mouse Moved");
        //panel.setRectPosition(e.getX(), e.getY());
        // panel.changeXDelta((int)(e.getX()*0.03));
        // panel.changeYDelta((int)(e.getY()*0.03));
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        switch (GameState.state) {
            case PLAYING:
                panel.getGame().getPlaying().mouseClicked(e);
                break;
            case MENU:
                panel.getGame().getMenu().mouseClicked(e);
                break;
            default:
                break;
        }

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
 
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {

        
    }

    @Override
    public void mouseExited(MouseEvent e) {
 
        
    }
    
}
