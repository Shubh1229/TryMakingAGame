package ui;

import static Util.Constant.UI.Buttons.*;
import Util.LoadSave;
import gameStates.GameState;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class MenuButton {
    private int xPos, yPos, rowIndex, index, xOffsetCenter = B_WIDTH / 2;
    private GameState state;
    private BufferedImage[] img;
    private boolean mouseOver, mousePressed;
    private Rectangle bounds;

    public MenuButton(int xPos, int yPos, int rowIndex, GameState state){
        this.xPos = xPos;
        this.yPos = yPos;
        this.rowIndex = rowIndex;
        this.state = state;
        loadImgs();
        initBounds();
    }


    private void loadImgs(){
        img = new BufferedImage[3];
        BufferedImage temp = LoadSave.GetSpriteAtlas(LoadSave.MENU_BUTTONS);
        for(int i = 0; i < img.length; i++){
            img[i] = temp.getSubimage(i * B_WIDTH_DEFAULT, rowIndex * B_HEIGHT_DEFAULT, B_WIDTH_DEFAULT, B_HEIGHT_DEFAULT);

        }
    }
    public void draw(Graphics g){
        g.drawImage(img[index], xPos - xOffsetCenter, yPos, B_WIDTH, B_HEIGHT, null);
    }
    public void update(){
        index = 0;
        if(mouseOver){
            index = 1;
        }
        if(mousePressed){
            index = 2;
        }
    }
    public void  setMouseOver(boolean  b){
        mouseOver = b;
    }
    public void setMousePressed(boolean b){
        mousePressed = b;
    }
    public boolean getMouseOver(){
        return mouseOver;
    }
    public boolean getMousePressed(){
        return mousePressed;
    }

    private void initBounds() {
        bounds = new Rectangle(xPos - xOffsetCenter, yPos, B_WIDTH, B_HEIGHT);
    }
    public void applyGameState(){
        GameState.state = state;
    }
    public void resetBools(){
        mouseOver = false;
        mousePressed = false;
    }
    public Rectangle getBounds(){
        return bounds;
    }

}
