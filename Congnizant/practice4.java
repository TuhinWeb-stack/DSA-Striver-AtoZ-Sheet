import java.util.Scanner;

public class practice4 {
    public static void riskManagement(int[] arr){
        int n= arr.length;
        int start= 0;
        int mid= 0;
        int end= n- 1;

        while(mid<=end){
            if(arr[mid]==0){
                swap(arr, mid , start);
                start++;
                mid++;
            }
            else if(arr[mid]==1){
                mid++;
            }
            else{
                swap(arr, mid, end);
                end--;
            }
        }
    }    
    public static void swap(int [] arr ,int start, int end){
        int temp= arr[start];
        arr[start]= arr[end];
        arr[end]= temp;
    }
 public static void main(String[] args) {
    Scanner sc= new Scanner(System.in);
    int n= sc.nextInt();
    int[] arr= new int [n];
    for(int i=0; i<n; i++){
        arr[i]= sc.nextInt();
    }
    riskManagement(arr);
    for(int i=0 ; i<n; i++){
        System.out.print(arr[i]);
    }
 }
    
}
