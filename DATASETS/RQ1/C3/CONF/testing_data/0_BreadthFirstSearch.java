import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    // Number of vertices
    private int V;
    // Adjacency List
    private ArrayList<Integer>[] adj;

    public Main(int V) {
        this.V = V;
        // Create a new array of lists
        adj = (ArrayList<Integer>[]) new ArrayList[V];
        // Initialize each list
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<Integer>();
        }
    }

    // Function to add an edge to the graph
    public void addEdge(int v, int w) {
        adj[v].add(w);
    }

    // BFS traversal of the vertices reachable from v
    public void BFS(int s) {
        // Create a queue for BFS
        Queue<Integer> queue = new LinkedList<Integer>();
        // Mark all the vertices as not visited
        boolean[] visited = new boolean[V];
        // Mark the current node as visited and enqueue it
        visited[s] = true;
        queue.add(s);
        while (queue.size() != 0) {
            // Dequeue a vertex from queue and print it
            s = queue.poll();
            System.out.print(s + " ");
            // Get all adjacent vertices of the dequeued vertex s
            // If a adjacent has not been visited, then mark it visited and enqueue it
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
        // Create a graph
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



// This program uses an adjacency list to represent the graph and a BFS function to traverse the graph. BFS starts at a given vertex and visits all the vertices at the same level before moving on to the next level. The BFS function uses a queue data structure to keep track of the vertices to be visited.
// You can change the number of vertices in the graph by changing the value passed to the constructor of the Main class. You can also change the edges of the graph by calling the addEdge method.
// Please keep in mind that the above code is just an example, the number of vertex and edges can be modified as per requirement.

