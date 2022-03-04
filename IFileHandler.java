package com.gameoflifethreads;

import java.io.IOException;

public interface IFileHandler {
    public void createScanner() throws IOException;
    public char[][] readFile ( char[][] arr );
    public int readGens ();
}
