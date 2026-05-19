import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class practice16 {
    public static String decryptCode(String str1, String str22){
        StringBuilder sb= new StringBuilder();
        Map<Character, Integer> map= new HashMap<>();
        map.put('A', 1);
        map.put('B', 2);
        map.put('C', 3);
        map.put('D', 4);
        map.put('E', 5);
        map.put('F', 6);
        map.put('G', 7);
        map.put('H', 8);
        map.put('I', 9);
        map.put('J', 10);
        map.put('K', 11);
        map.put('L', 12);
        map.put('M', 13);
        map.put('N', 14);
        map.put('O', 15);
        map.put('P', 16);
        map.put('Q', 17);
        map.put('R', 18);
        map.put('S', 19);
        map.put('T', 20);
        map.put('U', 21);
        map.put('V', 22);
        map.put('W', 23);
        map.put('X', 24);
        map.put('Y', 25);
        map.put('Z', 26);

        int minValue= Integer.MAX_VALUE;
        int maxValue= Integer.MIN_VALUE;
        int properkey= 0;

        String[] str2= str22.split("");

        for(int i= 0 ; i<str2.length; i++ ){
            int value= str2.charAt(i)- '0';
            minValue= Math.min(value , minValue);
            maxValue= Math.max(value, maxValue);
            minValue= maxValue-26;
            maxValue= minValue- 1;
        }
        
        for(char ch: str2.toCharArray()){
            if(map.get(ch)<maxValue&& map.get(ch)>minValue){
                properkey= map.get(ch);
            }
        }
        for(int i= 0 ; i<str2.length(); i++){
            int originalIndex= str2.charAt(i)- properkey;
            for(char ch: map.keySet()){
                if(map.get(ch)== originalIndex){
                    sb.append(ch);
                }
            }
        }


        return sb.toString();
    }
    public static void main( String [] args){
        Scanner sc= new Scanner(System.in);
        String str1= sc.nextLine();
        String str2= sc.nextLine();

        System.out.print(decryptCode(str1, str2));
    }
}
