public class Q1 {
    public static int left(int[] a, int key) {
        int l = 0;
        int r = a.length-1;
        int ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (a[mid] == key) {
                ans = mid;
                r = mid - 1;
            }
            else if (key > a[mid])
                l = mid + 1;
            else
                r = mid - 1;
        }
        return ans;
    }
    public static int right(int[]a, int key){
        int l =0;
        int r = a.length-1;
        int ans = -1;
        while (l<=r){
            int mid = l+r/2;
            if (a[mid] == key) {
                ans = mid;
                l = mid + 1;
            }
            else if (key > a[mid])
                l = mid + 1;
            else
                r = mid - 1;
        }
        return ans;
    }
    public static int search_in_rotated_sorted_array(int []a, int key){
        int l =0;
        int r = a.length-1;
        while(l<=r){
            int mid = l +(r-l)/2;
            if (a[mid]==key)
                return mid;
            if(a[l]<=a[mid]){
                if (key>=a[l] && key <a[mid])
                    r = mid-1;
                else
                    l = mid+1;
            }
            else {
                if(key>a[mid] && key<=a[r])
                    l = mid+1;
                else
                    r = mid-1;
            }
        }
        return -1;
    }
}
