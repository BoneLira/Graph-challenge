
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.*;

class GFG {

    static void addEdge(LinkedList<LinkedList<Integer>> Adj, int u,
            int v) {
        // Creating unidirectional vertex
        Adj.get(u).add(v);
    }

    // Method 2
    // To print the adjacency List
    static void printadjacencylist(LinkedList<LinkedList<Integer>> adj) {
        String fileName = "pequenoG.txt";

        try {
            Scanner sc = new Scanner(new File(fileName));
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < adj.size(); ++i) {

            // Printing the head
            if (adj.get(i).size() != 0) {
                System.out.print(i + "->");
                for (int v : adj.get(i)) {

                    // Printing the nodes
                    System.out.print(v + " ");
                }

                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        // Creating vertex
        int V = 5;

        LinkedList<LinkedList<Integer>> adj = new LinkedList<LinkedList<Integer>>();

        for (int i = 0; i < V; ++i) {
            adj.add(new LinkedList<Integer>());
        }
        // Inserting nodes
        // Custom input elements
        addEdge(adj, 0, 1);
        addEdge(adj, 0, 4);
        addEdge(adj, 1, 2);

        // Printing adjacency List
        printadjacencylist(adj);
    }
}