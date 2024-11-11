package Entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import static Util.Constant.PlayerConstants.*;


import javax.imageio.ImageIO;

public class Player extends Entity{

    private BufferedImage[][] animation;
    private int animationtick, animationindex, animationspeed = 20;
    private int player_Action = IDLE;
    private boolean moving = false, left, up, right, down, attacking = false;
    private float playerSpeed = 2.0f;

    public Player(float x, float y){
        super(x, y);
        loadAnimations();
    }

    public void update(){
        updatePosition();
        updateAnimationTick();
        setAnimation();
    }
    public void render(Graphics g){
        g.drawImage(animation[player_Action][animationindex], (int)x, (int)y, 256, 160, null);
    }


    public void updateAnimationTick(){
        animationtick++;
        if(animationtick >= animationspeed){
            animationtick = 0;
            animationindex++;
            if(animationindex >= GetSpriteAmount(player_Action)){
                animationindex = 0;
                attacking = false;
            }
        }
    }

    public void setAnimation(){

        int startanimation = player_Action;

        if(moving){
            player_Action = RUNNING;
        } else{
            player_Action = IDLE;
        }

        if(attacking){
            player_Action = ATTACK_1;
        }
        if(startanimation != player_Action){
            resetAnimationTick();
        }
    }
    
    public void resetAnimationTick(){
        animationindex = 0;
        animationtick = 0;
    }

    public void updatePosition(){
        moving = false;
        if(left && !right){
            x-=playerSpeed;
            moving = true;
        } else if(right && !left){
            x+=playerSpeed;
            moving = true;
        }
        if(up && !down){
            y-=playerSpeed;
            moving = true;
        } else if(down && !up){
            y+=playerSpeed;
            moving = true;
        }

    }
    

    public boolean getLeft() {
        return this.left;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    public boolean getUp() {
        return this.up;
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    public boolean getRight() {
        return this.right;
    }

    public void setRight(boolean right) {
        this.right = right;
    }

    public boolean getDown() {
        return this.down;
    }

    public void setDown(boolean down) {
        this.down = down;
    }


    private void loadAnimations(){
        InputStream is = getClass().getResourceAsStream("/player_sprites.png");
        if (is == null) {
            throw new IllegalArgumentException("Image file not found!");
        }
        try {
            BufferedImage img = ImageIO.read(is);
            animation = new BufferedImage[9][6];
        for(int j = 0; j < animation.length; j++){
            for(int i = 0; i < animation[j].length; i++){
                animation[j][i] = img.getSubimage(i*64, j*40, 64, 40);
            }
        }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
            }
        }
        
    }

    public void setDirbooleans(boolean b) {
        left = false;
        right = false;
        up = false;
        down = false;
        attacking = false;
        moving = false;
    }
    
    public void setAttack(boolean attacking){
        this.attacking = attacking;
    }



}
