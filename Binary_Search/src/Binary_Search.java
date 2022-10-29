public class Binary_Search {
    public static boolean binary_search(int[] a, int target, int start, int last){

        int l = 0;
        int r = a.length;
        while (l<=r) {
            int mid = l + (r - l) / 2;
            if (a[mid]==target)
                return true;
            if (target>a[mid])
                l=mid+1;
            else
                r=mid-1;
        }
        return false;
    }

    public static void main(String[] args) {
        int []a ={2,3,4,5,6,7,8,9};
        System.out.println(binary_search(a,3,0,a.length-1));
    }
}

