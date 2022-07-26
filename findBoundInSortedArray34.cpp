class Solution {
public:
    vector<int> searchRange(vector<int>& nums, int target) {
        if(nums.size() == 0) return vector<int> {-1,-1};
        return vector<int> {left_bound(nums, target), right_bound(nums, target)};
    }
    
    int left_bound(vector<int>& nums, int target){
        int left = -1;
        int right = nums.size()-1;
        
        while(left < right){
            if(right == left+1){
                if(nums[right] == target) return right;
                else break;
            }
            int mid = left + (right - left + 1) / 2;
            if(nums[mid] > target) right = mid-1;
            else if(nums[mid] == target) right = mid;
            else left = mid;
        }
        return -1;
    }
    
    int right_bound(vector<int>& nums, int target){
        int left = 0;
        int right = nums.size();
        
        while(left < right){
            if(right == left+1){
                if(nums[left] == target) return left;
                else break;
            }
            int mid = left + (right - left + 1) / 2;
            if(nums[mid] < target) left = mid+1;
            else if(nums[mid] == target) left = mid;
            else right = mid;
        }
        return -1;
    }
    
};
