public class practice7 {
    public static int crosingCount(int[] arr){
        int T= arr.length;
        int count= 0;

        for(int i= 0 ; i<T; i++){
            int N= arr[i];
            if(N==0){
                for(int j=i ; j<T; j++){
                    int S=arr[j];
                    if(S== 1){
                        count++;
                    }
                }
            }
        }

        return count;
    }
    public static void main( String[] args){
        int[] arr= {0 , 1 , 0 , 1 , 1};
        int output = crosingCount(arr);
        System.out.println(output);
    }
}
