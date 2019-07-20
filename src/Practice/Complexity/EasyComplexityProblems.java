package Practice.Complexity;

import java.util.Arrays;

public class EasyComplexityProblems {

    /**
     * Find if 2 numbers in the array summed to target number
     * Time complexity : O(n)
     * Space complexity : O(1)
     * @param arr sorted array of numbers
     * @param num  target sum to find
     * @return true - found sum false - not found
     */
    public static boolean twoSum(int [] arr, int num){
        int leftIndex = 0;
        int rightIndex = arr.length-1;

        while (leftIndex < rightIndex){

            // We've found it
            if(arr[leftIndex] + arr[rightIndex] == num)
                return true;

            // We move the right index left (decreasing the sum)
            if(arr[leftIndex] + arr[rightIndex] < num)
                leftIndex ++;

            // We move the left index right (increasing the sum)
            if(arr[leftIndex] + arr[rightIndex] > num)
                rightIndex --;
        }

        // We scanned all the array and didn't find sum
        return false;
    }

    /**
     * Find if there's any difference between 2 numbers in the array which is larger than target number
     * Time complexity : O(n)
     * Space complexity : O(1)
     * @param arr unsorted array of numbers
     * @param num target number
     * @return true - found diff larger than num, false - not found
     */
    public static boolean diffBiggerThan(int [] arr, int num){
        // We find the max and the min from the array
        int min = arr[0];
        int max = arr[0];

        for(int i=0; i < arr.length; i++){
            // find max
            if(arr[i] > max)
                max = arr[i];
            // find min
            if(arr[i] < min)
                min = arr[i];
        }

        // The diff between max and min is the largest diff in the array
        return (max-min) > num;
    }

    /**
     * Find if there's any difference between 2 numbers in the array which is smaller than target number
     * Similar to last problem but now we can't just use min and max diff - we need to check every diff between the numbers
     * If the given array is not sorted, we need to use sort.
     * Time complexity : O(n log(n))
     * Space complexity : O(1)
     * @param arr unsorted array
     * @param num number to find
     * @return true - if the num is smaller than all diffs between each pair, false - otherwise
     */
    public static boolean diffSmallerThan(int [] arr, int num){
        Arrays.sort(arr);
        int diff;

        // looking for diff between each pair of numbers in the array
        for(int i=0; i < arr.length -1; i++){
            diff = Math.abs(arr[i] - arr[i+1]);
            // Check the diff between 2 pairs
            if(diff < num)
                return true;
        }

        // We've completed to scan the array
        return false;
    }

    public static void main(String[] args) {
        int [] numArray = {1, 3, 5, 7, 11};
        int [] numArray2 = {3, 1, 6, 15, 10};
        System.out.println(twoSum(numArray, 12)); // True
        System.out.println(diffBiggerThan(numArray, 11)); // False
        System.out.println(diffSmallerThan(numArray2, 1)); // False
    }

}
