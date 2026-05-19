import java.util.Scanner;

public class practice11 {
    public static int differenceSum(int[]arr ){
        int maxSum= Integer.MIN_VALUE;
        int n= arr.length;
        int r= r-1;
        int l= 0;
        /*int maximumSubarrayNum1= Integer.MIN_VALUE;
        int minimumSubarrayNum1= Integer.MAX_VALUE;
        int maximumSubarrayNum2= Integer.MIN_VALUE;
        int minimumSubarrayNum2= Integer.MAX_VALUE;*/

        while(r<n){
         for(int i= 0 ; i<=l; i++){
            int currentNum1= arr[i];
            int maximumSubarrayNum1= Math.max(currentNum1, maximumSubarrayNum1);
            int minimumSubarrayNum1= Math.min(currentNum1,minimumSubarrayNum1);
            int difference1= (maximumSubarrayNum1-minimumSubarrayNum1);
         }

            for(int j=l+1;j<=r; j++){
                int currentNum2= arr[j];
                int maximumSubarrayNum2= Math.max(currentNum2,maximumSubarrayNum2 );
                int minimumSubarrayNum2= Math.min(currentNum2, minimumSubarrayNum2);
                int difference2= (maximumSubarrayNum2-minimumSubarrayNum2);
            }
            l++;
            int sumOfDifference= difference1
            maxSum= Math.max(maxSum,sumDifference);
         }
        }
         return maxSum;
    }
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        int n= sc.nextInt();
        int[] arr= new int[n];
        for(int i=0 ; i<n; i++){
            arr[i]= sc.nextInt();
        }
        int output= differenceSum(arr);
        System.out.println(output);
    }
}
