import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	Scanner scan = new Scanner(System.in);
    	String fileName = scan.nextLine();
    	
    	
        Maze1 maze = new Maze1();
        char[][] maze2 = maze.buildMaze(fileName);

        DGraph graph = new DGraph(maze.getColumns() * maze.getRows());

        for (int i = 0; i < maze.getRows(); i++) {
            for (int j = 0; j < maze.getColumns(); j++) {
                if (j < maze.getColumns() - 1) {
                    graph.addEdge(i * maze.getColumns() + j, i * maze.getColumns() + (j + 1),
                            maze2[i][j], maze2[i][j + 1]);
                }
                if (i < maze.getRows() - 1) {
                    graph.addEdge(i * maze.getColumns() + j, (i + 1) * maze.getColumns() + j,
                            maze2[i][j], maze2[i + 1][j]);
                }
            }
        }

       // graph.printGraph();
        DFS dfs = new DFS(graph);

        int startVertex = findStartVertex(maze2);
        List<List<Integer>> paths = dfs.findAllPaths(graph, startVertex);

        // Print all paths
        System.out.println(paths.size()+" treasures are found.");
        if(paths.size()!=0) {
        	graph.printAllPaths(paths);
        }
        
    }

    private static int findStartVertex(char[][] maze) {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                if (maze[i][j] != '+' && maze[i][j] != '-' && maze[i][j] != '|') {
                    return i * maze[0].length + j;
                }
            }
        }
        return -1; // Return -1 if no valid starting vertex is found
    }
}
