package com.gameoflifethreads;

import java.util.Objects;

public class CellGen implements Runnable {

    private char[][] arr;
    private Cell cell;
    private int alive = 0;
    private int r;
    private int c;
    public Thread t;

    public CellGen( char[][] arr1, Cell cell1, int row, int col ) {
        arr = arr1;
        cell = cell1;
        r = row;
        c = col;
    }

    public void start() {
        t = new Thread(this);
        t.start();
    }

    public void run() {

        if (Objects.equals(arr[r - 1][c - 1], 'X')) alive++;
        if (Objects.equals(arr[r - 1][c], 'X')) alive++;
        if (Objects.equals(arr[r - 1][c + 1], 'X')) alive++;
        if (Objects.equals(arr[r][c - 1], 'X')) alive++;
        if (Objects.equals(arr[r][c + 1], 'X')) alive++;
        if (Objects.equals(arr[r + 1][c - 1], 'X')) alive++;
        if (Objects.equals(arr[r + 1][c], 'X')) alive++;
        if (Objects.equals(arr[r + 1][c + 1], 'X')) alive++;

        if (Objects.equals(arr[r][c], 'X')) {
            if (alive < 2) cell.setState(false);
            else if ((alive == 2) || (alive == 3)) cell.setState(true);
            else cell.setState(false);
        } else {
            if (alive != 3) {
                cell.setState(false);
            } else {
                cell.setState(true);
            }
        }
        alive = 0;
    }
}
