class MinWindow76 {
    public String minWindow(String s, String t) {
        if(t.length() > s.length()) return "";
        //character appeared times in t initially
        Map<Character, Integer> tCMap = new HashMap<>();
        for(int i = 0; i < t.length(); i++){
            if(tCMap.containsKey(t.charAt(i)))
                tCMap.put(t.charAt(i), tCMap.get(t.charAt(i))+1);
            else
                tCMap.put(t.charAt(i), 1);
        }
        int start = 0, end = 0;
        String res = "";
        Boolean allFind = false;
        for(; end < s.length(); end++){
            //find the first window that contains all character in t
            if(!allFind){
                if(tCMap.containsKey(s.charAt(end))){
                    tCMap.put(s.charAt(end), tCMap.get(s.charAt(end))-1);
                    //constant operation since total # of char in map < 26*2
                    Boolean ifAllFind = true;
                    for(Character c : tCMap.keySet()){
                        if(tCMap.get(c)> 0){
                            ifAllFind = false;
                            break;
                        }
                    }
                    if(ifAllFind){
                        allFind = true;
                        //try to find smallest range that all characters in tCMap exist
                        //by making sure when deleted, the count in tCMap <0
                        while(!tCMap.containsKey(s.charAt(start))) start++;
                        while(tCMap.get(s.charAt(start)) < 0){
                            tCMap.put(s.charAt(start), (tCMap.get(s.charAt(start))+1));
                            start++;
                            while(!tCMap.containsKey(s.charAt(start))) start++;
                        }
                        res = s.substring(start, end+1);
                    }
                }
            }
            else{
                //remove left most character until next element in key
                Character removed = s.charAt(start);
                //tCMap.put(s.charAt(start), 1);
                start++;
                while(start < end && !tCMap.containsKey(s.charAt(start))) start++;
                //find removed character, mark all characters except that removed characters
                //as an extra one which can be deleted
                while(end < s.length() && s.charAt(end) != removed){
                    if(tCMap.containsKey(s.charAt(end))){
                        tCMap.put(s.charAt(end), tCMap.get(s.charAt(end))-1);
                    }
                    end++;
                    if(end == s.length()) return res;
                }
                //try to find smallest range that all characters in tCMap exist
                //by making sure when deleted, the count in tCMap <0
                while(tCMap.get(s.charAt(start)) < 0){
                    tCMap.put(s.charAt(start), (tCMap.get(s.charAt(start))+1));
                    start++;
                    while(!tCMap.containsKey(s.charAt(start))) start++;
                }
                res = res.length() <= s.substring(start, end+1).length() ? 
                    res : s.substring(start, end+1);
            }
        }
        return res;
    }
}
