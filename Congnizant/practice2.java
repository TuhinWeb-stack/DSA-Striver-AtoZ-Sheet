import java.util.Scanner;

public class practice2 {
    public static int totalHeightSum(int N , int[]arr, int D){
        int totalSum= 0;

        for(int i=0 ; i<N; i++){
            boolean leftOk= (i-D)<0 || arr[i]>arr[i-D];
            boolean rightOk= (i+D)>=N || arr[i]>arr[i+D];

            if(leftOk&& rightOk){
                totalSum+= arr[i];
            }
        }
        return totalSum;
    }
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        int input1= sc.nextInt();
        int[] input2= new int[input1];
        for(int i=0 ; i<input1; i++){
            input2[i]= sc.nextInt();
        }
        int input3= sc.nextInt();

        int output= totalHeightSum(input1, input2, input3);
        System.out.println(output);
    }
    
}
