package Question1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Exam2017 {

    /**
     * Question 2017b A4 85
     * @param n target number
     * @return min addition required to target number
     */
    public static int oneFiveSeven(int n){
        return oneFiveSeven(n, 0, 0);
    }

    /**
     * Simple min function since Math.min is prohibited in this question
     * @param num1
     * @param num2
     * @param num3
     * @return
     */
    private static int min(int num1, int num2, int num3){
        int tmpMin = num1 < num2 ? num1 : num2;
        tmpMin = tmpMin < num3 ? tmpMin : num3;

        return tmpMin;
    }

    private static int oneFiveSeven(int n, int currentNum, int counter){
        // Stop condition - number is larger - we set an oversize number which will fail in the minimum check
        if(currentNum > n)
            return currentNum;

        // We've found a match
        if (currentNum == n)
            return counter;

        // We try the 3 possible ways
        int way1 = oneFiveSeven(n, currentNum + 1, counter +1);
        int way2 = oneFiveSeven(n, currentNum + 5, counter +1);
        int way3 = oneFiveSeven(n, currentNum + 7, counter +1);

        return min(way1, way2, way3);
    }

    /**
     * Question 2017b A3 84
     * @param k steps allowed
     * @param n target number
     * @return number of ways to get to n using k steps
     */
    public static int ways(int k, int n){
        // Stop conditions
        if(k == 0 && n == 0)
            return 1; // Found a way

        if(k == 0)
            return 0; // Did not find a way

        int stepRight = ways(k-1, n-1); // Decreasing the distance - moving toward number n
        int stepLeft = ways(k-1, n+1);  // Increasing the distance - moving backward number n
        return  stepLeft + stepRight;
    }

    /**
     * Question 2017a A5 86
     * @param str1 string 1
     * @param str2 string 2
     * @return number of insertion and removal needed
     */
    public static int edit(String str1, String str2){
        // Stop condition - both string are empty
        if(str1.length() == 0 && str2.length()==0)
            return 0;

        // All chars in other string will be need to be add
        if(str1.length() == 0)
            return str2.length();

        // All chars in other string will be need to be add
        if(str2.length() == 0)
            return str1.length();

        // Both chars are equal, continue to next char in string
        if(str1.charAt(0) == str2.charAt(0))
            return edit(str1.substring(1), str2.substring(1));

        int way1 = 1 + edit(str1.substring(1), str2);
        int way2 = 1 + edit(str1, str2.substring(1));

        return Math.min(way1, way2);
    }

    /**
     * Question 2017a A6 87
     * @param mat matrix of positive numbers
     * @param arr array of numbers to check
     * @param k number of rows to check
     * @return true - match found false - not found
     */
    public static boolean covers(int [][] mat, int [] arr, int k){

        // Copy arr to allow modification later
        int [] copyArr = new int[arr.length];
        copy(copyArr, arr);

        return covers(mat, copyArr, k, 0);
    }

    public static boolean covers(int [][] mat, int [] arr, int k, int y){
        // Stop condition - end of matrix or all allowed rows checked
        if(k==0 || y > mat.length-1)
            return false;

        // Mark 0 in matched numbers in current row in matrix
        xZero(arr, mat[y]);

        // Found a match
        if(allZero(arr))
            return true;

        return covers(mat, arr, k-1, y+1) || covers(mat, arr, k , y+1);
    }

    /**
     * Given as util in the exam - NO NEED TO IMPLEMENT !
     * Return true if all numbers in array x is 0
     *
     * @param x array of numbers
     * @return true - all numbers in array are zero
     */
    private static boolean allZero(int [] x){
        return IntStream.of(x).sum() == 0;
    }

    /**
     * Given as util in the exam - NO NEED TO IMPLEMENT !
     * Copy all numbers from array src to array dest
     *
     * @param dest - target array
     * @param src - source array
     */
    private static void copy(int [] dest, int [] src){
        System.arraycopy(src, 0, dest, 0, src.length);
    }

    /**
     * Given as util in the exam - NO NEED TO IMPLEMENT !
     * Reset to 0 all the numbers in array x which exist in array y
     *
     * @param x - target array
     * @param y - source array
     */
    public static void xZero(int [] x, int [] y){
        List<Integer> yList = Arrays.stream(y).boxed().collect(Collectors.toList());

        for(int i=0; i <y.length; i++)
            if(yList.contains(x[i]))
                x[i] = 0;
    }

    /**
     * Question 2017a B1 90
     *
     * @param items Item objects with value and weight
     * @param w Weight of the knapsack     *
     * @return
     */
    public static int knapSack(Item[] items, int w){
        return knapSack(items, w, 0, 0);
    }

    private static int knapSack(Item[] items, int w, int idx, int value){
        // Stop condition - we overweight, so discard the value
        if(w < 0)
            return 0;

        // We've reached the end of the array, return the value accumulated
        if(idx > items.length-1)
            return value;

        // We try to pickup the value
        int way1 = knapSack(items, w-items[idx].getWeight(), idx +1, value+items[idx].getValue());
        // We try to skip this value
        int way2 = knapSack(items, w, idx +1, value);

        return Math.max(way1, way2);
    }

    /**
     * 2017B B4 93
     * @param mat matrix of 0 / 1
     * @return number of islands of 1 on the matrix
     */
    public static int cntTrueReg(boolean [][] mat){
        return cntTrueReg(mat, 0, 0);
    }

    private static int cntTrueReg(boolean [][] mat, int row, int col){
        // Stop condition
        if(!isValid(mat, row, col))
            return 0;

        // We found 1, reset all 1 island and add 1 to counter
        if(mat[row][col]){
            floodFill(mat, row, col);
            return 1;}

        return cntTrueReg(mat, row, col+1) + cntTrueReg(mat, row+1, col);
    }

    private static boolean isValid(boolean [][] mat, int row, int col){
        return row >= 0 &&  row < mat.length && col >= 0 && col < mat[0].length;
    }

    private static void floodFill(boolean [][] mat, int row, int col){
        // Stop condition
        if(!isValid(mat, row, col) || ! mat[row][col])
            return;

        mat[row][col] = false;

        floodFill(mat, row+1, col);
        floodFill(mat, row, col+1);
        floodFill(mat, row-1, col);
        floodFill(mat, row, col-1);
    }

    /**
     * Here you can test the function above with debugger and see how it works     *
     */
    public static void main(String[] args) {
        System.out.println(oneFiveSeven(10)); // 2
        System.out.println(oneFiveSeven(5)); // 2
        System.out.println(oneFiveSeven(6)); // 2


        Item [] items = {new Item(10, 60), new Item(20, 100), new Item(30, 120), new Item(15, 200)};
        System.out.println(knapSack(items, 30)); // 260
        System.out.println(knapSack(items, 50)); // 360
        int [][] mat = {{1, 5, 7}, {3, 2, 9}, {1, 2, 8}};
        int [] arr = {1, 2, 8};
        System.out.println(covers(mat, arr, 1)); // true
        System.out.println(edit("abcd", "abcxd")); // 1
        System.out.println(edit("sunday", "saturday")); // 4
        System.out.println(ways(4, 2)); // 4

        boolean [] [] matB = {{false, false, false, false, true},
                            {false, true, true, true, false},
                            {false, false, true, true, false},
                            {true, false, false, false, false},
                            {true, true, false, false, false}};
        System.out.println(cntTrueReg(matB));
    }

}
