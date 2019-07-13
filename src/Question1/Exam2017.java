package Question1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Exam2017 {

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
     * Here you can test the function above with debugger and see how it works     *
     */
    public static void main(String[] args) {
        int [][] mat = {{1, 5, 7}, {3, 2, 9}, {1, 2, 8}};
        int [] arr = {1, 2, 8};
        System.out.println(covers(mat, arr, 1)); // true
        System.out.println(edit("abcd", "abcxd")); // 1
        System.out.println(edit("sunday", "saturday")); // 4
        System.out.println(ways(4, 2)); // 4
    }

}
