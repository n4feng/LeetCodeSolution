class Solution {
    public List<String> letterCombinations(String digits) {
        
        List<String> result = new ArrayList();
        if(digits.length() == 0)
            return result;
        addDigits(result, digits, 0, new String());//root node of bfs
        return result;
    }
    //parameter defination:
    //height: the index for the digits

    public void addDigits(List<String> result, String digits, int height, String s){
        //when reaching the leaf, append the char and add the result to the list
        if(height == digits.length()-1){
            for(int i = 0; i < isFour(digits.charAt(height)); i++){
                String sNew = s + (char) (digitToChar(digits.charAt(height)) + i);
                result.add(sNew); //that is the end of this thread
            }
        }
        //append the right char, and ask the next level add the char
        else{
            for(int i = 0; i < isFour(digits.charAt(height)); i++){
                String sNew = s + (char) (digitToChar(digits.charAt(height)) + i);
                addDigits(result, digits, height+1, sNew);
            }
        }
    }
    
    public int isFour(char digit){
        if(digit == '9' || digit == '7')
            return 4;
        else
            return 3;
    }
    public char digitToChar(char digit){
        char result = 0;
        switch(digit){
            case '2': result = 'a';
                      break;
            
            case '3': result = 'd';
                      break;
                
            case '4': result = 'g';
                      break;
            
            case '5': result = 'j';
                      break;
            
            case '6': result = 'm';
                      break;
                
            case '7': result = 'p';
                      break;
                
            case '8': result = 't';
                      break;
            
            case '9': result = 'w';
                      break;

        }
        return result;
    }
}