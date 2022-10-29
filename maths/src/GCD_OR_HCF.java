public class GCD_OR_HCF {
    public static int gcd(int a, int b){
//        if (a == b)
//            return a;
//        if(a < b)
//            return gcd(b, a);
//        return gcd(a-b, b);

        if (a<b)
            return gcd(b,a);
        if (b == 0)
            return a;
        return gcd(a%b, b);
    }

    public static void main(String[] args) {
        System.out.println(gcd(24, 36));
    }
}
