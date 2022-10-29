import java.util.ArrayDeque;
import java.util.ArrayList;

public class topological_sorting {
    static ArrayList<ArrayList<Integer>> a = new ArrayList<ArrayList<Integer>>();
    static int v;
    static int indeg[];

    public static void topological_sort_dfs() {
        ArrayDeque<Integer> stack = new ArrayDeque<Integer>();
        boolean[] visited = new boolean[v];
        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                dfs(i, visited, stack);
            }
        }
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

    public static void dfs(int src, boolean[] visited, ArrayDeque<Integer> stack) {
        visited[src] = true;
        for (Integer neighbor : a.get(src)) {
            if (!visited[neighbor]) {
                dfs(neighbor, visited, stack);
            }
        }
        stack.push(src);
    }

    public static void bfs(int src, boolean[] visited, int[] distance) {
        ArrayDeque<Integer> q = new ArrayDeque<Integer>();
        q.add(src);
        visited[src] = true;
        distance[src] = 0;
        while (!q.isEmpty()) {
            int curr = q.poll();
            for (Integer neighbor : a.get(curr)) {
                if (!visited[neighbor]) {
                    q.add(neighbor);
                    visited[neighbor] = true;
                    distance[neighbor] = distance[curr] + 1;
                }
            }
        }
    }

    public void add_edge(int src, int dest) {
        a.get(src).add(dest);
        a.get(dest).add(src);
    }

    public static void topological_sorting_bfs() {
        indegree();
//        int count = 0;
        ArrayDeque<Integer> q = new ArrayDeque<Integer>();
        for (int i = 0; i < v; i++) {
            if (indeg[i] == 0) {
                q.add(i);
//                count++;
            }
        }
        ArrayList<Integer> ans = new ArrayList<Integer>();
        while (!q.isEmpty()) {
            int curr = q.poll();
            ans.add(curr);
            for (Integer neighbor : a.get(curr)) {
                indeg[neighbor]--;
                if (indeg[neighbor] == 0) {
                    q.add(neighbor);
//                    count++;
                }
            }
//            if (count<v){
//                System.out.println("Cycle is present");
//            }
//            else{
//                for (Integer e: ans) {
//                    System.out.println(e);
//                }

        }
    }
    public static void indegree(){
        for (int i = 0; i < v; i++) {
            for (Integer neighbor : a.get(i)) {
                indeg[neighbor]++;
            }
        }
    }
    public topological_sorting(int v) {
        this.v = v;
        for (int i = 0; i < v; i++) {
            a.add(new ArrayList<Integer>());
        }
    }

    public static void main(String[] args) {
        topological_sorting graph = new topological_sorting(6);
        graph.add_edge(5, 2);
        graph.add_edge(5, 0);
        graph.add_edge(4, 0);
        graph.add_edge(4, 1);
        graph.add_edge(2, 3);
        graph.add_edge(3, 1);
//        topological_sort_dfs();
        topological_sort_dfs();
    }
}

