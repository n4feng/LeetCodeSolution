class Solution {
public:
    int numFactoredBinaryTrees(vector<int>& arr) {
        long mod = pow(10,9) + 7;
        int res = 1;
        sort(arr.begin(), arr.end());
        unordered_map<int, int> memo;
        memo[arr[0]] = 1;
        for(int i = 1; i < arr.size(); i++){
            //default value is 1 if arr[i] is nor divisible by any of elements
            memo[arr[i]] = 1;
            for(int j = 0; j < i; j++){
                //arr[i] is divisible by arr[j]
                //say 10 = 2*5, you will count 2*5 once when arr[j] = 2
                //than when j iterate to arr[j] = 5, count another time
                if(arr[i] % arr[j] == 0){
                    int second = arr[i] / arr[j];
                    memo[arr[i]] = (memo[arr[i]] + mulmod(memo[arr[j]], memo[second], mod)) % mod;
                }
            }
            res = (res + memo[arr[i]]) % mod;
        }
        return res;
    }
    
    long mulmod(long a, long b, long mod){
        long res = 0;
        a = a% mod;
        while(b > 0){
            if(b % 2 == 1) res = (res + a) % mod;
            a = (a * 2) % mod;
            b /=2;
        }
        return res % mod;
    }
};
