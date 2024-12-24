package main;

import java.awt.Graphics;

import Entities.Player;
import levels.LevelManager;

public class Game implements Runnable{
    private GameWindow window;
    private GamePanel panel;
    private Thread gameThread;
    private final int FPS_SET = 120, UPS_SET = 200;
    private Player player;
    private LevelManager levelManager;

    public final static int TILES_DEFAULT_SIZE = 32;
    public final static float SCALE = 2f;
    public static final int TILES_IN_WIDTH = 26;
    public final static int TILES_IN_HEIGHT = 14;
    public final static int TILE_SIZE = (int) (TILES_DEFAULT_SIZE * SCALE);
    public final static int GAME_WIDTH = TILE_SIZE * TILES_IN_WIDTH;
    public final static int GAME_HEIGHT = TILE_SIZE * TILES_IN_HEIGHT;

    public Game(){
        initClasses();

        panel = new GamePanel(this);
        window = new GameWindow(panel);
        panel.requestFocus();

        startGameLoop();
        
    }
    private void initClasses(){
        levelManager = new LevelManager(this);
        player = new Player(200, 200, (int)(64*SCALE), (int)(40*SCALE));
        player.loadLEVELDATA(levelManager.getCurrentLevel().getLevelData());
    }

    public void update(){
        player.update();
        levelManager.update();
    }

    public void render(Graphics g){
        levelManager.draw(g);
        player.render(g);
        
    }

    @Override
    public void run() {

        double timePerFrame = 1000000000.0 / FPS_SET;
        double timePerUpdate = 1000000000.0 / UPS_SET;



        long previousTime = System.nanoTime();


        int frames = 0;
        int update = 0;
        long lastCheck = System.currentTimeMillis();

        double deltaU = 0;
        double deltaF = 0;

        while(true){

            long currentTime = System.nanoTime();

            deltaU += (currentTime - previousTime) / timePerUpdate;
            deltaF += (currentTime - previousTime) / timePerFrame;

            previousTime = currentTime;

            if(deltaU >= 1){
                update();
                update++;
                deltaU--;
            }
            
            if(deltaF >= 1){
                panel.repaint();
                deltaF--;
                frames++;
            }


            
            if(System.currentTimeMillis() - lastCheck >= 1000){
                lastCheck = System.currentTimeMillis();
                System.out.println("FPS: " + frames + " | UPS: " + update);
                frames = 0;
                update = 0;
            }
    
        }
    }
    private void startGameLoop(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    public Player getPlayer(){
        return player;
    }

    public void windowFocusLost(){
        player.setDirbooleans(false);

    }


}
