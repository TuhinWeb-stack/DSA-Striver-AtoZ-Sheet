import java.util.Scanner;

public class practice17 {
    public static void main( String [] args){
        
        int N= 4;
        int [] values= {1,2,4,3};
        int end= 3;

        int count= 0;

        
          count=  factorial(values.length-2)* factorial(values.length-2)+ values.length-1;

          System.out.println(count);
        
    }
    public static int factorial(int n){
        int fac= 1;
        for(int i = 2 ;i<=n; i++){
            fac*= i;
        }
        return fac;
    }
}