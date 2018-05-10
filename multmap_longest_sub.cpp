#include <unordered_map>
#include <algorithm>
class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        multimap<char,int> myMap;
        int n = s.length();
        int j = 0;//for finding the matched item
        int result = 0;
        for(int i = 0; i < n; ++i){
            pair<char,int> s_temp (s[i],i+1);
            if(myMap.find(s[i])!=myMap.end()){
                //cout << "try to find " << s[i] << " when i = " << i << endl; 
                //cout << "count return "<< myMap.count(s[i]) << endl;
                if(myMap.count(s[i]) < 1){
                    j = max(myMap.find(s[i])->second,j);//don't care the part already decided
                    //cout << "no repeat, j = " << j << endl;                    
                }
                else{
                    multimap<char,int>::reverse_iterator rit = myMap.rbegin();
                    //++rit;
                    //std::cout << "rend is index " << rit->second << endl;
                    while(rit->first != s[i]){                        
                        ++rit;
                    }
                    //cout<< "current index "<< rit->second << endl;
                    if(rit->second > j)
                        j = rit->second;
                    //cout << "repeat, j = " << j << endl;     
                }
            }
            result = max(i-j+1,result);
            myMap.insert(s_temp);
        }
        return result;
    }
};