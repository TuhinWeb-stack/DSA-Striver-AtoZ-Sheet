import java.util.Scanner;

public class practice8 {
    public static int priceValue(int n){
        String value= Integer.toString(n);
        int price= 1;

        for(int i= 0 ; i<value.length();i++){
            int original= value.charAt(i)- '0';
            price*= original;
        }
        if(price== 1){
            return 0;
        }
        return price;
    }
    public static void main( String[] args){
        Scanner sc= new Scanner(System.in);
        int input= sc.nextInt();
        int result= priceValue(input);
        System.out.println(result);
    }
}
