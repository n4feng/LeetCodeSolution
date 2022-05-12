class LongestRepeatingCharacterReplacement424 {
    public int characterReplacement(String s, int k) {
        int left=0, right = 0;
        int maxWindowSize = 0;
        int[] windowsCount = new int[26];
        while(right < s.length()){
            windowsCount[(int)(s.charAt(right) - 'A')]+=1;
            int mostCommon = findMostCommon(windowsCount);
            //# of all the character need to be changed in window
            //= len(window) - #mostCommon
            if(right - left +1 - windowsCount[findMostCommon(windowsCount)] <= k){
                if(right - left + 1 > maxWindowSize)
                    maxWindowSize = right - left + 1;
            }
            else{
                //move left 1 step forward
                while(right - left + 1 - windowsCount[findMostCommon(windowsCount)] > k){
                    windowsCount[(int)(s.charAt(left) - 'A')]-=1;
                    left+=1;
                }
            }
            right+=1;
        }
        return maxWindowSize;
    }
    
    public int findMostCommon(int[] count){
        int res=0, max = 0;
        for(int i = 0; i < 26; i++){
            if (count[i] > max){
                res = i;
                max = count[i];
            }
        }
        return res;
    }
    
}
