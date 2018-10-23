class Solution {
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        int size1 = nums1.size();
        int size2 = nums2.size();
        //cout << "num1 size is " << size1 << " and num2 size is " << size2 << endl;
        vector<int>::iterator it1 = nums1.begin();
        vector<int>::iterator it2 = nums2.begin();
        double result;
        if((size1+size2)%2 == 1){
            //odd
            result = findNth(nums1, nums2,it1, it2, (size1+size2+1)/2);
        }
        else{
            //even
            result = findNth(nums1, nums2,it1, it2, (size1+size2)/2);
            //cout << "first time result is " << result << endl;
            result = (result + findNth(nums1, nums2,it1, it2, 1))/2;
            //cout << "second time result is " << result << endl;
        }
        return result;
    }
    
    double findNth (vector<int>& nums1, vector<int>& nums2, vector<int>::iterator& nums1it, vector<int>::iterator& nums2it, int n){
        double result = 0;    
        for(int i = 0; i < n ; ++i){
            //cout << "num1 it is " << *nums1it << " and num2 it is " << *nums2it << endl;
            if(nums1it != nums1.end()){
                if(nums2it != nums2.end()){
                    if(*nums1it < *nums2it){
                        //cout << "num1 is smaller" << endl;
                        result = *nums1it;
                        ++nums1it;
                    }
                    else{
                        //cout << "num2 is smaller" << endl;
                        result = *nums2it;
                        ++nums2it;
                    }
                }
                else{
                    result = *nums1it;
                    ++nums1it;
                }
            }
            else{
                result = *nums2it;
                ++nums2it;
            }
        }
        return result;
    }
};