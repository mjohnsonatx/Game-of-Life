package com.gameoflifethreads;

import java.io.IOException;

public class Driver {
    public static void main (String[] args) throws IOException, InterruptedException {

        final String pathname = "/Users/benjaminprentice/Desktop/grid.txt";
        final int ROWS = 20;
        final int COLS = 20;
        char[][] arr;
        int gens;

        FileHandler fileHandler = new FileHandler( pathname );
        fileHandler.createScanner();

        Grid grid = new Grid();

        arr = grid.createArray(ROWS, COLS);

        fileHandler.readFile( arr );

        gens = fileHandler.readGens();

        grid.printFirst();

        grid.updateGrid( gens );

        grid.printGrid( gens );
    }
}
