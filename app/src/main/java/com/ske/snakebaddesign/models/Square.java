package com.ske.snakebaddesign.models;

import com.ske.snakebaddesign.models.SquareType.NormalSquare;
import com.ske.snakebaddesign.models.SquareType.SpecialSquare;
import com.ske.snakebaddesign.models.SquareType.Squaretype;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kitipoom on 15/3/2559.
 */
public class Square {
    private Player p1;
    private Player p2;
    private int boardSize;
    private List<Squaretype> listsquare;

    public Square(Player p1,Player p2,int boardSize) {
        this.p1 = p1;
        this.p2 = p2;
        this.boardSize = boardSize;
        this.listsquare= new ArrayList<Squaretype>();
        createSquare();
    }
    public void createSquare(){
        for(int i=0;i<boardSize*boardSize;i++){
            if(i==10){
                listsquare.add(new SpecialSquare());
            }
            else{
                listsquare.add(new NormalSquare());
            }

        }

    }
    public void getEvent(int turn){
        if (turn % 2 == 0) {
           listsquare.get(p1.getPosition()).run(p1);
        }
        else {
            listsquare.get(p2.getPosition()).run(p2);
        }
    }
}
