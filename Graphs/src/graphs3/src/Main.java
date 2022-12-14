public class Main {
    public static void main(String[] args) {

        int v = 4;
        InDegree graph = new InDegree(v);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);

        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        for (int e : graph.indeg) {
            System.out.println(e);
        }
    }
}