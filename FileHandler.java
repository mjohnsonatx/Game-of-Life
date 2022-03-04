package com.gameoflifethreads;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FileHandler implements IFileHandler {

    private String pathname;
    private Scanner scanner;
    private char[][] arr1;
    private int gens;

    public FileHandler( String path ) {
        pathname = path;
    }

    public void createScanner() throws IOException {
        scanner = new Scanner(new File(pathname));
    }

    public char[][] readFile ( char[][] arr ) {

        arr1 = arr;

        for (int i = 0; i < 20; i++) {
            char[] chars = scanner.nextLine().toCharArray();
            for (int j = 0; j < 20; j++) {
                arr1[i + 1][j + 1] = chars[j];
            }
        }

        return arr1;
    }

    public int readGens () {
        gens = scanner.nextInt();
        scanner.close();
        return gens;
    }
}
