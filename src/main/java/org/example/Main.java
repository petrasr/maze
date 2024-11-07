package org.example;

import org.example.reader.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Maze from file (F) or maze from console (C)");
        Scanner scanner = new Scanner(System.in);
        String option = scanner.nextLine();
        AbstractMaze maze = null;
        if (option.toLowerCase().contains("f")) {
            try {
                File file = new File("src/main/resources/maze/maze2.txt");
                maze = new FileMaze(file);
            } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("Please draw your maze");
            maze = new ConsoleMaze();
        }
        if (maze != null) {
            BFSMazeSolver bfs = new BFSMazeSolver();
            List<Coordinate> path = bfs.solve(maze);
            maze.printPath(path);
            maze.printPathDirection(path);
            System.out.printf("Path: %s\n", path);
            maze.reset();
        }
    }
}