class Solution {
    public boolean rotateString(String A, String B) {
        boolean res = false;
        if(A.length() != B.length()) return false;
        else if(A.length() == 0) return true;
        for(int i = 0; i < A.length();i++){
            if(A.charAt(i) == B.charAt(0)){
                int offset = 0;
                res = true;
                for(int j = 1; j < B.length(); j++){
                    if(A.charAt((i+j)%A.length()) != B.charAt(j)){
                        res = false;
                        System.out.println("fasle at A in: "+(i+j)%A.length()+" and B in: "+j);
                        offset = j;
                        break;
                    }
                    if(j == B.length()-1) return true;
                }
                i+=offset-1;
            }
        }
        
        return res;
    }
}