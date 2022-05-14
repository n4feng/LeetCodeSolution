class DuplicateZeros1089 {
    public void duplicateZeros(int[] arr) {
        int newLength = 0;
        int till = 0;
        for(; newLength< arr.length; till++){
            if(arr[till] == 0) newLength+=2;
            else newLength+=1;
        }
        //revert the extra till++ due to for loop mechanism
        till--;
        //if last one is 2 zeros, but due to limit only 1 zero append
        if(newLength > arr.length){
            till--;
            arr[arr.length-1] = 0;
            fillArr(arr, till, arr.length-2);
        }
        else{
            fillArr(arr, till, arr.length-1);
        }
    }
    
    void fillArr(int[] arr, int till, int end){
        for(int i = end; i >= 0; i--){
            if(arr[till] == 0){
                arr[i--] = 0;
                arr[i] = 0;
            }
            else{
                arr[i] = arr[till];
            }
            till--;
        }
        return;
    }
}
