import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class G4 {

    class  Pair {
        int v, wt;

        public Pair(int v, int wt) {
            this.v = v;
            this.wt = wt;
        }
    }

    ArrayList<ArrayList<Pair>> adj;

    int vertex;

    public G4(int vertex) {
        adj = new ArrayList<ArrayList<Pair>>();
        this.vertex = vertex;
        for (int i = 0; i < vertex; i++) {
            adj.add(new ArrayList<Pair>());
        }
    }

    //    Directed Graph
    public void addEdge(int src, int destination, int wt) {
        adj.get(src).add(new Pair(destination, wt));
    }

    //    topological sort using dfs
    public ArrayDeque<Integer> topologicalSort() {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        boolean[] visited = new boolean[vertex];

        for (int i = 0; i < vertex; i++) {
            if (!visited[i]) {
                dfs(i, visited, stack);
            }
        }
        return stack;
    }

    //    dfs
    public void dfs(int src, boolean[] visited, ArrayDeque<Integer> stack) {
        visited[src] = true;
        for (Pair neighbor : adj.get(src)) {
            if (!visited[neighbor.v]) {
                dfs(neighbor.v, visited, stack);
            }
        }
        stack.push(src);
    }

    public int[] shortest_path_in_acyclic_graph(int src) {
        ArrayDeque<Integer> stack = topologicalSort();
        int[] distance = new int[vertex];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[src] = 0;
        while (!stack.isEmpty()) {
            int curr = stack.pop();
            if (distance[curr] != Integer.MAX_VALUE) {
                for (Pair neighbor : adj.get(curr)) {
                    if (distance[neighbor.v] > distance[curr] + neighbor.wt) {
                        distance[neighbor.v] = distance[curr] + neighbor.wt;
                    }
                }
            }
        }

        return distance;
    }

    public static void main(String[] args) {
        int v = 5;
        int src = 0;

        G4 g = new G4(v);
//        g.addEdge(0, 1, 3);
//        g.addEdge(0, 2, 6);
//        g.addEdge(1, 3, 4);
//        g.addEdge(1, 2, 4);
//        g.addEdge(2, 4, 2);
//        g.addEdge(2, 3, 8);
//        g.addEdge(2, 1, 5);
//        g.addEdge(3, 4, 3);
//        int[] shortest_distane = g.shortest_path_in_acyclic_graph(src);
//
//        for (int i = 0; i < v; i++) {
//            System.out.println("Shortest distance from " + src + " to " + i + " is " + shortest_distane[i]);
//        }

        g.addEdge(0, 1, 7);
        g.addEdge(0, 3, 3);
        g.addEdge(0, 2, 8);
        g.addEdge(2, 1, 1);
        g.addEdge(2, 3, 1);
        g.addEdge(3, 1, 1);
        g.addEdge(1, 4, 2);
        g.addEdge(3, 4, 5);

        int min_distance = g.primsMST();
        System.out.println("Minimum distance is " + min_distance);

    }

    public int primsMST() {
        int[] distance = new int[vertex];
        boolean[] visited = new boolean[vertex];
//                                                    Lambda comparator
        PriorityQueue<Pair> pq = new PriorityQueue<>((p1, p2) -> p1.wt - p2.wt);
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[0] = 0;
        pq.add(new Pair(0, 0));
        int ans = 0;

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            if (visited[curr.v]) continue;
            visited[curr.v] = true;
            ans += distance[curr.v];
            for (Pair neighbor : adj.get(curr.v)) {
                if (!visited[neighbor.v] && distance[neighbor.v] > neighbor.wt) {
                    distance[neighbor.v] = neighbor.wt;
                    pq.add(new Pair(neighbor.v, distance[neighbor.v]));
                }
            }
        }
        for (int e:distance) {
            System.out.println(e);
        }

        return ans;
    }
    public void addEdgeUndirected(int src, int destination, int wt) {
        adj.get(src).add(new Pair(destination, wt));
        adj.get(destination).add(new Pair(src, wt));
    }
    public int dijkstra(int src) {
        int[] distance = new int[vertex];
        boolean[] visited = new boolean[vertex];
        PriorityQueue<Pair> pq = new PriorityQueue<>((p1, p2) -> p1.wt - p2.wt);
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[src] = 0;
        pq.add(new Pair(src, 0));


        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            if (visited[curr.v]) continue;
            visited[curr.v] = true;
            for (Pair neighbor : adj.get(curr.v)) {
                if (!visited[neighbor.v] && distance[neighbor.v] > distance[curr.v]+neighbor.wt) {
                    distance[neighbor.v] = distance[curr.v]+neighbor.wt;
                    pq.add(new Pair(neighbor.v, distance[neighbor.v]));
                }
            }
        }
        for (int e : distance) {
            System.out.println(e);
        }
        return distance[vertex - 1];
    }

}
