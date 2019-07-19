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

    public static void main(String[] args) {
        int [] numArray = {1, 3, 5, 7, 11};
        System.out.println(twoSum(numArray, 12)); // True
    }

    }
