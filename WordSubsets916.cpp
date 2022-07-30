class Solution {
public:
    vector<string> wordSubsets(vector<string>& words1, vector<string>& words2) {
        //order actually doesn't matter
        //combine words2 into bmax, which is the max count seen in each char
        string empty;
        int* bmax = count(empty);
        for(string b : words2){
            int* bCount = count(b);
            for(int i = 0; i < 26; ++i){
                bmax[i] = max(bmax[i], bCount[i]);
            }
            delete[] bCount;
        }
        vector<string> ans;
        bool isSub = true;
        for(string a : words1){
            int* aCount = count(a);
            for(int i = 0; i < 26; i++){
                if(aCount[i] < bmax[i]){
                    isSub = false;
                    break;
                }
            }
            delete[] aCount;
            if(isSub)
                ans.push_back(a);
            isSub = true;
        }
        delete[] bmax;
        return ans;
    }
    
    int * count(string &S){
        int *ans = new int[26];
        for(int i = 0; i < 26; ++i)
            ans[i] = 0;
        for(char const &c : S)
            ans[c - 'a']++;
        return ans;
    }
};
