package Practice;

/**
 * After understanding how Recursion works, you can look on more complex problems of Recursion
 *
 */
public class MediumRecursionProblems {


    /**
     * This problem may slightly differs with similar variation, but the principal is the same.
     * We get as an input 2D Matrix of int which contain 2 kinds of numbers (mostly 0 and 1)
     * In this example we represent the 0 as "flooded" cells and the 1 as "un-flooded" cell
     * The task is to flood all the cells in the matrix using recursion.
     *
     * @param x line in the matrix
     * @param y row in the matrix
     * @param m size of the the column
     * @param n size of the row
     * @param grid matrix of the cells
     */
    public static void floodFill(int x, int y, int m, int n, int[][] grid){

        // Stop condition - we've reached the boundaries of the matrix or we've reached a flooded cell
        if(x < 0 || y < 0 || x >= n || y >= m || grid[y][x] == 0)
            return;

        // Else - we flood the cell
        grid[y][x] = 0;

        // We call recursively to the four directions
        floodFill(x - 1, y, m, n, grid);
        floodFill(x, y - 1, m, n, grid);
        floodFill(x, y + 1, m, n, grid);
        floodFill(x + 1, y, m, n, grid);
    }

    /**
     * Maze rat is a family of problems which varies from problem to another.
     * This is a simple version of the problem, we need to return the number of paths from entrance to exit.
     * The entrance will be the most upper left cell and the exit will be the most lower right cell.
     * The rat may go only to 2 directions (Down and Right) and there're blocks in the maze which he cannot pass through.
     *
     * @param i position of the rat in column
     * @param j position of the rat in row
     * @param m size of row
     * @param n size of column
     * @param Maze matrix of the maze
     * @return number of paths
     */
    public static int mazeRat(int i, int j, int m, int n, int[][]Maze){

        // the rat has reached out of bounds or reached a block cell - the path is not counted
        if(i < 0 || j < 0 || i == m || j == n || Maze[i][j] == -1)
            return 0;

        // The rat has reached the final cell in the maze
        if(i == m - 1 && j == n - 1)
            return 1;

        // Since the rat has 2 directions, we need to return result of 2 calls each time
        return mazeRat(i + 1, j, m, n, Maze) + mazeRat(i, j + 1, m, n, Maze);
    }

    /**
     * collect problem is also a variant of similar problems.
     * We've given an array of int, which we need to maximize the numbers collected from it, following specific rules.
     * In our example, the rules are: either to collect current cell and to skip the next cell OR to move to the next cell.
     * The result should be the max collection (sum of cells values) using these restrictions.
     * @param i index on the array
     * @param n size of the array
     * @param array target array
     * @return max collection possible
     */
    public static int collect(int i, int n, int[] array){

        // Stop condition - we passed the array boundaries
        if(i >= n)
            return 0;

        // Because we have 2 options to proceed: collecting current cell and skipping 2 cells or to move to next one, so we need 2 recursive calls
        int collecting = array[i] + collect(i + 2, n, array);
        int skipping = collect(i + 1, n, array);

        return Math.max(collecting, skipping);
    }


    public static void main(String[] args) {

        // Example for Maze Rat - should return 3
        int [] [] maze = {{0, 0, 0, 0, -1}, {0, -1, 0, 0, 0}, {0, 0, 0, 0, 0}, {-1, 0, 0, 0, 0}};
        System.out.println("mazeRat=" + mazeRat(0, 0, maze[0].length-1, maze.length-1, maze));

        // Example for collect - result should be 79 {collect(34), skipped, collect(20), skipped, skipped, collected(26)}
        int [] collection = {33, 10, 20, 5, 14, 26};
        System.out.println("Collect=" + collect(0, collection.length, collection));

    }

}
