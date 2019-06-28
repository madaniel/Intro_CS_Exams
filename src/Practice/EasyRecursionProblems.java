package Practice;

/**
 * Basic problems to understand the basic idea of Recursion
 * First, read the solution and try to understand how it works
 * Second, try to write it down by yourself on a paper
 *
 * Step 1 (must)     Decide what is the stop condition (base case)
 * Step 2 (must)     Decide what is the connection between the recursion calls
 * Step 3 (must)     Decide how much to decrease the input for the next recursion call
 * Step 4 (optional) Decide whether more than one recursion call is needed
 */
public class EasyRecursionProblems {

    /**
     * Sum all positive numbers until n
     * 1 + 2 + 3 + ... + n
     *
     * @param n target number
     * @return sum of all numbers
     */
    public static int sumToN(int n){

       if (n == 1) // Base case
            return 1;

        return n + sumToN(n - 1);
    }

    /**
     * Calc factorial of n number
     * 1 * 2 * 3 * ... * n
     *
     * @param n target number
     * @return factorial of n
     */
    public static int factorial(int n){

        if(n <= 1) // Base case
            return 1;

        return n * factorial(n-1);
    }

    /**
     * Calc Fibonacci of a number n
     * 1, 1, 2, 3, 5, 8, 13, ... n
     *
     * Every number is the series is sum of its previous 2 numbers
     * The base case is for the first and second number
     * All the other numbers need to be calculated recursively
     *
     * We uses 2 recursive calls: one for the previous number and one for the "previous-previous" number
     * Each call will go back until n==1 and calc all the fibonacci numbers in the series until n
     * Obviously this is far from efficiency, but we use it for learning purpose
     *
     * @param n target number
     * @return fibonacci of n
     */
    public static int fibonacci(int n){

        // Base case we know
        // 1, 1, ...
        if(n == 0 || n == 1)
            return 1;

        // 1, 1, 2, 3, 5 ....
        // The next numbers are the sum between the last 2 consecutive numbers
        // For n == 2 result will be sum of 1 and 1
        // For n == 3 result will be sum of 2 and 1
        // For n == 4 result will be sum of 2 and 3
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    /**
     * Return true if the array of Ints are the same from both sides (symmetric)
     * We use pointers to iterate using recursion over the array
     * For each pair of numbers we compare, if the compare is false - the final answer is false
     *
     * @param left point from the start of the array
     * @param right point from the end of the array
     * @param arr target array
     * @return true - if the array symmetric false - otherwise
     */
    public static boolean isSymmetric(int left, int right, int[] arr) {
        // Stop condition - left pointer reached the right pointer.
        // It means we've checked all the numbers in the array
        if (left >= right)
            return true;

        // We've found a mismatch
        if (arr[left] != arr[right])
            return false;

        return isSymmetric(left + 1, right - 1, arr);
    }

    /**
     * Palindrome = string with equal chars from its both side
     * For example: abba, aca, a
     * We use charAt to check the chars in the start and in the end of the string.
     * Each time, we will cut the string until it will be empty or with single char left.
     *
     * @param str target string
     * @return true - string is palindrome, false - not palindrome
     */
    public static boolean isPalindrome(String str){
        // Base case - string with 1 char or empty is a palindrome
        if( str.length() <= 1)
                return true;

        // else - we need to compare both sides
        if(str.charAt(0) != str.charAt(str.length()-1))
            return false;  // Not a palindrome

        // Continue to check with the substring - without the head and tail
        return isPalindrome(str.substring(1, str.length()-1));

    }

    /**
     * Here you can test the function above with debugger and see how it works     *
     */
    public static void main(String[] args) {
        System.out.println("isPalindrome=" + isPalindrome("abba")); // True
        System.out.println("isPalindrome=" + isPalindrome("a"));  // True
        System.out.println("isPalindrome=" + isPalindrome("abab"));  // False

    }

}
