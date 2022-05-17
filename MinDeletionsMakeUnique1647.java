class MinDeletionsMakeUnique1647 {
    public int minDeletions(String s) {
        int[] freq = new int[26];
        for(int i = 0; i < s.length(); i++){
            freq[s.charAt(i)-'a'] +=1;
        }
        Set<Integer> appear = new HashSet<>();
        //d[0] stands for character, d[1] stands for count
        List<Integer> duplicated = new ArrayList<>();
        for(int i = 0; i < 26; i++){
            if(freq[i] > 0){
                if(!appear.contains(freq[i])){
                    appear.add(freq[i]);
                }
                else{
                    duplicated.add(freq[i]);
                }
            }
        }
        Collections.sort(duplicated);
        int nextEmpty = Integer.MAX_VALUE;
        int res = 0;
        while(!duplicated.isEmpty()){
            int needRemove = duplicated.remove(duplicated.size()-1);
            nextEmpty = Math.min(nextEmpty, needRemove-1);
            while(appear.contains(nextEmpty)){
                nextEmpty--;
            }

            if(nextEmpty == 0) {
                //remove all this character
                res += needRemove;
            }
            else{
                res += needRemove - nextEmpty;
                nextEmpty--;
            }
        }
        return res;
    }
}
