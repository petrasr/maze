package org.example.reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ConsoleMaze extends AbstractMaze {

    public ConsoleMaze() {
        String fileText = "";
        try (Scanner input = new Scanner(System.in)) {
            while (input.hasNextLine()) {
                fileText += input.nextLine() + "\n";
            }
        }
        initializeMaze(fileText);
    }
}
