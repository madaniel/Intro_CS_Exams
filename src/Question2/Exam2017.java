package Question2;

public class Exam2017 {

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
        int [] a = {65, 70, -5, 3, 48, 49, 52};
        System.out.println(findSum(a, 44));  // true
    }

}
