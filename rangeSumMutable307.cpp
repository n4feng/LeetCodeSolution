class NumArray {
public:
    NumArray(vector<int>& nums) {
        size = nums.size();
        tree = vector<int>(2*size);
        for(int i = size; i < 2*size; i++){
            tree[i] = nums[i-size];
        }
        for(int i = size-1; i > 0; i--){
            tree[i] = tree[i*2] + tree[i*2+1];
        }
    }
    
    void update(int index, int val) {
        int i = size+index;
        int diff = val - tree[i];
        while(i > 0){
            tree[i] +=diff;
            i/=2;
        }
    }
    
    int sumRange(int left, int right) {
        int sum = 0;
        int l = left+size;
        int r = right+size;
        while(l <= r){
            //will get more clear if you draw a diagram and sum them up
            if((l%2) == 1){
                //count if left bound is the right chid
                sum += tree[l];
                //narrow range to the parents right one
                //as you can't add parent anymore
                l++;
            }
            if((r%2) == 0){
                //same as left, but on oppite way to narrow down range
                sum += tree[r];
                r--;
            }
            //go to parent
            l/=2;
            r/=2;
        }
        return sum;
    }

private:
    vector<int> tree;
    int size;
};

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray* obj = new NumArray(nums);
 * obj->update(index,val);
 * int param_2 = obj->sumRange(left,right);
 */
