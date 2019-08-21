package Question2;

public class Exam2016 {

    /**
     * Question 2016A 83
     * @param arr array of numbers
     * @param num target sum
     * @return true - sum of 2 numbers found, false - not found
     */
    public static boolean findX(int [] arr, int num){

        // We need minimum of two numbers in array
        if(arr.length < 2)
            return false;

        // We use Binary Search idea (see reference below)
        int low = 0, med, high = arr.length-1;

        while (low < high){
            med = (high + low) / 2;

            // We look for the med number and its neighbor from the right and left
            if(arr[med] + arr[med+1] == num || arr[med] + arr[med-1] == num)
                return true;

            // mid pair is too high -> going left
            if(arr[med] + arr[med+1] > num)
                high = med - 1;

            // mid pair is too low -> going right
            if(arr[med] + arr[med+1] < num)
                low = med + 1;
        }

        return false;
    }

    /**
     * Classic Binary Search for reference
     * @param arr array with numbers to find
     * @param x target number
     * @return index of target number or -1 if not found
     */
    private static int binarySearch(int [] arr, int x){
        int low = 0, mid, high = arr.length-1;

        while (low <= high){

            mid = (high + low) / 2;

            if(arr[mid] == x)
                return mid;

            // mid number is too high -> going left
            if(arr[mid] > x)
                high = mid - 1;

            // mid number is too low -> going right
            if(arr[mid] < x)
                low = mid + 1;
        }

        // num is not in array
        return -1;
    }


    public static void main(String[] args) {
        int [] arr1 = {1, 2, 5, 3, 6, 10, 9};
        int [] arr2 = {1};
        int [] arr3 = {1, 9};

        System.out.println(findX(arr2, 9)); // false
        System.out.println(findX(arr3, 10)); // true
        System.out.println(findX(arr1, 9)); // true
        System.out.println(findX(arr1, 3)); // true
        System.out.println(findX(arr1, 19)); // true
        System.out.println(findX(arr1, 20)); // false

    }

}
