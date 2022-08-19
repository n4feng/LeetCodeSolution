class Solution {
public:
    struct Compare {
        bool operator()(array<int, 2> sub1, array<int, 2> sub2){
            if(sub1[1] == sub2[1]){
                //if sequence end at same number, compare their length
                //shorter one will apear in front
                return (sub1[1] - sub1[0]) > (sub2[1] - sub2[0]);
            }
            //end less one will apear in front
            return sub1[1] > sub2[1];
        }
    };
    
    bool isPossible(vector<int>& nums) {
        priority_queue<array<int,2>, vector<array<int,2>>, Compare> subsequences;
        
        for (int num : nums){
            //remove non qualify subsequences
            while(!subsequences.empty() && subsequences.top()[1] + 1 < num){
                array<int, 2> currentSubsequence = subsequences.top();
                subsequences.pop();
                int subsequenceLength = currentSubsequence[1] - currentSubsequence[0] + 1;
                if (subsequenceLength < 3) {
                    return false;
                }
            }
            
            //condition 1 - create new subsequence when empty or see duplication
            if (subsequences.empty() || subsequences.top()[1] == num) {
                subsequences.push({num, num});
            }
            //condition 2 - add num to exsiting subsequences
            else {
                array<int, 2> currentSubsequence = subsequences.top();
                subsequences.pop();
                subsequences.push({currentSubsequence[0], num});
            }
        }
        
        //If any remaining subsequence is of length less than 3 return false
        while (!subsequences.empty()) {
            array<int, 2> currentSubsequence = subsequences.top();
            subsequences.pop();
            int subsequenceLength = currentSubsequence[1] - currentSubsequence[0] + 1;
            if (subsequenceLength < 3) {
                return false;
            }
        }
        return true;
    }
};
