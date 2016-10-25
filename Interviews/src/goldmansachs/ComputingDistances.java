package goldmansachs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author: basavakanaparthi
 * on 10,Oct,2016 at 10:33 AM.
 */
public class ComputingDistances {
    static class GraphNode
    {
        private int V;
        private LinkedList<GraphNode> adjacencyList;

        GraphNode(int V, LinkedList<GraphNode> adjacencyList)
        {
            this.V = V;
            this.adjacencyList = adjacencyList;
        }
        GraphNode(int V)
        {
            this.V = V;
            this.adjacencyList = new LinkedList<>();
        }
        public void setAdjacencyList(LinkedList<GraphNode> adjacencyList)
        {
            this.adjacencyList = adjacencyList;
        }
        public boolean addEdge(GraphNode g)
        {
            if (adjacencyList == null)
                adjacencyList = new LinkedList<>();
            return adjacencyList.add(g);
        }

        public int getV()
        {
            return V;
        }
        @Override
        public String toString()
        {
            return String.valueOf(V);
        }
    }
    public static int BFSPath(GraphNode root, int n)
    {
        Queue<GraphNode> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        int[] dist = new int[n];
        visited[root.getV()] = true;
        dist[root.getV()] = 0;
        queue.add(root);
        int distance = 0;
        while (!queue.isEmpty())
        {
            // System.out.println(distance + " " + n);
            GraphNode curr = queue.poll();
            System.out.print(curr.getV() + "-->");
            if (curr.getV() == n-1)
                return dist[curr.getV()];

            for (GraphNode g: curr.adjacencyList)
            {
                // System.out.print(g.getV() + " -->");
                if (g.getV() == n-1)
                {
                    System.out.println(g.getV() + "\nDistance: " + (1 +
                            dist[curr
                            .getV()]));
                    return 1 + dist[curr.getV()];
                }
                if (!visited[g.getV()]) {
                    queue.add(g);
                    dist[g.getV()] = 1 + dist[curr.getV()];
                }
            }
        }
        return -1;
    }

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int v = in.nextInt();
        in.nextLine();
        GraphNode[] graphNodes= new GraphNode[v];
        for (int i = 0; i < v; i++)
        {
            graphNodes[i] = new GraphNode(i);
        }
        for (int i = 0; i < v; i++)
        {
            String[] values = in.nextLine().trim().split(" ");
            int nodeInd = Integer.valueOf(values[0]);
            LinkedList<GraphNode> neighbors = new LinkedList<>();
            for (int j = 1; j < values.length; j++)
            {
                neighbors.add(graphNodes[Integer.valueOf(values[j])]);
            }
            System.out.println("Node: " + graphNodes[nodeInd] + " Neighbors: " +
                    "" + neighbors.toString());
            graphNodes[nodeInd].setAdjacencyList(neighbors);
        }
        System.out.println(BFSPath(graphNodes[0],v));
    }
}
