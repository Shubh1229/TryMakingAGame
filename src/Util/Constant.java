package Util;

import main.Game;

public class Constant {

    public static class Directions{
        public static final int LEFT = 0;
        public static final int UP = 1;
        public static final int RIGHT = 2;
        public static final int DOWN = 3;

        // public static int GetSpriteAmount(int player_Action){
        //     switch (player_Action) {
        //         case LEFT:
                    
        //             return 6;
        //         case UP:
                    
        //             return 5;
        //         case RIGHT:
                    
        //             return 3;
        //         case DOWN:
                    
        //         default:
        //             return 1;
        //     }
        // }

    }

    public static class UI{
        public static class Buttons{
            public static final int B_WIDTH_DEFAULT = 140;
            public static final int B_HEIGHT_DEFAULT = 56;
            public static final int B_WIDTH = (int)(B_WIDTH_DEFAULT * Game.SCALE);
            public static final int B_HEIGHT = (int)(B_HEIGHT_DEFAULT * Game.SCALE);

        }
    }



    public static class PlayerConstants{
        public static final int RUNNING = 1;
        public static final int IDLE = 0;
        public static final int JUMP = 2;
        public static final int FALLING = 3;
        public static final int GROUND = 4;
        public static final int HIT = 5;
        public static final int ATTACK_1 = 6;
        public static final int ATTACK_JUMP = 7;
        public static final int ATTACK_JUMP_2 = 8;

        public static int GetSpriteAmount(int player_Action){
            switch (player_Action) {
                case RUNNING:
                    
                    return 6;
                case IDLE:
                    
                    return 5;
                case JUMP:
                    
                    return 3;
                case FALLING:
                    
                    return 1;
                case GROUND:
                    
                    return 2;
                case HIT:
                    
                    return 4;
                case ATTACK_1:
                case ATTACK_JUMP:
                case ATTACK_JUMP_2:
                    
                    return 3;
                default:
                    return 1;
            }
        }
    }
}
