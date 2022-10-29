import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        
    }
    public static int minimum_platforms(int a[], int d[], int n){
        Arrays.sort(a);
        Arrays.sort(d);
        int i=0, j=0, count=0, max=0;

        while (i<n){
            if (a[i]<=d[i]){
                count++;
                i++;
                max = Math.max(max, count);
            }
            else {
                count--;
                j++;
            }
        }
        return max;
    }
}