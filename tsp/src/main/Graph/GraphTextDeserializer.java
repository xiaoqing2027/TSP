package Graph;

import java.util.Scanner;

public class GraphTextDeserializer {

    Scanner sc;

    public UndirectedGraph load(String file) {
        sc = new Scanner(new File(file));
        int size = sc.nextInt();
        UndirectedGraph g = new UndirectedGraph_AdjMatrix(size);
        int edges = sc.nextInt();
        for(int i = 0; i< edges; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            double distance = sc.nextDouble();
            g.addEdge(from, to, distance);
        }
        sc.close();
        return g;
    }
}
