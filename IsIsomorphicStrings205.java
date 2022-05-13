class IsIsomorphicStrings205 {
    public boolean isIsomorphic(String s, String t) {
        int[] convert = new int[128];
        Set<Integer> used = new HashSet<>();
        for(int i = 0; i < 128; i++){
            convert[i] = -1;
        }
        for(int i = 0; i < s.length(); i++){
            if(convert[(int)s.charAt(i)] == -1){
                if(!used.contains((int)t.charAt(i))){
                    convert[(int)s.charAt(i)] = (int)t.charAt(i);
                    used.add((int)t.charAt(i));
                }
                else
                    return false;
            }
            else{
                if(convert[(int)s.charAt(i)] != (int)t.charAt(i)){
                    return false;
                }
            }
        }
        return true;
    }
}
