import java.util.*;

public class graphs2 {

    static ArrayList<ArrayList<Integer>> a = new ArrayList<ArrayList<Integer>>();
    int v;

    public graphs2(int v) {
        this.v = v;
        for (int i = 0; i < v; i++) {
            a.add(new ArrayList<Integer>());
        }
    }

    public void add_edge(int src, int dest) {
        a.get(src).add(dest);
        a.get(dest).add(src);
    }

    public static void dfs(int src, boolean[] vist) {
        vist[src] = true;
//        System.out.println(src+"");
        for (Integer neighbour : a.get(src)) {
            if (!vist[neighbour])
                dfs(neighbour, vist);
        }
    }

    public static void bfs(int src, boolean[] vist) {
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        vist[src] = true;
        while (!q.isEmpty()) {
            int curr = q.poll();
//            System.out.println(curr);
            for (Integer neighbour : a.get(curr)) {
                if (!vist[neighbour]) {
                    q.add(neighbour);
                    vist[neighbour] = true;
                }
            }
        }
    }

    public static int connected_components(int index, boolean[] vist) {
        int count = 0;
        for (int i = 0; i < 4; i++) {
            if (!vist[i]) {
                dfs(index, vist);
                count++;
            }
        }
        return count;
    }

    public static void new_bfs(int src, boolean[] vist, int[] distance) {
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        vist[src] = true;
//        distance[src] = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();

            for (Integer neighbor : a.get(cur)) {
                if (!vist[neighbor]) {
                    distance[neighbor] = distance[cur] + 1;
                    q.add(neighbor);
                    vist[neighbor] = true;
                }
            }
        }
    }

    public static boolean bipartite_graph(int src, boolean[] vist, int[] distance) {
        Queue<Integer> q = new LinkedList<>();
        int[] color = new int[4];
        q.add(src);
        vist[src] = true;
        distance[src] = 0;
        color[src] = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();

            for (Integer neighbor : a.get(cur)) {
                if (!vist[neighbor]) {
                    distance[neighbor] = distance[cur] + 1;
                    q.add(neighbor);
                    vist[neighbor] = true;
                    color[neighbor] = 1 ^ color[cur];
                    //1-color[cur]
                }
                else if(color[neighbor]==color[cur])
                    return false;
            }
        }
        return true;
    }

    public static boolean isCyclePresent(int src, boolean[] vist, int parent) {
        vist[src] = true;

        for (Integer neighbor : a.get(src)) {
            if (!vist[neighbor]) {
                if (isCyclePresent(neighbor, vist, src))
                    return true;
            } else if (neighbor != parent)
                return true;
        }
        return false;
    }


    public static void main(String[] args) {
        graphs2 g = new graphs2(4);
        g.add_edge(0, 4);
        g.add_edge(1, 0);
        g.add_edge(2, 1);
        g.add_edge(1, 3);
        boolean[] vist = new boolean[5];
//        dfs(0,vist);
//        bfs(0, vist);
//        dfs for every connected components
//        System.out.println(connected_components(0, vist));
//        shortest path
//        int[] dist = new int[4];
//        Arrays.fill(dist, Integer.MAX_VALUE);
//        new_bfs(0, vist, dist);
//
//        for (int i = 0; i < 4; i++) {
//            System.out.println(i+" "+dist[i]);
//        }
//        cycle detection
//        isCyclePresent()
        System.out.println(g.cycle_in_directed_graph());
    }


    //    doubts
    public static void dfs_using_stack(int src, boolean[] visited) {
        Stack<Integer> stack = new Stack<>();
        stack.push(src);
        visited[src] = true;

        while (!stack.isEmpty()) {
            int curr = stack.pop();
            if (!visited[curr]) {
                visited[curr] = true;
                System.out.println(curr);
                for (Integer neighbor : a.get(curr)) {
                    if (!visited[neighbor])
                        stack.push(neighbor);
                }
            }
        }
    }

    public ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();

    public boolean cycle_in_directed_graph() {
        boolean[] visited = new boolean[v];
        boolean[] recursive_stack = new boolean[v];

        for (int i = 0; i < v; i++) {
            if (!visited[i])
                if (dfs2(i, visited, recursive_stack))
                    return true;
        }
        return false;
    }

    public static boolean dfs2(int src, boolean[] visited, boolean[] recursive_stack) {
        visited[src] = true;
        recursive_stack[src] = true;

        for (int neighbor : a.get(src)) {
            if (!visited[neighbor])
                if (dfs2(neighbor, visited, recursive_stack))
                    return true;
                else if (recursive_stack[neighbor]) {
                    return true;
                }

        }
        recursive_stack[src] = false;
        return false;
    }

    static class Pair{
        int r, c;
        public Pair(int r, int c){
            this.r =r;
            this.c = c;
        }

    }
    public static boolean path_exits(int [][]a){
        int row = a.length;
        int col = a[0].length;
        Queue<Pair> q = new LinkedList<>();
        boolean[][] visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (a[i][j] == 1){
                    Pair src = new Pair(i,j);
                    q.add(src);
                    break;
                }
            }
        }
        while(!q.isEmpty()){
            Pair cur = q.poll();
            int x = cur.r;
            int y = cur.c;

//            to check if they are in bounds
            if(x == 0 || x>=row || y<0 || y>=col)
                continue;
//            to check if non visited and non wall
            if (visited[x][y] || a[x][y] == 0)
                continue;
//            to check is destination is found
            if(a[x][y] == 2)
                return true;
//           to mark this visited
            visited[x][y] = true;

//            upward direction
//            if(x-1>=0 && a[x-1][y]!=0 && !visited[x-1][y]){
//                visited[x-1][y] = true;
//                q.add(new Pair(x-1, y));
//            }
            q.add(new Pair(x-1, y));
            q.add(new Pair(x+1, y));
            q.add(new Pair(x, y-1));
            q.add(new Pair(x, y+1));
        }
        return false;
    }


}