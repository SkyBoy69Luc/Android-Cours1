package com.luc.exercicecours1;

import java.util.Random;

public class Cacou {

    private int curNbr;
    private int maxNbr;

    public enum guessState{BIGGER, EGUAL, SMALLER};

    public Cacou(int maxNbr) {
        this.maxNbr = maxNbr;
        generateNewNumber();
    }

    public guessState testNumber(int numbertest)
    {
        guessState numberState;

        if ( numbertest < curNbr   )
        {
            numberState = guessState.SMALLER;
        }
        else if(numbertest > curNbr)
        {
            numberState = guessState.BIGGER ;
        }
        else
        {
            numberState = guessState.EGUAL ;
        }
        return numberState;
    }

    public void generateNewNumber()
    {
        curNbr = new Random().nextInt(maxNbr+1);

    }
}
