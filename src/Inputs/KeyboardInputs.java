package Inputs;

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
        // TODO Auto-generated method stub
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:
                //System.out.println("Key input is W");
                panel.changeYDelta(-5);
                break;
            case KeyEvent.VK_A:
                //System.out.println("Key input is A");
                panel.changeXDelta(-5);
                break;
            case KeyEvent.VK_S:
                //System.out.println("Key input is S" );
                panel.changeYDelta(+5);
                break;
            case KeyEvent.VK_D:
                //System.out.println("Key input is D" );
                panel.changeXDelta(+5);
                break;
            default:
                //System.out.println("A Key is pressed " + e.getKeyChar());
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }
    
}
