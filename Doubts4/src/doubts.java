public class doubts {
    public static boolean isHeap(int[] a) {
        return isMaxHeap(a, 0);
    }

    public static boolean isMaxHeap(int[] a, int i) {
        if (i > a.length / 2)
            return true;

        if (i>= a.length/2)
            return true;
        int left = i * 2+1;
        int right = i * 2 + 2;

        boolean is_left =  left<a.length && a[i]>=a[left] && isMaxHeap(a,left);
        if (is_left){
            if (right< a.length){
                if(a[i]>=a[right] && isMaxHeap(a,right))
                    return true;
                else
                    return false;
            }
            return true;
        }
        boolean is_right =  right<a.length;

//        if (a[i] >= a[left] && a[i] >= a[right] && isMaxHeap(a, left) &&
//                isMaxHeap(a, right))
//            return true;


        return is_left && is_right;

    }
}
