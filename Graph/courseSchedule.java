import java.util.*;

class courseSchedule{
    public boolean canFinish (int numcourses , int[][] prerequisites){
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i= 0; i<numcourses; i++){
            adj.add(new ArrayList<>());
        }
        for(int i= 0; i< prerequisites.length; i++){
            int course= prerequisites[i][0];
            int preq= prerequisites[i][1];
            adj.get(preq).add(course);
        }
        int[] vis= new int [numcourses];
        int[] pass= new int [numcourses];
        for(int startNode=0; startNode<numcourses; startNode++){
            if(vis[startNode]==0){
                if(dfs(startNode , adj , vis , pass )){
                return false;
                }
            }
            
        } 
        return true;
    }
    private boolean dfs(int node , ArrayList<ArrayList<Integer>> adj , int[] vis , int[] pass){
        vis[node]= 1;
        pass[node]= 1;

        for(int neighbour : adj.get(node)){
            if(vis[neighbour]==0){
                if(dfs(neighbour, adj, vis, pass)){
                    return true;
                }
            }
            else if(pass[neighbour]==1){
                return true;
            }
        }
        pass[node]= 0;
        return false;
    }
    public static void main(String[] args) {
        courseSchedule solver = new courseSchedule();

        System.out.println("--- RUNNING LEETCODE EXAMPLE TESTS ---");

        // -------------------------------------------------------------
        // TEST CASE 1: No Cycles (Should return true)
        // Input: numCourses = 2, prerequisites = [[1,0]]
        // -------------------------------------------------------------
        int numCourses1 = 2;
        int[][] prerequisites1 = {
            {1, 0}
        };
        
        boolean result1 = solver.canFinish(numCourses1, prerequisites1);
        System.out.println("Example 1 Result: " + result1 + " (Expected: true)");


        // -------------------------------------------------------------
        // TEST CASE 2: Deadlock Cycle Detected (Should return false)
        // Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
        // -------------------------------------------------------------
        int numCourses2 = 2;
        int[][] prerequisites2 = {
            {1, 0},
            {0, 1}
        };
        
        boolean result2 = solver.canFinish(numCourses2, prerequisites2);
        System.out.println("Example 2 Result: " + result2 + " (Expected: false)");
    }
}