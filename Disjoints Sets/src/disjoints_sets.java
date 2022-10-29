public class disjoints_sets {

    static int [] parent;
    static int [] rank;
//    make elements from 0 to n-1
    public disjoints_sets(int n){
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }
// Find the representative of the set that group
static int find(int x){
        if(x!=parent[x])
//            return find(parent[x]);
            parent[x] = find(parent[x]);
        return parent[x];
    }
//    Union two sets if they are not in the same set
    void union(int x, int y){
//        also optimize the union function
        if (isConnected(x,y))
            return;
        int captain_A = find(x);
        int captain_B = find(y);
        if(captain_A!=captain_B){
            if(rank[captain_A]>rank[captain_B]){
                parent[captain_B] = captain_A;
            }else if(rank[captain_A]<rank[captain_B]){
                parent[captain_A] = captain_B;
            }else{
                parent[captain_B] = captain_A;
                rank[captain_A]++;
            }
        }

    }
//    Are they in the same set?
static boolean same_set(int x, int y){
        return find(x)==find(y);
    }
    static boolean isConnected(int x, int y){
        return same_set(x,y);
    }
    public static void main(String[] args) {
        disjoints_sets ds = new disjoints_sets(8);
       ds.union(0,2);
       ds.union(3,5);
        System.out.println(disjoints_sets.isConnected(0,3));
       ds.union(0,5);
        System.out.println(disjoints_sets.isConnected(0,3));
    }
}
