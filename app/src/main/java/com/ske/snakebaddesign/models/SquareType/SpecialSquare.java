package com.ske.snakebaddesign.models.SquareType;

import com.ske.snakebaddesign.models.Player;

/**
 * Created by kitipoom on 15/3/2559.
 */
public class SpecialSquare extends Squaretype {

    public SpecialSquare(){

    }
    @Override
    public void run(Player p) {
        p.setPoint(0);
        return;
    }
}
