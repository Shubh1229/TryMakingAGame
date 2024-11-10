package main;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import Inputs.KeyboardInputs;
import Inputs.MouseInputs;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.awt.Dimension;

public class GamePanel extends JPanel{

    private MouseInputs mouseInputs;
    private float xDelta = 100, yDelta = 100; 
    private BufferedImage img, subimg;


   

    public GamePanel(){

        importImg();
        setPanelSize();
        mouseInputs = new MouseInputs(this);
        addKeyListener(new KeyboardInputs(this));
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
    }
    private void importImg() {
        InputStream is = getClass().getResourceAsStream("/player_sprites.png");
        if (is == null) {
            throw new IllegalArgumentException("Image file not found!");
        }
        try {
            img = ImageIO.read(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void setPanelSize(){
        Dimension size = new Dimension(1280, 800);
        setMinimumSize(size);
        setMaximumSize(size);
        setPreferredSize(size);
    }


    public void changeXDelta(int delta){
        this.xDelta += delta;
        
    }
    public void changeYDelta(int delta){
        this.yDelta += delta;
        
    }
    
    public void setRectPosition(int x, int y){
        this.xDelta = x;
        this.yDelta = y;
        
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);


        subimg = img.getSubimage(1*64, 8*40, 64, 40);
        g.drawImage(subimg, (int)xDelta, (int)yDelta, 128, 80, null);

    }
}
  
