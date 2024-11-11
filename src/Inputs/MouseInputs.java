package Inputs;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import main.Game;
import main.GamePanel;

public class MouseInputs implements MouseListener, MouseMotionListener{
    
    private GamePanel panel;
    
    public MouseInputs(GamePanel panel){
        this.panel = panel;
    }
    @Override
    public void mouseDragged(MouseEvent e) {
        // TODO Auto-generated method stub
        //System.out.println("Mouse input: Mouse Dragged");
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        // TODO Auto-generated method stub
        //System.out.println("Mouse input: Mouse Moved");
        //panel.setRectPosition(e.getX(), e.getY());
        // panel.changeXDelta((int)(e.getX()*0.03));
        // panel.changeYDelta((int)(e.getY()*0.03));
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
        //System.out.println("Mouse input: Mouse Clicked");
        if(e.getButton() == MouseEvent.BUTTON1){
            panel.getGame().getPlayer().setAttack(true);
        }
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }
    
}
