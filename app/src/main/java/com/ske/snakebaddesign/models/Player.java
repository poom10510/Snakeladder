package com.ske.snakebaddesign.models;

import com.ske.snakebaddesign.guis.BoardView;

/**
 * Created by kitipoom on 10/3/2559.
 */
public class Player {
    private int position;
    private int bordsize;
    private int maxSquare;

    private String name;

    private BoardView boardView;

    public Player(String name){
        this.name=name;
        this.position=0;

    }

    public  void setBordsize(int bordsize){
        this.bordsize = bordsize;
        this.maxSquare = bordsize*bordsize-1;


    }
    public void setPosition(int value){
        this.position += value;
        if(this.position > maxSquare) {
            this.position = maxSquare - ( this.position - maxSquare);
        }
        else if(this.position<0){
            this.position = 0-(this.position);
        }
    }
    public void setPoint(int value){
        this.position = value;
    }
    public void Reset(){
        this.position =0;
    }
    public int getPosition(){
        return this.position;
    }
    public String getName(){return this.name;}
}
