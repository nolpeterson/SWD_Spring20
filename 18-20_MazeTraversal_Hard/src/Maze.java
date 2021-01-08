/**
 * Maze - Object that holds the char[][] maze, get/set methods for chars, and print method.
 */
public class Maze {
    /**
     * The 2D char array representation of the maze.
     */
    private final char[][] maze = {
            {'#','#','#','#','#','#','#','#','#','#','#','#'},
            {'#','.','.','.','#','.','.','.','.','.','.','#'},
            {'.','.','#','.','#','.','#','#','#','#','.','#'},
            {'#','#','#','.','#','.','.','.','.','#','.','#'},
            {'#','.','.','.','.','#','#','#','.','#','.','.'},
            {'#','#','#','#','.','#','.','#','.','#','.','#'},
            {'#','.','.','#','.','#','.','#','.','#','.','#'},
            {'#','#','.','#','.','#','.','#','.','#','.','#'},
            {'#','.','.','.','.','.','.','.','.','#','.','#'},
            {'#','#','#','#','#','#','.','#','#','#','.','#'},
            {'#','.','.','.','.','.','.','#','.','.','.','#'},
            {'#','#','#','#','#','#','#','#','#','#','#','#'},};

    /**
     * Returns the current char T given (row, col) position of maze.
     * @param row the row
     * @param col the column
     * @return the char value at given position
     */
    public char getPositionChar(int row, int col) {
        return (maze[row][col]);
    }

    /**
     * Sets a given char at given (row, col) in maze.
     * @param row the row
     * @param col the column
     * @param myChar the char to set at given position
     */
    public void setPositionChar(int row, int col, char myChar) {
        maze[row][col] = myChar;
    }

    /**
     * Prints the entire maze.
     */
    public void printMaze() {
        for (int i = 0; i < 12; i++)
        {
            for (int j = 0; j < 12; j++)
            {
                System.out.print(maze[i][j] + " ");
            }
            System.out.println();
        }
    }
}
