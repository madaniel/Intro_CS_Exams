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

    /**
     * Find duplicate numbers in sorted array
     * Time complexity : O(log n)
     * Space complexity : O(1)
     * @param arr sorted array on numbers with duplicates
     * @param num numbers to find
     * @return amount of duplicates of the number
     */
    public static int countDuplicates(int [] arr, int num){
        // We use binary search to find start and end point of the duplicates
        int start = 0, end = arr.length-1, mid = (start + end) / 2;
        int left = -1, right = -1;

        // Start looking for left index
        while (start <= end){

            // Mid number is too small, need to go to right slice
            if(arr[mid] < num){
                start = mid + 1;
                mid = (start + end) / 2;
            }

            // Mid number is too large, need to go to left slice
            else if(arr[mid] > num){
                end = mid - 1;
                mid = (start + end) / 2;
            }

            // Mid number is the number, but not the first duplication - need to got to left slice
            else if(arr[mid] == num && mid != 0 && arr[mid-1] == arr[mid]){
                    end = mid - 1;
                    mid = (end - start) / 2;
                    }
            else{
                left = mid;
                break;
                }
        }

        // Start looking for right index
        start = 0;
        end = arr.length-1;
        mid = (start + end) / 2;

        while (start <= end){

            // Mid number is too small, need to go to right slice
            if(arr[mid] < num){
                start = mid + 1;
                mid = (start + end) / 2;
            }

            // Mid number is too large, need to go to left slice
            else if(arr[mid] > num){
                end = mid - 1;
                mid = (start + end) / 2;
            }

            // Mid number is the number, but not the last duplication, need to got to right slice
            else if(arr[mid] == num && mid != arr.length-1 && arr[mid+1] == arr[mid]){
                start = mid + 1;
                mid = (start + end) / 2;
            }
            else{
                right = mid;
                break;
            }

        }

        // Total number of duplicated numbers
        return (right - left +1);
    }

    public static void main(String[] args) {
        int [] numArray = {1, 11, 21, 31, 41};
        int [] numArray2 = {2, 3, 4, 4, 4, 5, 6, 11, 15, 15, 15, 15};
        System.out.println(threeSum(numArray, 93)); // True
        System.out.println(threeSum(numArray, 11)); // False
        System.out.println(countSub("abbab", 'a', 'b')); // 4
        System.out.println(countDuplicates(numArray2, 4)); // 3
    }
}
