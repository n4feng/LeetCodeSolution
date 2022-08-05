class Solution {
public:
    
    vector<int> dp;
    
    Solution(){
        dp.resize(1001);
        fill(dp.begin(), dp.end(), -1);
    }
    int combinationSum4(vector<int>& nums, int target) {
        if(target <= 0) return 0;
        else if(dp[target] != -1) return dp[target];
        
        int ways = 0;
        for(int num : nums){
            if(num == target){
                ways += 1;
            }
            else if(num < target){
                ways += combinationSum4(nums, target - num);
            }
        }
        dp[target] = ways;
        return ways;
    }
};
