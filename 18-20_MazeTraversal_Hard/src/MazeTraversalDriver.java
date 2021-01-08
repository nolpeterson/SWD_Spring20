import java.util.Scanner;

/**
 * Driver program to run MazeTraversal
 */
public class MazeTraversalDriver {
    /**
     * The entry point of application.
     * @param args the input arguments
     */
    public static void main(String[] args) {
        //Input scanner and variables
        Scanner input = new Scanner(System.in);
        Maze myMaze = new Maze();
        int row, col;

        //Display welcome message and show the maze
        System.out.println("-Maze Solver-\nCurrent Maze:");
        myMaze.printMaze();
        System.out.println();

        //Get row from user
        System.out.print("Please enter starting row (1-12): ");
        row = input.nextInt();

        //Get column from user
        System.out.print("Please enter starting column (1-12): ");
        col = input.nextInt();

        //Solve the maze, and return a true or false result if solved
        boolean solved = MazeTraversal.solve(myMaze, row - 1, col - 1);

        //Print out final version of maze
        System.out.println();
        myMaze.printMaze();
        System.out.println();

        //Print out final message if maze was solved or not
        if (solved) {
            System.out.println("Maze solved!");
        }
        else {
            System.out.println("Not able to solve!");
        }
    }
}
