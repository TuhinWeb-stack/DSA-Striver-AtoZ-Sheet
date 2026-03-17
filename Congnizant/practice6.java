import java.util.Scanner;

public class practice6 {
    public static int maxCount (int T , int[] E , int[] L){
        int count= Integer.MIN_VALUE;
        int currentMembers= 0;
        for(int i = 0 ; i<T; i++){
            currentMembers+= E[i]- L[i];
            count= Math.max(count, currentMembers);
        }

        return count;
    }
    public static void main( String[] args){
        Scanner sc= new Scanner(System.in);
        int T= sc.nextInt();
        int[] E= new int[T];
        int[] L= new int[T];
        for(int i = 0 ; i<T; i++){
            E[i]= sc.nextInt();
        }
        for(int j= 0 ; j<T; j++){
            L[j]= sc.nextInt();
        }
        int output= maxCount(T, E, L);
        System.out.println(output);
    }
}
