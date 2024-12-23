package main;

import javax.swing.JPanel;

import Inputs.KeyboardInputs;
import Inputs.MouseInputs;

import java.awt.Graphics;

import java.awt.Dimension;
import static main.Game.GAME_HEIGHT;
import static main.Game.GAME_WIDTH;

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
        Dimension size = new Dimension(GAME_WIDTH, GAME_HEIGHT);
        setPreferredSize(size);
        System.out.println("Size : " + GAME_WIDTH + " : " + GAME_HEIGHT);
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
  
