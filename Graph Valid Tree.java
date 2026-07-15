class Solution {
    public boolean validTree(int n, int[][] edges) {

        // A tree must have exactly n-1 edges
        if (edges.length != n - 1)
            return false;

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // Build undirected graph
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];

        dfs(0, graph, visited);

        // Check if all nodes are connected
        for (boolean v : visited) {
            if (!v)
                return false;
        }

        return true;
    }

    private void dfs(int node, List<List<Integer>> graph, boolean[] visited) {
        if (visited[node])
            return;

        visited[node] = true;

        for (int neighbor : graph.get(node)) {
            dfs(neighbor, graph, visited);
        }
    }
}
