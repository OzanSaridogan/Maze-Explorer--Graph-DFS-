import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DGraph {

    private int V;
    public List<List<Integer>> adj;
    private Map<Integer, Character> intToChar;
    
    DGraph(int V) {
        this.V = V;
        intToChar = new HashMap<>();

        adj = new ArrayList<>(V);

        for (int v = 0; v < V; v++) {
            adj.add(new ArrayList<>());
        }
    }
    
    int size() {
    	return this.V;
    }

    void addEdge(int v, int w, char charV, char charW) {
        adj.get(v).add(w);
        adj.get(w).add(v); // Add the reverse edge
        intToChar.put(v, charV);
        intToChar.put(w, charW);
    }


    char getChar(int index) {
        return intToChar.getOrDefault(index, '-');
    }

    void printGraph() {
        for (int v = 0; v < V; v++) {
            System.out.print(getChar(v) + " -> ");
            for (Integer neighbor : adj.get(v)) {
                System.out.print(getChar(neighbor) + " ");
            }
            System.out.println();
        }
    }
    
    

    

    

    void printAllPaths(List<List<Integer>> paths) {
        System.out.println("Paths are:");

        for (int i = 0; i < paths.size(); i++) {
            System.out.println((i + 1) + ") " + pathToString(paths.get(i)));
        }
    }



    private String pathToString(List<Integer> path) {
        StringBuilder sb = new StringBuilder();

        for (int i : path) {
            sb.append(getChar(i));
        }

        return sb.toString();
    }


}
