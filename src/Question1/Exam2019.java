package Question1;

public class Exam2019 {

    /**
     * Question 2019A b 478
     * @return number of sub-sequences
     */
    public static int count(String str, String pattern){
        return count(str, 0, pattern, 0);
    }

    private static int count(String str, int strIndex, String pattern, int ptrIndex){
        // Stop condition
        if(ptrIndex > pattern.length()-1)
            return 1;  // Pattern scan had complete so we've found a match

        if(strIndex > str.length() -1 && ptrIndex <= pattern.length() -1)
            return 0; // String scan had completed but pattern not so we didn't find a match

        int way1 = 0, way2 = 0;

        // We found a matched char - we proceed with both indexes
        if(str.charAt(strIndex) == pattern.charAt(ptrIndex))
            way1 = count(str, strIndex+1, pattern, ptrIndex+1);

        // We didn't find a match - we proceed only with string index
        way2 = count(str, strIndex+1, pattern, ptrIndex);

        return way1 + way2;
    }

    /**
     * Here you can test the function above with debugger and see how it works     *
     */
    public static void main(String[] args) {

        System.out.println(count("abcd", "abcd")); // Should return 1
        System.out.println(count("abcdc", "ac")); // Should return 2
        System.out.println(count("abcddd", "abd")); // Should return 3
    }
}
