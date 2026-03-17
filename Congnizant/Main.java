import java.util.*;

class Solution {
    // Helper method to calculate factorial
    public long factorial(int n) {
        long fact = 1;
        for(long i = 2; i<=n; i++) fact*=i;
        return fact;

    }

    public long maxPermutation(String[] arr, int N) {
        int maxlen = 0 ;
        for(String s: arr){
            String str= s.replaceAll("(?i)[aeiou]","");
            maxlen= Math.max(maxlen, str.length());
        }
        return maxlen== 0? 0: factorial(maxlen);
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: Only vowels
        String[] arr1 = {"eio", "ae", "ou"};
        System.out.println("Test 1 (Only Vowels) | Expected: 0 | Actual: " + solution.maxPermutation(arr1, arr1.length));
        System.out.println("--------------------------------------------------");

        // Test Case 2: "hello" -> "hll" (3 consonants) -> 3! = 6
        String[] arr2 = {"hello"};
        System.out.println("Test 2 (hello) | Expected: 6 | Actual: " + solution.maxPermutation(arr2, arr2.length));
        System.out.println("--------------------------------------------------");

        // Test Case 3: "strength" -> "strngth" (7 consonants) -> 7! = 5040
        String[] arr3 = {"strength", "power"}; 
        // "power" -> "pwr" (3) -> 6
        // "strength" is the max (7) -> 5040
        System.out.println("Test 3 (Max Consonants) | Expected: 5040 | Actual: " + solution.maxPermutation(arr3, arr3.length));
    }
}
