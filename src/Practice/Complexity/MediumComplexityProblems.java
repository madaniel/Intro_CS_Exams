package Practice.Complexity;

import java.util.Arrays;

public class MediumComplexityProblems {

    /**
     * Find sum of three numbers in array of numbers
     * Time complexity : O(n^2)
     * Space complexity : O(1)
     * @param arr unsorted array
     * @param num number to find
     * @return true - if 3 numbers summed to num, false - otherwise
     */
    public static boolean threeSum(int [] arr, int num){
        Arrays.sort(arr);

        // We use twoSum to find part of the sum
        for(int i=0; i < arr.length; i++){
            if(twoSum(arr, num-arr[i], i))
                return true;
        }

        return false;
    }

    /**
     * We need to implement two sum method with modification: excluding one index in the search
     * Time complexity : O(n)
     * Space complexity : O(1)
     * @param arr sorted array
     * @param num number to find
     * @param currentIndex Index to skip
     * @return true - if 2 numbers summed into num, false - otherwise
     */
    private static boolean twoSum(int [] arr, int num, int currentIndex){
        int leftIndex = 0;
        int rightIndex = arr.length-1;

        while (leftIndex < rightIndex){
            int sum = arr[leftIndex] + arr[rightIndex];

            // Skip currentIndex
            if(leftIndex == currentIndex)
                leftIndex ++;
            else if(rightIndex == currentIndex)
                rightIndex --;

            // We've found it
            if(sum == num)
                return true;

            // We move the right index left (decreasing the sum)
            if(sum < num)
                leftIndex ++;

            // We move the left index right (increasing the sum)
            if(sum > num)
                rightIndex --;
        }

        // We scanned all the array and didn't find sum
        return false;
    }

    /**
     * Count how many subString found in a string starting from start char to end char
     * For example: "abb" start='a' end='b' -> result: 2 ["ab", "abb"]
     * "abbab" start='a' end='b' -> result: 4 ["ab", "abb", "abbab", "ab"]
     * Time complexity : O(n)
     * Space complexity : O(1)
     * @param s String
     * @param start char to start search
     * @param end char to end search
     * @return count of the subString
     */
    public static int countSub(String s, char start, char end){
        int countEnd = 0;
        int count = 0;

        // We scan the string backwards
        for(int i=s.length()-1; i>=0; i--){
            // Every end char can be attached to any start chars
            if(s.charAt(i) == end)
                countEnd ++;
            // Any end char we've found will be counted as 1 subString
            if(s.charAt(i) == start)
                count += countEnd;
        }

        return count;
    }

    public static void main(String[] args) {
        int [] numArray = {1, 11, 21, 31, 41};
        System.out.println(threeSum(numArray, 93)); // True
        System.out.println(threeSum(numArray, 11)); // False
        System.out.println(countSub("abbab", 'a', 'b')); // 4
    }



}
