class maxProductWordLength318 {
    public int maxProduct(String[] words) {
        int ans = 0;
        for(int i = 0; i < words.length; i++){
            for(int j = i+1; j < words.length; j++){
                if(noCommonLetters(words[i], words[j])){
                    ans = Math.max(ans, words[i].length()*words[j].length());
                }
            }
        }
        return ans;
    }
    
    public boolean noCommonLetters(String s1, String s2){
        //bit masking
        int bitmask1 = 0, bitmask2 = 0;
        for (char c : s1.toCharArray())
            bitmask1 |= 1 << ((int)c - (int)'a');
        for (char c : s2.toCharArray())
            bitmask2 |= 1 << ((int)c - (int)'a');
        return (bitmask1 & bitmask2) == 0;
    }
}
