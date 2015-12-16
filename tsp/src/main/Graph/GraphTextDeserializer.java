package Graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GraphTextDeserializer {

    public Graph load(String file) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(file));
        boolean directed = sc.nextBoolean();
        int size = sc.nextInt();
        Graph g = new Graph_AdjMatrix(directed, size);
        int edges = sc.nextInt();
        for(int i = 0; i< edges; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            double distance = sc.nextDouble();
            //check if graph is directed or not
            g.addEdge(from, to, distance);
        }
        sc.close();
        return g;
    }
}
