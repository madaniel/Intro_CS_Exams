package Question2;

public class Exam2016 {

    /**
     * Question 2016A 87
     *
     * @param a array of 0 and 1
     * @return number of collisions between 1 and 0
     */
    public static int passingCars(int[] a) {
        int count1 = 0, countColl = 0;

        for (int i = a.length - 1; i >= 0; i--) {
            if (a[i] == 1)
                count1 += 1;
            if (a[i] == 0)
                countColl += count1;
        }

        return countColl;
    }

    /**
     * Question 2016A 83
     * Time complexity : O(log n)
     * Space complexity : O(1)
     *
     * @param arr array of numbers
     * @param num target sum
     * @return true - sum of 2 numbers found, false - not found
     */
    public static boolean findX(int[] arr, int num) {

        // We need minimum of two numbers in array
        if (arr.length < 2)
            return false;

        // We use Binary Search idea (see reference below)
        int low = 0, med, high = arr.length - 1;

        while (low < high) {
            med = (high + low) / 2;

            // We look for the med number and its neighbor from the right and left
            if (arr[med] + arr[med + 1] == num || arr[med] + arr[med - 1] == num)
                return true;

            // mid pair is too high -> going left
            if (arr[med] + arr[med + 1] > num)
                high = med - 1;

            // mid pair is too low -> going right
            if (arr[med] + arr[med + 1] < num)
                low = med + 1;
        }

        return false;
    }

    /**
     * Classic Binary Search for reference
     *
     * @param arr array with numbers to find
     * @param x   target number
     * @return index of target number or -1 if not found
     */
    private static int binarySearch(int[] arr, int x) {
        int low = 0, mid, high = arr.length - 1;

        while (low <= high) {

            mid = (high + low) / 2;

            if (arr[mid] == x)
                return mid;

            // mid number is too high -> going left
            if (arr[mid] > x)
                high = mid - 1;

            // mid number is too low -> going right
            if (arr[mid] < x)
                low = mid + 1;
        }

        // num is not in array
        return -1;
    }

    /**
     * Question 2016B 1A
     *
     * Complexity: O(n)
     * Memory complexity: O(1)
     *
     * Checks if given number is a sum of two different numbers of a given ranges.
     *
     * @param a array of ranges.
     * @param x number to check.
     * @return true if x is such a sum, false otherwise.
     *
     */
    private static boolean isSum(Range[] a, int x) {
        int lo = 0;
        int hi = a.length - 1;

        while (lo <= hi) {
            if (x >= a[lo].getSmallest() + a[hi].getSmallest() && x <= a[lo].getLargest() + a[hi].getLargest()) {
                if (lo == hi)
                    return x != a[lo].getSmallest() * 2 && x != a[lo].getLargest() * 2;

                return true;
            }
            if (x > a[lo].getLargest() + a[hi].getLargest())
                lo++;
            if (x < a[lo].getSmallest() + a[hi].getSmallest())
                hi--;
        }
        return false;
    }


    public static void main(String[] args) {
        int[] arr11 = {0, 1, 0, 1, 1};
        System.out.println(passingCars(arr11));

        int[] arr1 = {1, 2, 5, 3, 6, 10, 9};
        int[] arr2 = {1};
        int[] arr3 = {1, 9};

        System.out.println(findX(arr2, 9)); // false
        System.out.println(findX(arr3, 10)); // true
        System.out.println(findX(arr1, 9)); // true
        System.out.println(findX(arr1, 3)); // true
        System.out.println(findX(arr1, 19)); // true
        System.out.println(findX(arr1, 20)); // false

        Range[] a = new Range[]{new Range(3, 5), new Range(12, 12), new Range(19, 20), new Range(100, 104)};
        System.out.println(isSum(a, 22)); //true
        System.out.println(isSum(a, 113)); //true
        System.out.println(isSum(a, 202)); //true
        System.out.println(isSum(a, 38)); //false
        System.out.println(isSum(a, 53)); //false

    }

}
