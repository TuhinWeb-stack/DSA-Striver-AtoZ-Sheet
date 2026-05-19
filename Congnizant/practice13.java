import java.util.Scanner;

public class practice13 {
    public static int transforToToggle( int n){
        String binary = Integer.toBinaryString(n);

        StringBuilder sb= new StringBuilder();
        for(char ch: binary.toCharArray()){
            int number= ch- '0';
            if(number== 0){
                sb.append(1);
            }
            else{
                sb.append(0);
            }
        }

        return Integer.parseInt(sb.toString(),2);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n<=100){
        int output= transforToToggle(n);
        System.out.println(output);
        }
        else{
            System.out.println("Wrong Input");
        }
        
    }
}
