public class graphs {

    int a[][];
    int v;

    public graphs(int v){
        this.v = v;
        a = new int [v][v];
    }
    public void add_edge(int src, int dest){
        a[src][dest] = 1;
        a[dest][src] = 1;
    }

    public static void main(String[] args) {
        graphs g = new graphs(4);
        g.add_edge(0,1);
        g.add_edge(2,3);
        g.add_edge(0,3);
        g.add_edge(2,1);
    }

}
