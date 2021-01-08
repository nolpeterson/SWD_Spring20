/**
 * Class that solves a given maze.
 */
public class MazeTraversal {
    /**
     * Boolean that is returned whether or not the maze is solved.
     */
    private static boolean solved;
    /**
     * The starting row of the maze, used for comparisons.
     */
    private static int startingRow;
    /**
     * The starting column of the maze, used for comparison.
     */
    private static int startingCol;

    /**
     * Recursive method that solves the maze at a given position
     * @param myMaze the given maze
     * @param row the row to try to solve at
     * @param col the column to try to solve at
     * @return true or false depending on if there exists a solution to the maze
     */
    public static boolean solve(Maze myMaze, int row, int col) {
        System.out.println();
        myMaze.printMaze();

        //Check for starting area
        boolean startingPosition = (startingRow == row) && (startingCol == col);

        //Only set maze as finished if not at the beginning
        //Set to 11 to avoid indexOutOfBounds
        if (!startingPosition && (col == -1 || col == 11)) {
            solved = true;
            myMaze.setPositionChar(row, col, 'x');
        }

        //Determine if the maze is solvable or unsolvable as recursion base case
        if (!startingPosition && solved) {
            return (true);
        }
        else if (startingPosition && solved) {
            return (false);
        }

        //Try to move down
        if (row < 11 && myMaze.getPositionChar(row + 1, col) == '.' ) {
            myMaze.setPositionChar(row, col, 'x');
            solve(myMaze, row + 1, col);
        }
        //Try to move right
        else if (col < 11 && myMaze.getPositionChar(row, col + 1) == '.') {
            myMaze.setPositionChar(row, col, 'x');
            solve(myMaze, row, col + 1);
        }
        //Try to move up
        else if (row > 0 && myMaze.getPositionChar(row - 1, col) == '.') {
            myMaze.setPositionChar(row, col, 'x');
            solve(myMaze, row - 1, col);
        }
        //Try to move left
        else if (col > 0 && myMaze.getPositionChar(row, col - 1) == '.') {
            myMaze.setPositionChar(row, col, 'x');
            solve(myMaze, row, col - 1);
        }
        //If no move is possible, mark the current position
        else {
            myMaze.setPositionChar(row, col, 'x');
        }

        //Backtracking, which marks "dead ends" with an "o"
        if (!solved) {
            //Backtrack down
            if (row < 11 && myMaze.getPositionChar(row + 1, col) == 'x') {
                myMaze.setPositionChar(row, col, 'o');
                solve(myMaze, row + 1, col);
            }
            //Backtrack right
            else if (col < 11 && myMaze.getPositionChar(row, col + 1) == 'x') {
                myMaze.setPositionChar(row, col, 'o');
                solve(myMaze, row, col + 1);
            }
            //Backtrack up
            else if (row > 0 && myMaze.getPositionChar(row - 1, col) == 'x') {
                myMaze.setPositionChar(row, col, 'o');
                solve(myMaze, row - 1, col);
            }
            //Backtrack left
            else if (col > 0 && myMaze.getPositionChar(row, col - 1) == 'x'){
                myMaze.setPositionChar(row, col, 'o');
                solve(myMaze, row, col - 1);
            }
        }

        //Return statement to avoid missing error
        return (solved);
    }
}
