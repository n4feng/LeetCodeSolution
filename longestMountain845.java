class Solution {
    public int longestMountain(int[] A) {
        if(A.length < 3) return 0;
        int ascending = 0;
        
        int descending = 0;
        int result = 0;

        for(int i = 1; i < A.length; i++){
            if(A[i-1] == A[i]){
                ascending = 0;
                descending = 0;
            }
            if(A[i-1] < A[i]) ascending++;
            if(A[i-1] > A[i]) descending++;
            if(ascending > 0 && descending > 0){
				//the first element in the peak are actually not counted, so count it
                if(ascending + descending + 1 > result) result = ascending + descending + 1;
            }
            if(i < A.length -1){
                if(A[i-1] > A[i] && A[i] < A[i+1]){                
                    ascending = 0;
                    descending = 0;
                }
            }
            
        }
        return result;
    }
}