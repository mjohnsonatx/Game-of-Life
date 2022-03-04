package com.gameoflifethreads;

import java.util.ArrayList;

public class Grid {

    private int count;
    private int ROWS;
    private int COLS;
    private char[][] arr;
    private Cell[][] cells;

    public Grid() {
    }

    public char[][] createArray( int rows,int cols ) {
        ROWS = rows;
        COLS = cols;

        arr = new char[ROWS + 2][COLS + 2];
        cells = new Cell[ROWS + 2][COLS + 2];

        for (int j = 0; j < arr.length; j++) {
            for (int k = 0; k < arr[0].length; k++) {
                cells[j][k] = new Cell();
            }
        }
        return arr;
    }

    public void printFirst() {
        for (int i = 1; i < arr.length - 1; i++) {
            for (int j = 1; j < arr[0].length - 1; j++) {
                if (arr[i][j] == 'O') {
                    System.out.print('.');
                } else {
                    System.out.print(arr[i][j]);
                }
            }
            System.out.print('\n');
        }

        System.out.println("first generation");

        System.out.println("********************");
    }

    public void updateGrid( int gens ) throws InterruptedException {

        for (int i = 0; i < gens; i++){
            ArrayList<CellGen> threadPath = new ArrayList<>();
            
            count = 0;

            for (int j = 1; j < arr.length - 1; j++){
                for (int k = 1; k < arr[0].length - 1; k++){
                    threadPath.add(new CellGen(arr, cells[j][k], j, k));
                    threadPath.get(count).start();
                    count++;
                }
            }

            count = 0;

            for (int j = 1; j < arr.length - 1; j++){
                for (int k = 1; k < arr[0].length - 1; k++){
                    threadPath.get(count).t.join();
                    count ++;
                }
            }

            for (int n = 0; n < arr.length; n++) {
                for (int m = 0; m < arr[0].length; m++) {
                    if ( cells[n][m].getState(true) )
                        arr[n][m] = 'X';
                    else
                        arr[n][m] = 'O';
                }
            }
        }
    }

    void printGrid( int gens ) {
        for (int i = 1; i < arr.length - 1; i++) {
            for (int j = 1; j < arr[0].length - 1; j++) {
                if (arr[i][j] == 'O') {
                    System.out.print('.');
                } else {
                    System.out.print(arr[i][j]);
                }
            }
            System.out.print('\n');
        }

        System.out.println("generations: " + gens);

        System.out.println("********************");
    }
}
