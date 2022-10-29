import java.util.Stack;

public class Doubts extends graphs2 {
    public Doubts(int v) {
        super(v);
    }

    public static void dfs_using_stack(int src, boolean[] visited){
        Stack<Integer> stack = new Stack<>();
        stack.push(src);
        while(!stack.isEmpty()){
            int curr = stack.pop();
            if(!visited[curr]){
                visited[curr] = true;
                System.out.println(curr);
                for(Integer neighbour : a.get(curr)){
                    if(!visited[neighbour]){
                        stack.push(neighbour);
                    }
                }
            }
        }

    }
}
