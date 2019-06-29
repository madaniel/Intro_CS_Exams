package Practice;

/**
 * If you understand these problems and can solve them by yourself, you are ready to solve exam level problems
 */
public class HardRecursionProblems {

    /**
     * We need to find a path in int positive matrix
     * The matrix should include numbers which can summed to target number using neighbour cells from up, down, right or left.
     * The path is matrix with 0 in same dimension of the input matrix.
     * We need to mark with 1 the path of the sum in the input matrix.
     *
     * The complexity in this question is to reach 2 problems at once: scan the matrix and finding a sum
     * So, we'll use 2 recursive methods: one to scan each cell of the matrix and one to find the sum.
     *
     * @param mat matrix of positive number
     * @param sum target sum to find in matrix
     * @param path matrix of 0 to mark the path of sum with 1
     * @return true - if sum found false - sum not found in matrix
     */
    public static boolean findSum (int [][] mat, int sum, int [][] path){
        return findSumIterator(mat, path, sum, 0, 0);
    }

    /**
     * Triggers findSum for each matrix cell in recursion
     *
     * @param mat matrix of positive number
     * @param path matrix of 0 to mark the path of sum with 1
     * @param sum target sum to find in matrix
     * @param x index of column in matrix
     * @param y index of line in matrix
     * @return true - if sum found false - sum not found in matrix
     */
    private static boolean findSumIterator(int [][] mat, int [][] path, int sum, int x, int y){
        if(x > mat[0].length-1 || y > mat.length-1)
            return false;

        if(findSum(mat, path, sum, x, y))
            return true;

        return findSumIterator(mat, path, sum, x+1, y) || findSumIterator(mat, path, sum, x, y+1);
    }

    /**
     * Search in recursion over the matrix for numbers which summed to sum argument
     * Recursion starts from x and y arguments
     *
     * @param mat matrix of positive number
     * @param path matrix of 0 to mark the path of sum with 1
     * @param sum target sum to find in matrix
     * @param x index of column in matrix
     * @param y index of line in matrix
     * @return true - if sum found false - sum not found in matrix
     */
    private static boolean findSum(int [][] mat, int [][] path, int sum, int x, int y){
        // Stop condition - we've reached outside the matrix dimension or encountered in visited cell
        if(sum < 0 || x < 0 || y < 0 || x > mat[0].length-1 || y > mat.length-1 || path[y][x]==1)
            return false;

        // Sum was found
        if(sum == 0)
            return true;

        // Tag this cell as visited
        path[y][x] = 1;

        if(x < mat[0].length-1 && findSum(mat, path, sum - mat[y][x], x + 1, y))
            return true;

        else if(y < mat.length-1 && findSum(mat, path, sum - mat[y][x], x, y + 1))
            return true;

        else if(y > 0 && findSum(mat, path, sum - mat[y][x], x, y - 1))
            return true;

        else if(x > 0 && findSum(mat, path, sum - mat[y][x], x - 1, y))
            return true;

        else
            path[y][x] = 0;

        return false;
    }

    public static void main(String[] args) {

        int [][] test1 = {{3, 6, 7}, {20, 20, 20}, {10, 2, 3}};
        int [][] test2 = {{3, 6, 7}, {20, 20, 20}, {10, 6, 6}};
        int [][] test3 = {{3, 6, 7}, {4, 20, 20}, {1, 6, 6}};

        int [] [] path = new int[3][3];
        System.out.println(findSum(test1, 5, path));  // path will be look like {{0, 0, 0}, {0, 0, 0}, {0, 1, 1}}
        path = new int[3][3];
        System.out.println(findSum(test2, 5, path));  // path will be look like {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}}
        path = new int[3][3];
        System.out.println(findSum(test3, 5, path));  // path will be look like {{0, 0, 0}, {1, 0, 0}, {1, 0, 0}}
    }
}
