public class sum_of_digits_in_number {

    public static int sumOfDigits(int n){

        // number of digits = logbase10(n)+1
        if(n == 0)
            return 0;

        int last_digit = n%10;
        return last_digit + sumOfDigits(n/10);
    }


    public static void subsequence(String s, int i, String curr){

        if(i == s.length())
            return ;

        subsequence(s,i+1, curr);
        subsequence(s, i+1, curr+s.charAt(i));

    }
    public static void sub(String s){
        subsequence(s, 0, "");
    }

    public static void main(String[] args) {
//        System.out.println(sumOfDigits(145));

    }
}
