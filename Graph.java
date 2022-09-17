
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Graph {

    private int[][] matrix;
    private int edgesQntd;
    private int VerticesIsoleted;
    private Scanner sc;
    private int verticesQntd;

    public Graph(Scanner file) {
        this.sc = file;
        this.directedGraph();
    }

    public int[][] matrix() {
        return this.matrix;
    }

    public int getedgesQntd() {
        return edgesQntd;
    }

    public int getverticesQntd() {
        return verticesQntd;
    }

    public int getVerticesIsoleted() {
        return VerticesIsoleted;
    }

    private int[][] addMatrixValues(int[][] matrix, Scanner file) {
        while (file.hasNextLine()) {
            String line = file.nextLine();
            String[] array = line.split(" ");
            int verticeOrigem = Integer.parseInt(array[0]);
            int verticeDestino = Integer.parseInt(array[1]);
            matrix[verticeOrigem][verticeDestino] = 1;
        }
        return matrix;
    }

    public void getEntryDegree() {
        int count = 0;

        for (int i = 0; i < this.matrix.length; i++) {
            System.out.print("Grau de entrada de  " + i + " : ");
            for (int j = 0; j < this.matrix.length; j++) {
                if (this.matrix[j][i] != 0)
                    count++;
            }
            System.out.println(count);
            count = 0;
        }
    }

    private void directedGraph() {
        this.verticesQntd = Integer.parseInt(this.sc.nextLine());
        this.edgesQntd = Integer.parseInt(this.sc.nextLine());
        this.matrix = new int[this.verticesQntd][this.edgesQntd];

        this.matrix = addMatrixValues(this.matrix, this.sc);
        this.VerticesIsoleted = countVerticesIsolados();
    }

    private int countVerticesIsolados() {
        boolean isIsolated;
        int count = 0;

        for (int i = 0; i < this.matrix.length; i++) {
            isIsolated = true;
            for (int j = 0; j < this.matrix.length; j++) {
                if (this.matrix[i][j] == 1 || this.matrix[j][i] == 1)
                    isIsolated = false;
            }
            if (isIsolated == true)
                count++;
        }
        return count;
    }

    public static void main(String[] args) throws Exception {
        Graph graph;
        int[][] adjacencyMatrix;
        int edgesQqntd, verticesQntd, isolatedVertices;

        graph = new Graph(readFile());
        adjacencyMatrix = graph.matrix();
        edgesQqntd = graph.getedgesQntd();
        verticesQntd = graph.getverticesQntd();
        isolatedVertices = graph.getVerticesIsoleted();

        System.out.println();
        showAdjacencyMatrix(adjacencyMatrix);
        System.out.println();
        System.out.println("Ordem do grafo: " + edgesQqntd);
        System.out.println("Tamanho do grafo: " + verticesQntd);
        System.out.println("Grau de entrada do grafo: ");
        graph.getEntryDegree();
        System.out.println();
        System.out.println("Número dos vértices isolados: " + isolatedVertices);

    }

    private static Scanner readFile() throws FileNotFoundException {
        String file = "pequenoG.txt";
        FileReader reader = new FileReader(file);
        return new Scanner(reader).useDelimiter("\\n");
    }

    private static void showAdjacencyMatrix(int[][] adjacencyMatrix) {
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            for (int j = 0; j < adjacencyMatrix[0].length; j++) {
                System.out.print(adjacencyMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

}
