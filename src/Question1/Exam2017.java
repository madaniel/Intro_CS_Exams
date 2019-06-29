package Question1;

public class Exam2017 {

    /**
     * Question 2017b A3 84
     * @param k
     * @param n
     * @return
     */
    public static int ways(int k, int n){
        // Stop conditions
        if(k == 0 && n == 0)
            return 1; // Found a way

        if(k == 0)
            return 0; // Did not find a way

        int stepRight = ways(k-1, n-1); // Decreasing the distance - moving toward number n
        int stepLeft = ways(k-1, n+1);  // Increasing the distance - moving backward number n
        return  stepLeft + stepRight;
    }

    /**
     * Here you can test the function above with debugger and see how it works     *
     */
    public static void main(String[] args) {
        System.out.println(ways(4, 2)); // Should return 4
    }

}
