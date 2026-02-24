import java.util.*;

public class Prims {

    static int spanningTree(int V, int[][] edges) {

        int E = edges.length;

        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];

            adj.get(u).add(new int[]{w, v});
            adj.get(v).add(new int[]{w, u});
        }

        boolean[] visited = new boolean[V];

        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> a[0] - b[0]
        );

        pq.add(new int[]{0, 0});  
        int minCost = 0;

        while (!pq.isEmpty()) {

            int[] top = pq.poll();
            int wi = top[0];
            int ui = top[1];

            if (visited[ui]) continue;

            minCost += wi;
            visited[ui] = true;

            for (int[] neighbor : adj.get(ui)) {
                int currW = neighbor[0];
                int vi = neighbor[1];

                if (!visited[vi]) {
                    pq.add(new int[]{currW, vi});
                }
            }
        }

        return minCost;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices and edges: ");
        int V = sc.nextInt();
        int E = sc.nextInt();

        int[][] edges = new int[E][3];

        System.out.println("Enter edges (u v weight):");
        for (int i = 0; i < E; i++) {
            edges[i][0] = sc.nextInt();
            edges[i][1] = sc.nextInt();
            edges[i][2] = sc.nextInt();
        }

        int result = spanningTree(V, edges);
        System.out.println("Weight of MST: " + result);

        sc.close();
    }
}
