class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        vector<int> result;
        int index1 = 0;

        for (vector<int>::iterator intit = nums.begin(); intit != nums.end(); ++intit){
            
            for (vector<int>::iterator intit2 = (nums.begin() + index1 + 1); intit2 != nums.end(); ++intit2){
                //cout << "now add " << *intit << "+" << *intit2 << endl;
                if(*intit + *intit2 == target){
                    result.push_back(index1);
                    result.push_back(distance(nums.begin(), intit2));
                    return result;
                }
            }
            
            ++index1;
        }
        return result;
    }
};