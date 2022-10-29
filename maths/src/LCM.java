class LCM{

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

    public static int lcm(int a, int b){

        return (a * b)/gcd(a,b);
    }

    public static void main(String[] args) {
        System.out.println(lcm(24, 36));
    }
}