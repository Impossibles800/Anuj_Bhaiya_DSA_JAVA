import java.util.ArrayList;

public class InDegree {
    ArrayList<ArrayList<Integer>> a = new ArrayList<ArrayList<Integer>>();
    int v;
    int[] indeg;
    //    directed graph
    public InDegree(int v){
        this.v = v;
        for(int i=0;i<v;i++){
            a.add(new ArrayList<Integer>());
        }
    }
    public void addEdge(int src,int dest){
        a.get(src).add(dest);

    }

    void degree(){
        for(ArrayList<Integer> adjacents:a){
            for(Integer adjacent:adjacents){
                indeg[adjacent]++;
            }
        }
    }
}

