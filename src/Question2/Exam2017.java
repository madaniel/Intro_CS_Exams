package Question2;

public class Exam2017 {

    /**
     * Question 2017A a6 87
     * Time complexity : O(n^2)
     * Space complexity : O(1)
     * @param arr array of numbers
     * @return true - if there's 3 numbers applies to a^2 + b^2 = c^2
     */
    public static boolean isPythagorean(int [] arr){

        if(arr.length < 3)
            return false;

        // We iterate the array looking for c^2 as a 2sum of numbers: a^2 + b^2
        for(int i=0; i< arr.length; i++){
            int squareC = (int)(Math.pow(arr[i], 2));
            if(twoSumSquare(arr, squareC, i))
                return true;
        }

        return false;
    }

    /**
     * Variation of 2 sum problem to solve isPythagorean
     * Time complexity : O(n)
     * Space complexity : O(1)
     * Finds sum in array of numbers
     * @param arr sorted array of numbers
     * @param sum target sum to find
     * @param exIndex index to exclude
     * @return true - if sum found
     */
    private static boolean twoSumSquare(int [] arr, int sum, int exIndex){

        if(arr.length < 2)
            return false;

        int high = arr.length-1, low = 0;

        while (high > low){

            // Sum was found
            if(sum == Math.pow(arr[high], 2) + Math.pow(arr[low], 2))
                return true;

            // Sum is too high -> decreasing sum
            if(sum < Math.pow(arr[high], 2) + Math.pow(arr[low], 2))
                high --;

            // Sum is too low -> increasing sum
            if(sum > Math.pow(arr[high], 2) + Math.pow(arr[low], 2))
                low ++;

            // Skip the excluded index
            if(high == exIndex)
                high --;

            else if(low == exIndex)
                low ++;
        }

        // Sum was not found
        return false;
    }


    /**
     * Classic 2 sum problem for reference
     * Time complexity : O(n)
     * Space complexity : O(1)
     * Finds sum in array of numbers
     * @param arr sorted array of numbers
     * @param sum target sum to find
     * @return true - if sum found
     */
    private static boolean twoSum(int [] arr, int sum){

        if(arr.length < 2)
            return false;

        int high = arr.length-1, low = 0;

        while (high > low){

            // Sum was found
            if(sum == arr[high] + arr[low])
                return true;

            // Sum is too high -> decreasing sum
            if(sum < arr[high] + arr[low])
                high --;

            // Sum is too low -> increasing sum
            if(sum > arr[high] + arr[low])
                low ++;
        }

        // Sum was not found
        return false;
    }


    /**
     * Question 2017B a4 85
     * Time complexity : O(n)
     * Space complexity : O(1)
     * @param a array of numbers
     * @param b array of numbers
     * @param x target sum
     */
    public static void printClosest(int [] a, int [] b, int x){
        int low = 0, high = b.length - 1, minDist = Integer.MAX_VALUE, currentDist, minA=0, minB=0;

        // We iterate both arrays from highest number to lowest, checking the sum and distance to x
        while (low <= a.length-1 && high >= 0){
            currentDist = dist(a[low] + b[high], x);

            // We save the values of the minimum dist found
            if(currentDist < minDist){
                minA = a[low];
                minB = b[high];
                minDist = currentDist;
            }

            if(a[low] + b[high] > x)
                high --;
            else
                low ++;
        }

        System.out.println(minA + " and " + minB);
    }

    /**
     * Time complexity : O(1)
     * Space complexity : O(1)
     * Returns the distance between 2 numbers
     * @param a
     * @param b
     * @return
     */
    private static int dist(int a, int b){
        int tmpDist = a - b;
        tmpDist = tmpDist > 0 ? tmpDist : (-1 * tmpDist);  // keeping the distance positive

        return tmpDist;
    }

    /**
     * 2017B A3 84
     * Time complexity : O(n)
     * Space complexity : O(1)
     * @param a array of int
     * @param sum target sum
     * @return true - if sum exists on array, false - if not
     */
    public static boolean findSum(int [] a, int sum){
        int start = min(a);
        int end = max(a);

        while(start != end){

            if(a[start] + a[end] == sum)
                return true;

            if(a[start] + a[end] > sum)
                end--;

            else
                start++;

            //In case we've out of range the array - we cycle the index
            if(end < 0)
                end = a.length-1;

            if(start > a.length-1)
                start = 0;
        }

        return false;
    }

    /**
     * Time complexity : O(n)
     * Space complexity : O(1)
     * @param a array of int
     * @return index of max number in array
     */
    private static int min(int [] a){
        int min = Integer.MAX_VALUE;
        int minIndex=-1;

        for(int i=0; i<a.length; i++)
            if (a[i] < min){
                min = a[i];
                minIndex = i;
            }

        return minIndex;
    }

    /**
     * Time complexity : O(n)
     * Space complexity : O(1)
     * @param a array of int
     * @return index of min number in array
     */
    private static int max(int [] a){
        int max = Integer.MIN_VALUE;
        int maxIndex = -1;


        for(int i=0; i<a.length; i++)
            if (a[i] > max){
                max = a[i];
                maxIndex = i;
            }

        return maxIndex;
    }

    public static void main(String[] args) {

        int [] arr1 = {1, 3, 4, 5, 6};
        int [] arr2 = {8, 9, 10, 15, 16, 17};
        int [] arr3 = {1, 3, 4, 5, 11, 30, 60, 61};
        int [] arr4 = {1, 6, 13, 15, 50, 84, 85};
        int [] arr5 = {1, 3, 39, 40, 70, 80, 85, 89, 90};
        int [] arr6 = {1, 3, 39, 40, 70, 80, 85, 90};
        System.out.println(isPythagorean(arr1)); // true
        System.out.println(isPythagorean(arr2)); // true
        System.out.println(isPythagorean(arr3)); // true
        System.out.println(isPythagorean(arr4)); // true
        System.out.println(isPythagorean(arr5)); // true
        System.out.println(isPythagorean(arr6)); // false


        int [] aa = {0, 4, 6, 11, 11}, bb = {10, 20, 30, 40};
        printClosest(aa, bb, 11);  // 0 and 10
        printClosest(aa, bb, 13);  // 4 and 10
        printClosest(aa, bb, 18);  // 0 and 20
        printClosest(aa, bb, 70);  // 11 and 40

        int [] a = {65, 70, -5, 3, 48, 49, 52};
        System.out.println(findSum(a, 44));  // true
    }

}
