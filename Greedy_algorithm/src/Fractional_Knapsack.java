import java.util.Arrays;
import java.util.Comparator;

public class Fractional_Knapsack {
    class Item{
        int value, weight;
        Item(int x, int y){
            this.value = x;
            this.weight = y;
        }
    }
    public double fractional_knapsack(int w, Item[] a, int n){
        Arrays.sort(a, new Comparator<Item>() {
            @Override
            public int compare(Item i1, Item i2) {
                return i1.weight*i2.value - i2.weight*i1.value;
            }
        });
        double ans = 0;
        for (int i = 0; i < n; i++) {
            if(w>=a[i].weight){
                ans+=a[i].value;
                w -= a[i].weight;
            }
            else{
                ans +=(double)(a[i].value*w)/(double)a[i].weight;
                break;
            }
        }
        return ans;
    }
}
