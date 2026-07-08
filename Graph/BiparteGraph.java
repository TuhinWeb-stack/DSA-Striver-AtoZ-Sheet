import java.util.Arrays;

public class BiparteGraph {
    public boolean isBipartite(int[][] graph){
        int n= graph.length;
        int[] colour= new int [n];
        Arrays.fill(colour, -1);

        for(int i=0 ; i<n; i++){
            if(colour[i]==-1){
                if(dfsCheck(i , 0 , colour , graph)==false){
                    return false;
                }
            }
        }
        return true;
    }
    private boolean dfsCheck(int start , int currentColour , int[] colour , int[][]graph){
        colour[start]=currentColour;

        for(int neighbour : graph[start]){

            if(colour[neighbour]== -1){
                if(dfsCheck(neighbour,1- currentColour, colour, graph)== false){
                return false;
                }
            }
            else if(colour[neighbour]== currentColour){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        BiparteGraph solver = new BiparteGraph();

        System.out.println("--- RUNNING LEETCODE IS GRAPH BIPARTITE (BFS) ---");

        // -------------------------------------------------------------
        // LEETCODE EXAMPLE 1: Cycle of 3 nodes (Odd Cycle -> Expected: false)
        // -------------------------------------------------------------
        int[][] graph1 = {
            {1, 2, 3},
            {0, 2},
            {0, 1, 3},
            {0, 2}
        };
        boolean result1 = solver.isBipartite(graph1);
        System.out.println("Example 1 Result: " + result1 + " (Expected: false)");

        // -------------------------------------------------------------
        // LEETCODE EXAMPLE 2: Square graph (Even Cycle -> Expected: true)
        // -------------------------------------------------------------
        int[][] graph2 = {
            {1, 3},
            {0, 2},
            {1, 3},
            {0, 2}
        };
        boolean result2 = solver.isBipartite(graph2);
        System.out.println("Example 2 Result: " + result2 + " (Expected: true)");
    }
}
