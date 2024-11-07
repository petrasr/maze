package maze;

import org.example.maze.BFSMazeSolver;
import org.example.maze.ConsoleMaze;
import org.example.maze.FileMaze;
import org.example.models.Coordinate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

public class MazeTest {

    @Test
    public void testFileMazeSuccessPath() {
        try {
            File file = new File("src/main/resources/maze/maze2.txt");
            FileMaze maze = new FileMaze(file);
            BFSMazeSolver bfs = new BFSMazeSolver();
            List<Coordinate> path = bfs.solve(maze);
            maze.printPath(path);
            Assertions.assertFalse(path.isEmpty());
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testFileMazeErrorPath() {
        try {
            File file = new File("src/main/resources/maze/maze_error.txt");
            FileMaze maze = new FileMaze(file);
            BFSMazeSolver bfs = new BFSMazeSolver();
            List<Coordinate> path = bfs.solve(maze);
            maze.printPath(path);
            Assertions.assertTrue(path.isEmpty());
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testConsoleMazeSuccessPath() {
        String mazeString =
                ".S.#######\n" +
                "#........#\n" +
                "#.###.##.#\n" +
                "#.#....#.#\n" +
                "#.#..#.#.#\n" +
                "#.##.#####\n" +
                "#.#......#\n" +
                "#.#.#..#.#\n" +
                "########.#\n" +
                "#...#....X\n" +
                "#.#....#.#\n" +
                "##########";
        ConsoleMaze maze = new ConsoleMaze(mazeString);
        BFSMazeSolver bfs = new BFSMazeSolver();
        List<Coordinate> path = bfs.solve(maze);
        maze.printPath(path);
        Assertions.assertFalse(path.isEmpty());
    }

    @Test
    public void testConsoleMazeErrorPath() {
        String mazeString =
                ".S.#######\n" +
                "#........#\n" +
                "#.###.##.#\n" +
                "#.#....#.#\n" +
                "#.#..#.#.#\n" +
                "#.##.#####\n" +
                "#.#......#\n" +
                "#.#.#..#.#\n" +
                "##########\n" +
                "#...#....X\n" +
                "#.#....#.#\n" +
                "##########";
        ConsoleMaze maze = new ConsoleMaze(mazeString);
        BFSMazeSolver bfs = new BFSMazeSolver();
        List<Coordinate> path = bfs.solve(maze);
        maze.printPath(path);
        Assertions.assertTrue(path.isEmpty());
    }
}
