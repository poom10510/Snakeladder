package com.ske.snakebaddesign.models;

import java.util.Random;

/**
 * Created by kitipoom on 10/3/2559.
 */
public class Die {
    public static final int Min_value = 1;
    public static final int Max_value=6;
    int dice;
    Random rand;


    public Die(){

        rand = new Random();
    }


    public int Toss(){
        dice = Min_value+ rand.nextInt(Max_value);
        return dice;
    }

}
