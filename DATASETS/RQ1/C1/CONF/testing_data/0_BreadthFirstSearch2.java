import java.util.*;

public class BFS {
    private int V; // number of vertices
    private LinkedList<Integer>[] adjList; // adjacency list

    // Constructor
    public BFS(int v) {
        V = v;
        adjList = new LinkedList[V];
        for (int i = 0; i < V; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    // Add edge to graph
    public void addEdge(int v, int w) {
        adjList[v].add(w);
    }

    // BFS traversal of the graph
    public void bfs(int s) {
        // Mark all the vertices as not visited
        boolean[] visited = new boolean[V];

        // Create a queue for BFS
        LinkedList<Integer> queue = new LinkedList<>();

        // Mark the current node as visited and enqueue it
        visited[s] = true;
        queue.add(s);

        while (!queue.isEmpty()) {
            // Dequeue a vertex from queue and print it
            s = queue.poll();
            System.out.print(s + " ");

            // Get all adjacent vertices of the dequeued vertex s. If an adjacent has not been visited, mark it visited and enqueue it
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

    // Main method to test BFS
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



// In this program, we first define the BFS class, which has instance variables for the number of vertices in the graph and an array of linked lists to represent the adjacency list. The addEdge method adds an edge to the graph by appending the destination vertex to the list of the source vertex.

// The bfs method performs a breadth-first search of the graph, starting from the given source vertex s. It first initializes a boolean array to keep track of visited vertices, and a queue to store the vertices that have been discovered but not yet explored. It then marks the source vertex as visited and adds it to the queue. The method then enters a loop that continues until the queue is empty. In each iteration of the loop, the method dequeues a vertex from the queue and prints it. It then adds all of its unvisited neighbors to the queue and marks them as visited. Finally, when the queue is empty, the BFS is complete.

// In the main method, we create an instance of the BFS class and add edges to the graph. We then call the bfs method with a starting vertex of 2 and print the result. The output of the program will be:


// BFS starting from vertex 2:
// 2 0 3 1

