
public class Main {
    
    private int V;
    
    private List<Integer>[] adj;

    public Main(int V) {
        this.V = V;
        
        adj = (ArrayList<Integer>[]) new ArrayList[V];
        
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<Integer>();
        }
    }

    
    public void addEdge(int v, int w) {
        adj[v].add(w);
    }

    
    public void DFS(int v, boolean[] visited) {
        
        visited[v] = true;
        System.out.print(v + " ");
        
        for (int i = 0; i < adj[v].size(); i++) {
            int n = adj[v].get(i);
            if (!visited[n]) {
                DFS(n, visited);
            }
        }
    }

    public static void main(String[] args) {
        
        Main g = new Main(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Following is Depth First Traversal");

        boolean[] visited = new boolean[4];
        g.DFS(2, visited);
    }
}
