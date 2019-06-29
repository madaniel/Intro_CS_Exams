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
     * @param y position of the rat in column
     * @param x position of the rat in row
     * @param m size of row
     * @param n size of column
     * @param maze matrix of the maze
     * @return number of paths
     */
    public static int mazeRat(int y, int x, int m, int n, int[][] maze){

        // the rat has reached out of bounds or reached a block cell - the path is not counted
        if(y == m || x == n || maze[y][x] == -1)
            return 0;

        // The rat has reached the final cell in the maze
        if(y == m - 1 && x == n - 1)
            return 1;

        // Since the rat has 2 directions, we need to return result of 2 calls each time
        return mazeRat(y + 1, x, m, n, maze) + mazeRat(y, x + 1, m, n, maze);
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

    /**
     * Return the minimum number of calculation required to get from x to y
     * Operation permitted: x + 1 or x * 2
     * @param x start number
     * @param y stop number
     * @return minimum number of operations
     */
    public static int minOperation(int x, int y){
        // Stop condition
        if(x >= y)
            return 0;

        int way1 = minOperation(x + 1, y) + 1;
        int way2 = minOperation(x * 2, y) + 1;

        return Math.min(way1, way2);
    }

    /**
     * Anagram = word with the same letters but not necessarily in the same order
     * For example: abcd <-> dcab are Anagram but abbd <-> dbca are not Anagram because they don't have the same letters
     *
     * This problem is a Backtracking problem variant of "collect" or "not collect" decision
     *
     * @param word1 string 1
     * @param word2 string 2
     * @return true - words are Anagram of each other, false - not Anagram
     */
    public static boolean isAnagram(String word1, String word2){
        // Check - both words must to be in the same length
        if(word1.length() != word2.length())
            return false;

        // Stop condition - bot words are empty
        // Since both words are in the same length (last condition) so we check only one word
        if(word1.length() == 0)
            return true;

        // We use charAt and indexOf to search the first letter in word1 in word2
        char word1FirstLetter = word1.charAt(0);
        int indexFoundInWord2 = word2.indexOf(word1FirstLetter);

        // First letter in word1 is not found in word2
        if(indexFoundInWord2 < 0) // -1 value means not found
            return false;

        // First letter is found - we need to proceed
        // In the next call - we omit the first letter from word1 and the same letter from word2
        // We cut word2 into 2 slices: from 0 to the found letter (excluded) and from the letter + 1 until the end
        return isAnagram(word1.substring(1), word2.substring(0, indexFoundInWord2) + word2.substring(indexFoundInWord2 + 1));
    }

    /**
     * We compare two strings with usage of * as a wildcard char in the second word
     * The second word may contain more than one * but not one after the other (**)
     *
     * @param word1 string1
     * @param word2 string2 to compare with *
     * @return true - 2 strings match, false - 2 strings not match
     */
    public static boolean samePattern(String word1, String word2){

        boolean word1IsEmpty = word1.length() == 0;
        boolean word2IsEmpty = word2.length() == 0;
        boolean word2IsAsterisk = word2.length() == 1 && word2.charAt(0) == '*';

        // Stop condition - word 1 is empty - no more letters to check and also word 2 is empty
        if(word1IsEmpty){
            if(word2IsEmpty || word2IsAsterisk)
                return true;
            // else - word2 is not empty and still has char to compare
            return false;
        }

        // Both char equals - process with both words to the next char
        if(word1.charAt(0) == word2.charAt(0))
            return samePattern(word1.substring(1), word2.substring(1));

        // Chars are not equal (above condition), and char in second word is not *
        if(word2.charAt(0) != '*')
            return false;

        // Char in word2 is * - we proceed to the next char in word2 until its end
        if (samePattern(word1.substring(1), word2))
            return true;

        // Word2 remained with chars after the * - so we proceed without the *
        return samePattern(word1, word2.substring(1));
    }

    /**
     * We need to find and print all the possible sum of three numbers of a target number
     * Each number in the sum should be 1 <= x <= 10
     * For example: for number 3 there's a single sum: 1 + 1 + 1 = 3
     * @param num target number
     * @return number of possible sums
     */
    public static int threeSum(int num){
        return threeSum(num, 1, 1, 1, 0 );

    }

    private static int threeSum(int num, int x1, int x2, int x3, int counter) {

        // Base case - all three numbers summed into target number
        if (x1 + x2 + x3 == num) {
            System.out.println(x1 + " + " + x2 + " + " + x3);
            counter++;
        }

        if (x1 == 10) {
            if (x2 == 10) {
                if (x3 == 10)  // All Xs have reached 10 - we cannot proceed
                    return counter;

                else // X1 and X2 have reached 10, incrementing x3 by 1
                    return threeSum(num, 1, 1, x3 + 1, counter);}

            else  // X1 have reached 10 but not X2, incrementing x2 by 1
                return threeSum(num, 1, x2 + 1, x3, counter);}

        else // X1 have not reached 10, incrementing x1 by 1
           return threeSum(num, x1 + 1, x2, x3, counter);
    }

    /**
     * Here you can test the function above with debugger and see how it works     *
     */
    public static void main(String[] args) {

        int [] [] maze1 = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}}; // Will return 6
        System.out.println("mazeRat1=" + mazeRat(0, 0, maze1.length, maze1[0].length, maze1));

        int [] [] maze2 = {{0, 0, 0}, {0, 0, 0}, {0, -1, 0}}; // Will return 3
        System.out.println("mazeRat2=" + mazeRat(0, 0, maze2.length, maze2[0].length, maze2));

        // Example for collect - result should be 79 {collect(34), skipped, collect(20), skipped, skipped, collected(26)}
        int [] collection = {33, 10, 20, 5, 14, 26};
        System.out.println("Collect=" + collect(0, collection.length, collection));

        System.out.println("minOperation=" + minOperation(10, 22)); // Will return 2 -> (10 + 1 * 2)

        System.out.println("isAnagram=" + isAnagram("abcd", "dcab"));  // Will return true
        System.out.println("isAnagram=" + isAnagram("abcd", "abbd"));  // Will return false
        System.out.println("isAnagram=" + isAnagram("abcd", "abc"));  // Will return false
        System.out.println("isAnagram=" + isAnagram("abcd", "dabc"));  // Will return true

        System.out.println("threeSum of number 1: " + threeSum(3));
        System.out.println("threeSum of number 5: " + threeSum(5));
    }
}
