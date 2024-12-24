package ui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import org.w3c.dom.events.MouseEvent;

import Util.LoadSave;

public class PauseOverLay {
    private BufferedImage background;
    private int bgX, bgY, bgW, bgH;


    public PauseOverLay(){
        loadBackground();

    }
    public void update(){

    }
    public void draw(Graphics g){

    }
     
    public void mouseClicked(MouseEvent e) {
        

    }

   
    public void mousePressed(MouseEvent e) {

    }

    
    public void mouseReleased(MouseEvent e) {

    }

    
    public void mouseMoved(MouseEvent e) {

    }

    public void mouseDragged(MouseEvent e){

    }

    private void loadBackground() {
        background = LoadSave.GetSpriteAtlas(LoadSave.PAUSE_BACKGROUND);
    }
}
