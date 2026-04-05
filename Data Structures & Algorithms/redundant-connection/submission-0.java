class Solution {

    int[] parent;

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        parent = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for (int[] e : edges) {
            int a = e[0];
            int b = e[1];

            if (find(a) == find(b)) {
                return e;
            }

            parent[find(a)] = find(b);
        }

        return new int[0];
    }

    int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
}
