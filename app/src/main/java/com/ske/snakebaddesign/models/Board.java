package com.ske.snakebaddesign.models;

import com.ske.snakebaddesign.guis.BoardView;

/**
 * Created by kitipoom on 15/3/2559.
 */
public class Board {

    private Player p1;
    private Player p2;
    private BoardView boardView;
    private Square square;
    private int boardSize;

    public Board(Player p1,Player p2,BoardView boardView,int boardSize){
        this.p1=p1;
        this.p2=p2;
        this.boardView=boardView;
        this.boardSize=boardSize;
        this.boardView.setBoardSize(this.boardSize);
        p1.setBordsize(boardSize);
        p2.setBordsize(boardSize);
        square = new Square(p1,p2,boardSize);
        this.boardView.setSquarelist(square.getListsquare());
    }
    public void Restart(){
        this.p1.Reset();
        this.p2.Reset();
        boardView.setP1Position(p1.getPosition());
        boardView.setP2Position(p2.getPosition());
    }
    public void setChange(int turn){
        square.getEvent(turn);
        if (turn % 2 == 0) {
            boardView.setP1Position(p1.getPosition());
        }
        else {
            boardView.setP2Position(p2.getPosition());
        }
    }
    public Square getSquare(){
        return square;
    }
}
