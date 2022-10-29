import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public class Q2 {
    // Transpose of the matrix
    public static void transpose(int[][] a){
        int n = a.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int swap = a[i][j];
                a[i][j] = a[j][i];
                a[j][i] = swap;
            }
        }
    }

//    Rotate a matrix 90° clockwise

    public static void rotate(int[][]a){

        transpose(a);
        for (int i = 0; i <a.length ; i++) {
            for (int j = 0; j < a.length; j++) {
                int swap = a[i][j];
                a[i][j] = a[j][i];
                a[j][i] = swap;
            }
        }
    }

    public static boolean search(int[][]a, int key){
        int row = 0;
        int col = a.length;
        while (row< a.length && col>=0){
            if (a[row][col] == key)
                return true;
            else if (key>a[row][col])
                row++;
            else
                col --;
        }
        return false;
    }

    public static void main(String[] args) {

    }

}

