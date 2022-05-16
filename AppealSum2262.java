class AppealSum2262 {
    public long appealSum(String s) {
        List<List<Integer>> charactersPosition = new ArrayList<>();
        for(int i = 0; i < 26; i++){
            charactersPosition.add(new ArrayList<>());
        }
        for(int i = 0; i < s.length(); i++){
            charactersPosition.get(s.charAt(i)-'a').add(i);
        }
        long res = 0;
        for(List<Integer> positions : charactersPosition){
            if(positions.size() == 0) continue;
            //prefix sum array
            int pos = positions.get(0);
            res += (pos+1)*(s.length()-pos);
            for(int i = 1; i < positions.size(); i++){
                res += (positions.get(i) - positions.get(i-1))*
                    (s.length() - positions.get(i));
            }
        }
        return res;
    }
}
