package main;

import javax.swing.JPanel;

import Inputs.KeyboardInputs;
import Inputs.MouseInputs;

import java.awt.Graphics;

import java.awt.Dimension;


public class GamePanel extends JPanel{

    private MouseInputs mouseInputs;
    private Game game;
   

    public GamePanel(Game game){
        this.game = game;

        setPanelSize();
        mouseInputs = new MouseInputs(this);
        addKeyListener(new KeyboardInputs(this));
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
    }

    public void setPanelSize(){
        Dimension size = new Dimension(1280, 800);
        setMinimumSize(size);
        setMaximumSize(size);
        setPreferredSize(size);
    }


    public void paintComponent(Graphics g){
        super.paintComponent(g);
        game.render(g);

    }

    public void updateGame(){

    }

    public Game getGame(){
        return game;
    }
}
  
