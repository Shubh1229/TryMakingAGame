package Entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import static Util.Constant.PlayerConstants.*;
import static Util.HelpMethods.*;



import Util.LoadSave;
import main.Game;

public class Player extends Entity{

    private BufferedImage[][] animation;
    private int animationtick, animationindex, animationspeed = 20;
    private int player_Action = IDLE;
    private boolean moving = false, left, up, right, down, attacking = false;
    private float playerSpeed = 2.0f;
    private int[][] lvlData;
    private float xDrawOffSet = 21 * Game.SCALE, yDrawOffSet = 4*Game.SCALE;
    //jumping and gravity
    private boolean jump, inAir = false;
    private float airSpeed = 0f, gravity = 0.04f * Game.SCALE, jumpSpeed = -2.25f * Game.SCALE, fallSpeedAfterCollision = 0.5f * Game.SCALE;


    public Player(float x, float y, int width, int height){
        super(x, y, width, height);
        loadAnimations();
        initHitBox(x, y, 20*Game.SCALE, 27*Game.SCALE);
    }

    public void update(){
        updatePosition();
        updateAnimationTick();
        setAnimation();
    }
    public void render(Graphics g){
        g.drawImage(animation[player_Action][animationindex], (int)(hitBox.x - xDrawOffSet), (int)(hitBox.y - yDrawOffSet), width, height, null);
        // drawHitBox(g);
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
        if(inAir){
            if(airSpeed < 0){
                player_Action = JUMP;
            } else{
                player_Action = FALLING;
            }
        }
        if(attacking && !inAir){
            player_Action = ATTACK_1;
        } else if (attacking && inAir){
            player_Action = ATTACK_JUMP;
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
        if(jump){
            jump();
        }
        if(!left && !right && !inAir){
            return;
        }
        float xSpeed = 0;
        if(left ){
            xSpeed -= playerSpeed;    
        }  
        if(right ){
            xSpeed += playerSpeed;    
        }
        if(!inAir){
            if(!IsEntityOnFloor(hitBox, lvlData)){
                inAir = true;
            }
        }
        if(inAir){
            if(CanMoveHERE(hitBox.x, hitBox.y + airSpeed, hitBox.width, hitBox.height, lvlData)){
                hitBox.y += airSpeed;
                airSpeed += gravity;
                updateXPos(xSpeed);
            } else {
                hitBox.y = GetEntityYPosUnderRoofOrAboveFloor(hitBox, airSpeed);
                if(airSpeed > 0){
                    resetInAir();
                } else {
                    airSpeed = fallSpeedAfterCollision;
                }
                updateXPos(xSpeed);
            }
        } else{
            updateXPos(xSpeed);
        }
        moving = true;

    }
    private void updateXPos(float xSpeed){
        if(CanMoveHERE(hitBox.x+xSpeed ,hitBox.y , hitBox.width, hitBox.height, lvlData)){
            hitBox.x += xSpeed;
        } else {
            hitBox.x = GetEntityXPosNextToWall(hitBox, xSpeed);
        }
    }
    private void resetInAir(){
        inAir = false;
        airSpeed = 0;
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
    public void setJump(boolean jump){
        this.jump = jump;
    }


    private void loadAnimations(){
        BufferedImage img = LoadSave.GetSpriteAtlas(LoadSave.PLAYER_ATLAS);
        animation = new BufferedImage[9][6];
        for(int j = 0; j < animation.length; j++){
            for(int i = 0; i < animation[j].length; i++){
                animation[j][i] = img.getSubimage(i*64, j*40, 64, 40);
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
    public void loadLEVELDATA(int[][] lvlData){
        this.lvlData = lvlData;
        if(!IsEntityOnFloor(hitBox, lvlData)){
            inAir = true;
        }
    }
    private void jump(){
        if(inAir){
            return;
        }
        inAir = true;
        airSpeed = jumpSpeed;
    }



}
