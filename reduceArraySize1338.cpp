class Solution {
public:
    int minSetSize(vector<int>& arr) {
        unordered_map<int, int> appeared;
        vector<int> values;
        int req = arr.size() / 2;
        int sum = 0;
        for(auto i : arr){
            if(appeared.find(i) != appeared.end()){
                appeared[i]+=1;
            }
            else{
                appeared[i]=1;
            }
        }
        for(auto v : appeared){
            values.push_back(v.second);
        }
        sort(values.begin(), values.end());
        for(int i = 1; i <= values.size(); i++){
            sum += values[values.size() - i];
            if(sum >= req)
                return i;
        }
        return -1;
    }
};
