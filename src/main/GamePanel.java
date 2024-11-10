package main;

import javax.swing.JPanel;

import Inputs.KeyboardInputs;
import Inputs.MouseInputs;

import java.awt.Graphics;
import java.awt.Color;

public class GamePanel extends JPanel{

    private MouseInputs mouseInputs;
    private int xDelta = 100;
    private int yDelta = 100;

    public GamePanel(){
        mouseInputs = new MouseInputs(this);
        addKeyListener(new KeyboardInputs(this));
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.fillRect(xDelta, yDelta, 200, 50);
    }
    public void changeXDelta(int delta){
        this.xDelta += delta;
        repaint();
    }
    public void changeYDelta(int delta){
        this.yDelta += delta;
        repaint();
    }
    public void setRectPosition(int x, int y){
        this.xDelta = x;
        this.yDelta = y;
        repaint();
    }
}
