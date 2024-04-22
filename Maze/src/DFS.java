import java.util.ArrayList;
import java.util.List;

public class DFS {
    private boolean[] visited;
    private DGraph graph;
    private static char treasure = 'E';
    private static char wall = '+';
    private static char wall1 = '-';
    private static char wall2 = '|';

    DFS(DGraph graph) {
        this.graph = graph;
        visited = new boolean[graph.size()];
    }

    public List<List<Integer>> findAllPaths(DGraph graph, int source) {
        visited[source] = true;

        List<List<Integer>> allPaths = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(source);

        findAllPathsUtil(source, allPaths, path, 0);

        return allPaths;
    }

    private void findAllPathsUtil(int source, List<List<Integer>> allPaths, List<Integer> path, int depth) {
        if (graph.getChar(source) == treasure) {
            allPaths.add(new ArrayList<>(path));
            visited[source] = false; // Reset the visited status to explore other paths
            return;
        }

        if (depth >= graph.size()) {
            visited[source] = false; // Reset the visited status for backtracking
            return;
        }

        List<Integer> adjacents = graph.adj.get(source);

        for (Integer next : adjacents) {
            if (!visited[next] && isPath(graph, source, next)) {
                path.add(next);
                visited[next] = true;
                findAllPathsUtil(next, allPaths, path, depth + 1);
                path.remove(path.size() - 1); // Backtrack
            }
        }

        visited[source] = false; // Reset the visited status for backtracking
    }

    private boolean isPath(DGraph graph, int current, int next) {
        char charNext = graph.getChar(next);
        return charNext != wall && charNext != wall1 && charNext != wall2;
    }
}
