class Solution {
public:
    vector<string> findAndReplacePattern(vector<string>& words, string pattern) {
        vector<string> res;
        for(string word : words){
            unordered_map<char, char> lookup;
            unordered_set<char> mapped;
            bool isSame = true;
            for(int i = 0; i < pattern.size(); i++){
                if(lookup.find(pattern.at(i)) != lookup.end()){
                    if(lookup[pattern.at(i)] != word.at(i)){
                        isSame = false;
                        break;
                    }
                }
                else{
                    if(mapped.find(word.at(i)) != mapped.end()){
                        isSame = false;
                        break;
                    }
                    else{
                        lookup[pattern.at(i)] = word.at(i);
                        mapped.insert(word.at(i));
                    }
                }
            }
            if(isSame){
                res.push_back(word);
            }
        }
        return res;
    }
    
};
