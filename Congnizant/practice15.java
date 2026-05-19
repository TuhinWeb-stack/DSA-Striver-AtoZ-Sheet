import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class practice15 {
    public static List<List<Integer>> findSubarrray(int[]arr , int k){
        List<List<Integer>> result= new ArrayList<>();
        Map<Integer, List<Integer>> prefix = new HashMap<>();
        prefix.put(0,new ArrayList<>());
        prefix.get(0).add(-1);

        int currentSum= 0;
        for(int end=0 ; end<arr.length; end++){
            currentSum+= arr[end];
            int difference= currentSum-k;

            if(prefix.containsKey(difference)){
                List<Integer> previousIndexes= prefix.get(difference);

                for(int pastindex: previousIndexes){
                    int start = pastindex+1;
                    List<Integer> subArray= new ArrayList<>();
                    for(int i =start; i<=end;i++){
                        subArray.add(arr[i]);
                    }
                    result.add(subArray);
                }
            }
                prefix.putIfAbsent(currentSum,new ArrayList<>());
                prefix.get(currentSum).add(end);
            
        }
        return result;
    }
    public static void main( String[] args){
        int k= 7;
        int[] arr = {3,4,-7,1,3,3,1,-4};
        System.out.println(findSubarrray(arr, k));
    }
}
