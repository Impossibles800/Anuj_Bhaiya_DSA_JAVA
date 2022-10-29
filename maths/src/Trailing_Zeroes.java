public class Trailing_Zeroes {
    public static int count_trailing_zero(int n){

        int result = 0;

        while(n>0){
            result += n/5;
            n = n/5;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(count_trailing_zero(125));
    }
}
