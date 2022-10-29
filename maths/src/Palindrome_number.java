public class Palindrome_number {
    public static boolean palindrome(int n){

        int temp = n;
        int rev = 0;

        while(temp > 0){
            int last_digit = temp%10;
            rev = rev * 10 + last_digit;
            temp /= 10;
        }
        return rev == n;
    }

    public static void main(String[] args) {
        System.out.println(palindrome(144));
    }
}
