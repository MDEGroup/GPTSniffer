import java.util.*;

public class BFS {
    private int V; 
    private LinkedList<Integer>[] adjList; 

    
    public BFS(int v) {
        V = v;
        adjList = new LinkedList[V];
        for (int i = 0; i < V; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    
    public void addEdge(int v, int w) {
        adjList[v].add(w);
    }

    
    public void bfs(int s) {
        
        boolean[] visited = new boolean[V];

        
        LinkedList<Integer> queue = new LinkedList<>();

        
        visited[s] = true;
        queue.add(s);

        while (!queue.isEmpty()) {
            
            s = queue.poll();
            System.out.print(s + " ");

            
            Iterator<Integer> i = adjList[s].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    
    public static void main(String[] args) {
        BFS g = new BFS(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("BFS starting from vertex 2: ");
        g.bfs(2);
    }
}













