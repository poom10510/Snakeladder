package com.ske.snakebaddesign.models;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.ske.snakebaddesign.guis.BoardView;

/**
 * Created by kitipoom on 10/3/2559.
 */
public class Game {
    private int boardSize;
    private int maxSquare;


    private Player p1;
    private Player p2;
    private int turn;

    private BoardView boardView;

    private Board board;

    private TextView textPlayerTurn;

    private AppCompatActivity app;
    
    
    private Die dice;

    public Game(BoardView boardView,TextView textPlayerTurn,AppCompatActivity app){

        this.boardView=boardView;
        this.p1 = new Player("Player 1");
        this.p2 = new Player("Player 2");

        this.textPlayerTurn=textPlayerTurn;
        this.app=app;
        dice = new Die();
        this.boardSize =6; // add value.
        this.maxSquare=boardSize*boardSize-1;
        this.board = new Board(p1,p2,boardView,boardSize);

    }

    public void takeTurn() {
        final int value = dice.Toss();
        String title = "You rolled a die";
        String msg = "You got " + value;

        DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                moveCurrentPiece(value);
                dialog.dismiss();
            }
        };
        displayDialog(title, msg, listener);
    }

   public void resetGame() {
        turn = 0;
       board.Restart();
       String p = getCurrentPlayer(turn).getName()+"'s Turn";
       textPlayerTurn.setText(p);
    }


    private void moveCurrentPiece(int value) {
        getCurrentPlayer(turn).setPosition(value);
        board.setChange(turn);
        String p = getCurrentPlayer(turn+1).getName()+"'s Turn";
        textPlayerTurn.setText(p);
        checkWin();
        turn++;
    }

    private void checkWin() {
        String title = "Game Over";
        String msg = "";
        DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                resetGame();
                dialog.dismiss();
            }
        };
        if (p1.getPosition() == maxSquare) {
            msg = "Player 1 won!";
        } else if (p2.getPosition() == maxSquare) {
            msg = "Player 2 won!";
        } else {
            return;
        }
        displayDialog(title, msg, listener);
    }
    public Player getCurrentPlayer(int turn){
        if (turn % 2 == 0) {
            return p1;
        }
        else{
           return p2;
        }
    }

    public void displayDialog(String title, String message, DialogInterface.OnClickListener listener) {
        AlertDialog alertDialog = new AlertDialog.Builder(app).create();
        alertDialog.setTitle(title);
        alertDialog.setMessage(message);
        alertDialog.setCancelable(false);
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK", listener);
        alertDialog.show();
    }



}
