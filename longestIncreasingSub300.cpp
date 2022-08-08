class Solution {
public:
    int lengthOfLIS(vector<int>& nums) {
        //sub path record currently possible smallest sequence
        //replacing possible smallest element may seems not so intuiative at begining
        //but it is a very elegant way to keep track
        
        //what it actually did is try to see if some future number stream
        //(numbers on the right) could use a smaller end number to replace
        //current number stream.
        //if current stream is longer, the last number in subPath won't be change
        //the length will also not be changed
        
        //only in scenario when the future number stream become longer with some smaller
        //future number, the length will grow and the entire stream will be replaced
        vector<int> sub;
        sub.push_back(nums[0]);
        
        for(int i = 1; i < nums.size(); i++){
            if(nums[i] > sub.back()){
                sub.push_back(nums[i]);
            }
            else{
                int j = binarySearch(sub, nums[i]);
                sub[j] = nums[i];
            }
        }
        return sub.size();
        
    }
    
    int binarySearch(vector<int>& sub, int num){
        int left = 0, right = sub.size()-1, mid = 0;
        //find the smallest element that is >= num
        while(left < right){
            mid = left + (right - left) / 2;
            if(sub[mid] == num) return mid;
            else if(sub[mid] < num) left = mid+1;
            else right = mid;
        }
        return left;
    }
};
