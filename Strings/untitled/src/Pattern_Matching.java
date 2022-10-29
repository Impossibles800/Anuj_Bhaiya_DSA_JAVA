public class Pattern_Matching {
    public static boolean patternMatching(String s, String p){

        for (int i = 0; i < s.length()-p.length(); i++) {
            int j = 0;
            for (; j <p.length() ; j++) {
                if (s.charAt(i+j)!= p.charAt(j))
                    break;
            }
            if (j == p.length())
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "abcabdabbacdab";
        String p = "bda";
        System.out.println(patternMatching(s, p));
    }
}
