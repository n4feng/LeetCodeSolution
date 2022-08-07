#define ll long long

class Solution {
public:
    int countVowelPermutation(int n) {
        ll mod = pow(10, 9) + 7;
        vector<vector<ll>> dp(n, vector<ll>(5));
        dp[0] = {1,1,1,1,1};
        vector<vector<int>> validPrev = {{1,2,4}, {0,2},{1,3},{2},{2,3}};
        //starting from 1
        for(int i = 1; i < n; i++){
            for(int j = 0; j < 5; j++){
                for(int k : validPrev[j]){
                    dp[i][j] = (dp[i][j] + dp[i-1][k]) % mod; 
                }
            }
        }
        ll ans = 0;
        for(auto n : dp.back()) ans = (ans + n) % mod;
        return ans;
    }
};
