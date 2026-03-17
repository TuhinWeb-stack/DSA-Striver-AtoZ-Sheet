import java.util.Scanner;

public class practice3 {
    public static int substrCount(String s){
        int count= 0;
        int n= s.length();
        int i=0;

        while( i<n){
            if(Character.isDigit(s.charAt(i))){
                int start= i;
                while(i<n && Character.isDigit(s.charAt(i)))i++;
                int end=i-1;
                if(start>0 && end<n-1 && Character.isLetter(s.charAt(start-1)) && Character.isLetter(s.charAt(end+1)) ){
                    count++;
                }
            }
            else{
                i++;
            }
        }
        return count;
    }
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        String s= sc.nextLine();
        int output= substrCount(s);

        System.out.println(output);
        
    }
    
}
