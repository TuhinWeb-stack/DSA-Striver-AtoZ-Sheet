import java.util.Scanner;

public class practice10 {
    public static int equalMax(int n){
        int i=0;
        int j= n;
        int maxCount= 0;
        while(i<n){
            
            int count= (i+1)*(j+1);
            maxCount= Math.max(count, maxCount);
            i++;
            j--;
            
        } 
        return maxCount;
    }
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        int Input= sc.nextInt();
        int output=(equalMax(Input));
        System.out.println(output);
    }
}
