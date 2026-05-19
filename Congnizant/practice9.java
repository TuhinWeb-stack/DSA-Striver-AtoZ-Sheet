import java.util.Scanner;

public class practice9 {
    public static String properTicket(String s){
        /* 
        StringBuilder sb= new StringBuilder();
        int n= s.length();
        for(int i= 0 ; i<n;i++){
            if(i+1<n&&s.charAt(i)==5&& s.charAt(i+1)==6){
                i++;
            } if(i+1<n&&s.charAt(i)=='E' && s.charAt(i+1)=='F'){
                i=i++;
            } if( s.charAt(i)== 'G' || s.charAt(i)=='&'){
                i++;
            }
            sb.append(s.charAt(i));
        }
        return sb.toString();
        */
       return s.replace("EF", "")
               .replace("56", "")
               .replace("G", "")
               .replace("&","");

    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String Str=sc.nextLine();
        System.out.print(properTicket(Str));
        
    }
}
