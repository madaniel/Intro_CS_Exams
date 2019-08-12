package Question1;

public class Exam2016 {

    /**
     * Question 2016a A2 83
     * @param m matrix of numbers
     * @return min number to cross the matrix
     */
    public static int minPoints(int [][] m){
        return minPoints(m, 0, 0, 0, 0);
    }

    /**
     * We sum numbers from upper left to lower right, keeping the sum positive all the way.
     * In case we get negative number, we add 1 - num to sum to keep it positive at minimum possible (1)
     * For example: to make -5 positive we add (1 - (-5)) = 6 so we get 1 = minimum positive number
     * @param m matrix of positive and negative numbers
     * @param row index of row
     * @param col index of column
     * @param num current number to start from upper left
     * @param sum current sum of numbers on path
     * @return
     */
    private static int minPoints(int [][] m, int row, int col, int num, int sum){
        // Stop condition
        if(row > m.length-1 || col > m[0].length-1)
            return Integer.MAX_VALUE;

        sum += m[row][col];

        if(sum < 0)
            num = 1 - sum;

        // We've reached the end of the matrix
        if(row == m.length-1 && col == m[0].length-1)
            return num;

        int path1 = minPoints(m, row + 1, col, num, sum);
        int path2 = minPoints(m, row, col+1, num, sum);

        return Math.min(path1, path2); // both paths are positive, we take the minimal
    }

    public static void main(String[] args) {
        int [][] mat = {{-2, -3, 3}, {-5, -10, 1}, {10, 30, -5}};
        System.out.println(minPoints(mat));
    }


}
