package Question1;

public class Exam2019 {

    /**
     * Question 2019B 83
     * @param mat matrix of 0 and 1
     * @param x row of target cell
     * @param y col of target cell
     * @return longest path to reach the target cell from the [0,0]
     */
    public static int longestPath(int [][] mat, int x, int y){
        return longestPath(mat, x, y, 0, 0, 0);
    }

    public static int longestPath(int [][] mat, int x, int y, int row, int col, int counter){
        // Stop condition - cell non relevant or outside of the matrix
        if(!isValid(mat, row, col) || mat[row][col] == 0)
            return 0;

        counter++;

        mat[row][col] = 0;

        if(col == y && row == x)
            return counter;

        int left = longestPath(mat, x, y, row, col-1, counter);
        int up = longestPath(mat, x, y, row-1, col, counter);
        int down = longestPath(mat, x, y, row+1, col, counter);
        int right = longestPath(mat, x, y, row, col+1, counter);

        mat[row][col] = 1;

        return Math.max(Math.max(up, down), Math.max(left, right));
    }

    private static boolean isValid(int [][] mat, int row, int col){
        return row >= 0 && col >= 0 && row < mat.length && col < mat[0].length;
    }


    /**
     * Question 2019A b 478
     * @return number of sub-sequences
     */
    public static int count(String str, String pattern){
        return count(str, 0, pattern, 0);
    }

    private static int count(String str, int strIndex, String pattern, int ptrIndex){
        // Stop condition
        if(ptrIndex > pattern.length()-1)
            return 1;  // Pattern scan had complete so we've found a match

        if(strIndex > str.length() -1 && ptrIndex <= pattern.length() -1)
            return 0; // String scan had completed but pattern not so we didn't find a match

        int way1 = 0, way2 = 0;

        // We found a matched char - we proceed with both indexes
        if(str.charAt(strIndex) == pattern.charAt(ptrIndex))
            way1 = count(str, strIndex+1, pattern, ptrIndex+1);

        // We didn't find a match - we proceed only with string index
        way2 = count(str, strIndex+1, pattern, ptrIndex);

        return way1 + way2;
    }

    /**
     * Here you can test the function above with debugger and see how it works     *
     */
    public static void main(String[] args) {
        int [][] mat = {{1, 1, 1, 1, 1, 1, 1},
                        {1, 1, 0, 1, 0, 0, 1},
                        {1, 1, 1, 1, 0, 1, 1}};
        System.out.println(longestPath(mat, 2, 5));


        System.out.println(count("abcd", "abcd")); // Should return 1
        System.out.println(count("abcdc", "ac")); // Should return 2
        System.out.println(count("abcddd", "abd")); // Should return 3
    }
}
