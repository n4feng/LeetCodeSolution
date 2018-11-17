class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> result=new ArrayList<>();
        
        if(n==0)
        {
            result.add(0);
            return result;
        }
        result.add(0);
        result.add(1);
        int ptr=1;

        while(ptr<n){
            for(int i=result.size()-1;i>=0;i--){
                result.add((1<<ptr)+result.get(i));
            }
            ptr++;
        }
        return result;
    }
}