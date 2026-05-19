import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class practice12 {
    public static int properSum( int N , int[]arr){
        int sum=0;

        Map <Integer, Integer> element = new HashMap<>();
        for(int i=0 ; i<N; i++){
            if(element.containsKey(arr[i])){
                arr[i]= arr[i]+1;
            }
            else{
                element.put(arr[i], i);
            }
        }
        for(int j=0 ; j< arr.length; j++ ){
            sum+= arr[j];
        }


        return sum;
    }
    public static void main( String[] args){
        Scanner sc= new Scanner(System.in);
        int N= sc.nextInt();
        int[] arr= new int[10];
        for(int i= 0 ; i<N ; i++){  
        arr[i]= sc.nextInt();
        }
        int output= properSum(N, arr);
        System.out.println(output);
    }
}
