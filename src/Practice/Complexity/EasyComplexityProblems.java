package Practice.Complexity;

public class EasyComplexityProblems {

    /**
     * Find if 2 numbers in the array summed to target number
     * @param arr sorted array of numbers
     * @param sum  target sum to find
     * @return true - found sum false - not found
     */
    public static boolean twoSum(int [] arr, int sum){
        int leftIndex = 0;
        int rightIndex = arr.length-1;

        while (leftIndex != rightIndex){

            // We've found it
            if(arr[leftIndex] + arr[rightIndex] == sum)
                return true;

            // We move the right index left (decreasing the sum)
            if(arr[leftIndex] + arr[rightIndex] < sum)
                leftIndex ++;

            // We move the left index right (increasing the sum)
            if(arr[leftIndex] + arr[rightIndex] > sum)
                rightIndex --;
        }

        // We scanned all the array and didn't find sum
        return false;
    }

    /**
     * Find if there's any difference between 2 numbers in the array which is larger than target number
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

    public static void main(String[] args) {
        int [] numArray = {1, 3, 5, 7, 11};
        System.out.println(twoSum(numArray, 12)); // True
        System.out.println(diffBiggerThan(numArray, 11)); // False
    }

    }
