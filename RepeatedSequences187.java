import java.util.*;
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        //use hash table to store the sequence
        List<String> result = new ArrayList<>();
        if(s.length() < 10) return result;
        Hashtable<String, Integer> sequences = new Hashtable<>();
        //go through s, check every sequences of 10 chars 
        for(int i = 0; i < s.length() - 9; i++){
            if(sequences.get(s.substring(i,i+10)) == null){
                sequences.put(s.substring(i,i+10), 1);
               //System.out.println("put the '" + s.substring(i,i+10) + "' into the hashtable");
            }                
            else{
                int value = sequences.get(s.substring(i,i+10));
                if(value == 1){
                    result.add(s.substring(i,i+10));
                    //System.out.println("add the '" + s.substring(i,i+10) + "' into the result");
                    sequences.put(s.substring(i,i+10),2);
                }
            }                
        }
        return result;
    }
}