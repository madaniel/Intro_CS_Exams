package Question2;

public class Exam2017 {

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
        int [] aa = {0, 4, 6, 11, 11}, bb = {10, 20, 30, 40};
        printClosest(aa, bb, 11);  // 0 and 10
        printClosest(aa, bb, 13);  // 4 and 10
        printClosest(aa, bb, 18);  // 0 and 20
        printClosest(aa, bb, 70);  // 11 and 40

        int [] a = {65, 70, -5, 3, 48, 49, 52};
        System.out.println(findSum(a, 44));  // true
    }

}
