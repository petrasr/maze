package org.example.maze;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileMaze extends AbstractMaze {

    public FileMaze(File maze) throws FileNotFoundException {
        String fileText = "";
        try (Scanner input = new Scanner(maze)) {
            while (input.hasNextLine()) {
                fileText += input.nextLine() + "\n";
            }
        }
        initializeMaze(fileText);
    }
}
