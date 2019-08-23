package Question6;

public class Exam2017 {

    /**
     * Question 2017B 85
     * @param s1 target word
     * @param s2 source word
     * @return target word without letters from source word
     */
    public static String what(String s1, String s2){
        int [] c = new int [26];
        String res = s1;

        // Counting the letters instances in the s2 and place the count in c array
        for(int i=0; i<s2.length(); i++){
            int p = s2.charAt(i) - 'a';
            c[p]++;
        }

        int count = 0;

        for(int i=0; i<s1.length(); i++){

            if(s1.charAt(i) >= 'a' && s1.charAt(i) <='z'){
                int p = s1.charAt(i) - 'a';

                if(c[p] != 0)
                    res = res.substring(0, count) + res.substring(count+1);
                else
                    // Counting if the letter does not exist in s2
                    count++;
            }
            else
                // Counting if the letter is not in a - z, like space
                count++;
        }

        return res;
    }

    public static void main(String[] args) {
        String s1 ="good luck in the exam";
        String s2 ="ed";

        System.out.println(what(s1, s2)); // goo luck in th xam
    }

}
