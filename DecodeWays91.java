class Solution {
    public int numDecodings(String s) {
        if(s.length() == 0){
            return 1;
        }
        else if(s.length() == 1){
            if(Integer.parseInt(s) == 0)
                return 0;
            else
                return 1;
        }
        
        else{
            if(Integer.parseInt(s.substring(s.length()-2, s.length())) <= 26){
                if(Integer.parseInt(s.substring(s.length()-2, s.length())) == 10 || Integer.parseInt(s.substring(s.length()-2, s.length())) == 20)
                    return numDecodings(s.substring(0,s.length()-2)); //*****0, the last two digits must be togther
                else if(Integer.parseInt(s.substring(s.length()-2, s.length())) == 0)
                    return 0; //******00, the last two digits can not be formed by whatever combination
                else if(Integer.parseInt(s.substring(s.length()-2, s.length())) < 10)
                    return numDecodings(s.substring(0,s.length()-1)); //****0*, the last digit must be seperate 
                else
                    return numDecodings(s.substring(0,s.length()-2)) + numDecodings(s.substring(0,s.length()-1));
            }
            else{
                if(Integer.parseInt(s.substring(s.length()-1, s.length())) == 0)
                    return 0;
                else
                    return numDecodings(s.substring(0,s.length()-1));
            }
        }
        
    }
}