package main;

public class Game implements Runnable{
    private GameWindow window;
    private GamePanel panel;
    private Thread gameThread;
    private final int FPS_SET = 120;
    public Game(){
        panel = new GamePanel();
        window = new GameWindow(panel);
        panel.requestFocus();
        startGameLoop();
    }
    @Override
    public void run() {

        double timePerFrame = 1000000000.0 / FPS_SET;
        long lastFrame = System.nanoTime();
        long now = System.nanoTime();
        int frames = 0;
        long lastCheck = System.currentTimeMillis();

        while(true){
            now = System.nanoTime();
            if(now - lastFrame >= timePerFrame){
                panel.repaint();
                lastFrame = now;
                frames++;
            }

            
            if(System.currentTimeMillis() - lastCheck >= 1000){
                lastCheck = System.currentTimeMillis();
                System.out.println("FPS: " + frames);
                frames = 0;
            }
    
        }
    }
    private void startGameLoop(){
        gameThread = new Thread(this);
        gameThread.start();
    }
}
