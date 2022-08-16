class Solution {
public:
    int firstUniqChar(string s) {
        vector<int> firstPos(26);
        //-1 stand for char not in s
        fill(firstPos.begin(), firstPos.end(), -1);
        
        for(int i = 0; i < s.size(); i++){
            //-2 stand for duplicated
            if(firstPos[s[i]-'a'] != -1)
                firstPos[s[i]-'a'] = -2;
            else
                firstPos[s[i]-'a'] = i;
        }
        int res = -1;
        for(int i = 0; i < 26; i++){
            if(firstPos[i] != -1 && firstPos[i] != -2){
                if(res == -1)
                    res = firstPos[i];
                else{
                    if(firstPos[i] < res)
                        res = firstPos[i];
                }
            }
        }
        return res;
    }
};
