package Question2;

public class Exam2019 {

    /**
     * Question 2019b 83
     * @param arr sorted matrix of positive and negative numbers
     * @return number of negative numbers
     */
    public static int howManyNegativeNumbers(int [][] arr){
        int count = 0, col = arr[0].length-1, row = 0;

        while (col >= 0){

            if(arr[row][col] < 0){
                count += col + 1;
                row ++;
            }
            else
                col--;
        }
        return count;
    }

    public static void main(String[] args) {
        int [][] mat = {{-99,-72,-64,-55,-28,-10,-5}, {-72,53,-46,-38,11,13,22}, {-63,-48,-27,-12,14,16,23}, {-44,-29,-10,0,18,20,28}, {0,12,14,20,28,30,35}};
        System.out.println(howManyNegativeNumbers(mat));

    }

}
