class StringContainsAllBinaryCodes1461 {
    public boolean hasAllCodes(String s, int k) {
        int need = 1 << k;
        boolean[] got = new boolean[need];
        
        int subHash = 0;
        int allOne = need-1;
        for(int i = 0; i < s.length(); i++){
            //s=101110, k = 2
            //101 -> 1010 & 111 -> 010 + 1
            subHash = (subHash << 1) & allOne | (s.charAt(i) - '0');
            if(i >= k-1 && !got[subHash]){
                got[subHash] = true;
                need-=1;
                if(need == 0) return true;
            }
        }
        return false;
    }
    
    /*
    //O(NK) space and time solution
    //use set to record all seen codes
    public boolean hasAllCodes(String s, int k) {
        int need = 1 << k;
        Set<String> got = new HashSet<>();
        
        for(int i = k; i <= s.length(); i++){
            String sub = s.substring(i-k, i);
            if(!got.contains(sub)){
                got.add(sub);
                need-=1;
                if(need == 0) return true;
            }
        }
        return false;
    }
    */
}

