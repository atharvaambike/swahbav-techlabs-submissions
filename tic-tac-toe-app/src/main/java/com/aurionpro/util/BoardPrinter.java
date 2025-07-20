package com.aurionpro.util;

import com.aurionpro.model.Board;
import com.aurionpro.model.MarkType;

public class BoardPrinter {

    public void print(Board board) {
        System.out.println("\nCurrent Board:");
        String[][] labels = {
		        { "1", "2", "3" },
		        { "4", "5", "6" },
		        { "7", "8", "9" }
		    };

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                MarkType mark = board.getMarkAt(i, j);
                char toPrint = (mark == MarkType.EMPTY) ? labels[i][j].charAt(0) : mark.name().charAt(0);
                System.out.print(" " + toPrint + " ");
            }
            System.out.println();
        }
    }
}
