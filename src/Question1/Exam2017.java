package Question1;

public class Exam2017 {

    /**
     * Question 2017b A3 84
     * @param k steps allowed
     * @param n target number
     * @return number of ways to get to n using k steps
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
     * Question 2017a A5 86
     * @param str1 string 1
     * @param str2 string 2
     * @return number of insertion and removal needed
     */
    public static int edit(String str1, String str2){
        // Stop condition - both string are empty
        if(str1.length() == 0 && str2.length()==0)
            return 0;

        // All chars in other string will be need to be add
        if(str1.length() == 0)
            return str2.length();

        // All chars in other string will be need to be add
        if(str2.length() == 0)
            return str1.length();

        // Both chars are equal, continue to next char in string
        if(str1.charAt(0) == str2.charAt(0))
            return edit(str1.substring(1), str2.substring(1));

        int way1 = 1 + edit(str1.substring(1), str2);
        int way2 = 1 + edit(str1, str2.substring(1));

        return Math.min(way1, way2);
    }

    /**
     * Here you can test the function above with debugger and see how it works     *
     */
    public static void main(String[] args) {
        System.out.println(edit("abcd", "abcxd")); // 1
        System.out.println(edit("sunday", "saturday")); // 4
        System.out.println(ways(4, 2)); // 4
    }

}
