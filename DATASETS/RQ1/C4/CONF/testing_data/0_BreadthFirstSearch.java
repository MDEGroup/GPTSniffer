import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    
    private int V;
    
    private ArrayList<Integer>[] adj;

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

    
    public void BFS(int s) {
        
        Queue<Integer> queue = new LinkedList<Integer>();
        
        boolean[] visited = new boolean[V];
        
        visited[s] = true;
        queue.add(s);
        while (queue.size() != 0) {
            
            s = queue.poll();
            System.out.print(s + " ");
            
            
            for (int i = 0; i < adj[s].size(); i++) {
                int n = adj[s].get(i);
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
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

        System.out.println("Following is Breadth First Traversal");

        g.BFS(2);
    }
}







