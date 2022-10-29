public class Min_heap {

    int[] a;
    int capacity;
    int n;

    public Min_heap(int capacity){
        this.capacity = capacity;
        a = new int[capacity];
        n = 0;
    }
    private void swap(int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    public void insert(int key){

        if(n+1 == capacity){
            System.out.println("Heap is full");
            return;
        }
        n = n+1;
        a[n] = key;
        int i = n;
        while(i>1){
            int parent = i/2;
            if(a[i]<a[parent]) {
                swap(a[i], parent);
                i = parent;
            }
        }
    }
    public int extractMin(){
        if(n==0)
            return -1;
        int res = a[1];
        a[1] = a[n];
        int i  = 1;
        while(i<=n){
            int left = 2*i;
            int right = 2*i+1;
            int smallest = i;

            if(left<=n && a[left]<a[smallest])
                smallest = left;
            if(right<=n && a[right]<a[smallest])
                smallest = right;
            if(smallest!=i){
                swap(smallest, i);
                i = smallest;
            }
            else break;
        }
        return result;
    }

    public  void print(){
        for (int i: a) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        Min_heap heap = new Min_heap(10);

            heap.insert(10);
            heap.insert(20);
            heap.insert(30);
            heap.insert(40);
            heap.insert(50);
            heap.insert(60);
            heap.insert(70);
            heap.insert(80);
            heap.insert(90);
            heap.insert(100);
            heap.print();
    }
}
