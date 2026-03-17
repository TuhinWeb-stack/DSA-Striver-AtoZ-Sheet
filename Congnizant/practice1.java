import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class practice1 {
    public static int freqOfMaxAlphabates(int N , String s){
        Map <Character , Integer> freq= new HashMap<>();
        Map<Integer , Integer> freqOfFreq= new HashMap<>();

        for(char c: s.toCharArray()) freq.put(c , freq.getOrDefault(c,0)+1);
        for(int num: freq.values()) freqOfFreq.put(num, freqOfFreq.getOrDefault(num,0)+1);

        int maxCountFreq= -1;
        int minimumKeyVal= Integer.MAX_VALUE;

        for(Map.Entry<Integer, Integer> e : freqOfFreq.entrySet()){
            int currkey= e.getKey();
            int currVal= e.getValue();

            if(currVal>maxCountFreq||(currVal== maxCountFreq&& currkey <minimumKeyVal)){
                minimumKeyVal= currkey;
                maxCountFreq= currVal;
            }
        }
        return minimumKeyVal;
    }
    public static void main (String[] args){
        Scanner sc= new Scanner(System.in);
        int input1= sc.nextInt();

        sc.nextLine();
        String input2= sc.nextLine();
        
        int output= freqOfMaxAlphabates(input1, input2);
        System.out.println(output);
    }
}
