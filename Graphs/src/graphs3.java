import java.util.LinkedList;
import java.util.Queue;

public class graphs3 {
    public static int connected_components(int[][]graphs){

        int count=0;
        boolean visited[]=new boolean[graphs.length];
        for(int i=0;i<graphs.length;i++){
            if(!visited[i]){
                count++;
                dfs(graphs,i,visited);
            }
        }
        return count;
    }
    public static void dfs(int[][]graphs,int i,boolean[]visited){
        visited[i]=true;
        for(int j=0;j<graphs.length;j++){
            if(graphs[i][j]==1 && !visited[j]){
                dfs(graphs,j,visited);
            }
        }
    }
    public static void shortest_path(int[][]graphs,int src,int dest){
        boolean visited[]=new boolean[graphs.length];
        int distance[]=new int[graphs.length];
        Queue<Integer> q=new LinkedList<>();
        q.add(src);
        visited[src]=true;
        distance[src]=0;
        while(!q.isEmpty()){
            int node=q.poll();
            for(int i=0;i<graphs.length;i++){
                if(graphs[node][i]==1 && !visited[i]){
                    q.add(i);
                    visited[i]=true;
                    distance[i]=distance[node]+1;
                }
            }
        }
        System.out.println(distance[dest]);
    }
}
