import java.util.Scanner;

public class practice14 {
    public static long cubeSum(int n , int m){
        long currentSum= 0;
        
        for(long i= 4 ; i<=9; i++){
            currentSum+= i*i*i;
        }
        return currentSum;

    }
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        int input1= sc.nextInt();
        int input2= sc.nextInt();
        long output= cubeSum(input1, input2);
        System.out.println(output);
    }
}
