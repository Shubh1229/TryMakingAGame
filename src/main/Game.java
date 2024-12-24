package main;

import java.awt.Graphics;

import GameStates.GameState;
import GameStates.Menu;
import GameStates.Playing;


public class Game implements Runnable{
    private GameWindow window;
    private GamePanel panel;
    private Thread gameThread;
    private final int FPS_SET = 120, UPS_SET = 200;

    private Playing playing;
    private Menu menu;


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
        menu = new Menu(this);
        playing = new Playing(this);
    }

    public void update(){

        switch (GameState.state) {
            case MENU:
                menu.update();
                break;
            case PLAYING:
                playing.update();
                break;
            default:
                break;
        }
    }

    public void render(Graphics g){
        switch (GameState.state) {
            case MENU:
                menu.draw(g);
                break;
            case PLAYING:
                playing.draw(g);
                break;
            default:
                break;
        }
    

        
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

    // public Player getPlayer(){
    //     return player;
    // }

    public void windowFocusLost(){
        if(GameState.state == GameState.PLAYING){
            playing.getPlayer().setDirbooleans(false);
        }

    }
    public Menu getMenu(){
        return menu;
    }
    public Playing getPlaying(){
        return playing;
    }


}
