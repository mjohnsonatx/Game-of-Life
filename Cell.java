package com.gameoflifethreads;

public class Cell implements ICell {
    private boolean state;

    public Cell() {
        state = false;
    }

    public boolean getState(boolean b) {
        return state;
    }

    public void setState(boolean s) {
        state = s;
    }
}
