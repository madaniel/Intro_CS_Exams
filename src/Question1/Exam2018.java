package Question1;

public class Exam2018 {

    /**
     * Question 2018A A6 87
     * @param n length of numbers in the array
     * @param max max number allowed in the array
     * @return number of possible arrays
     */
    public static int howManySorted(int n, int max){
        return howManySorted(n, max, 0, 1);
    }

    /**
     * We add 2 more helper variables
     * @param n length of numbers in the array
     * @param max max number allowed in the array
     * @param currentIndex index in the array
     * @param currentNumber number added to the array
     * @return
     */
    private static int howManySorted(int n, int max, int currentIndex, int currentNumber){
        // Stop condition 1 - We've reached the max amount of numbers in the array
        if(currentIndex > n-1)
            return 1;  // We count this as 1 array

        // Stop condition 2 - We've reached the max number allowed
        if(currentNumber > max)
            return 0;  // We don't count this

        // We add the current number to the array and increasing index
        int way1 = howManySorted(n, max, currentIndex+1, currentNumber);
        // We increase current number in the same index position
        int way2 = howManySorted(n, max, currentIndex, currentNumber+1);

        return way1 + way2;
    }

    /**
     * Here you can test the function above with debugger and see how it works     *
     */
    public static void main(String[] args) {
        System.out.println(howManySorted(3, 2));  // Should return 4
        System.out.println(howManySorted(2, 3));  // Should return 6
    }
}
