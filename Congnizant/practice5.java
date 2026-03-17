import java.util.PriorityQueue;
import java.util.Scanner;

public class practice5 {
    public static int minimumCost(int[] arr){
        int r= arr.length;
        int cost= 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0 ; i<r; i++){
            pq.add(arr[i]);
        }

        while(pq.size()>1){
            int first = pq.poll();
            int second= pq.poll();
            
            int merged= first+ second;
            pq.add(merged);
            cost+= merged;
        }
        return cost;
    }       
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int[] arr= new int[n];

        for(int i=0 ; i<n; i++){
            arr[i]= sc.nextInt();
        }
        int output= minimumCost(arr);
        System.out.println(output);
    }
    
}
