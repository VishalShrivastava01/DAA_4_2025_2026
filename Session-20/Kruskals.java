import java.util.*;

class DSU {
    int[] parent;
    int[] size;

    DSU(int n) {
        parent = new int[n];
        size = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;   
            size[i] = 1;     
        }
    }

    int find(int x) {
        if (parent[x] == x)
            return x;

        return parent[x] = find(parent[x]);
    }

    void unite(int x, int y) {
        int px = find(x);
        int py = find(y);

        if (px == py)
            return;

        if (size[px] < size[py]) {
            parent[px] = py;
            size[py] += size[px];
        } else {
            parent[py] = px;
            size[px] += size[py];
        }
    }
}

public class Kruskals {

    static int kruskalsMST(int V, int[][] edges) {

        Arrays.sort(edges, (a, b) -> a[2] - b[2]);

        DSU dsu = new DSU(V);
        int mstWeight = 0;

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];

            if (dsu.find(u) != dsu.find(v)) {
                mstWeight += wt;
                dsu.unite(u, v);
            }
        }

        return mstWeight;
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

        int result = kruskalsMST(V, edges);
        System.out.println("Weight of MST: " + result);

        sc.close();
    }
}
