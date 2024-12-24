package Util;

import java.awt.geom.Rectangle2D;

import main.Game;

public class HelpMethods {
    public static boolean CanMoveHERE(float x, float y, float width, float height, int[][] lvlData){
        if(!IsSolid(x, y, lvlData)){
            if(!IsSolid(x+width, y+height, lvlData)){
                if(!IsSolid(x+width, y, lvlData)){
                    if(!IsSolid(x, y+height, lvlData)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    private static boolean IsSolid(float x, float y, int[][]lvlData){
        if(x < 0 || x >= Game.GAME_WIDTH){
            return true;
        }
        if(y < 0 || y >= Game.GAME_HEIGHT){
            return true;
        }
        float xIndex = x / Game.TILE_SIZE;
        float yIndex = y / Game.TILE_SIZE;
        int value = lvlData[(int)yIndex][(int)xIndex];
        if(value >= 48 || value < 0 || value != 11){
            return true;
        } 
        return false;
    }
    public static float GetEntityXPosNextToWall(Rectangle2D.Float hitBox, float xSpeed){
        int currentTile = (int) (hitBox.x / Game.TILE_SIZE);
        if(xSpeed > 0){
            //right
            int tileXpos = currentTile * Game.TILE_SIZE;
            int xOffSet = (int)(Game.TILE_SIZE - hitBox.width);
            return tileXpos + xOffSet - 1;
        } else {
            //left
            return currentTile * Game.TILE_SIZE;
        }
    }
    public static float GetEntityYPosUnderRoofOrAboveFloor(Rectangle2D.Float hitBox, float airSpeed){
        int currentTile = (int) (hitBox.y / Game.TILE_SIZE);
        if(airSpeed > 0){
            //falling - touching floor
            int tileYpos = currentTile * Game.TILE_SIZE;
            int yOffSet = (int)(Game.TILE_SIZE - hitBox.height);
            return tileYpos + yOffSet - 1;
        } else {
            // jumping
            return currentTile * Game.TILE_SIZE;
        }
    }
    public static boolean IsEntityOnFloor(Rectangle2D.Float hitBox, int[][] lvlData){
        //check the pixel below bottom left and bhottom right 
        if(!IsSolid(hitBox.x, hitBox.y + hitBox.height + 1 , lvlData)){
            if(!IsSolid(hitBox.x + hitBox.width, hitBox.y + hitBox.height + 1, lvlData)){
                return false;
            }
        }
        return true;
    }
}
