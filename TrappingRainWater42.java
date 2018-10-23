import java.util.*;
class Solution {
    public int trap(int[] height) {
        if(height.length <= 2)
            return 0;
        return subTrap(height, 0, height.length - 1);
    }
    public int subTrap(int[] height, int leftIndex, int rightIndex){
        if(rightIndex - leftIndex < 2)
            return 0;
        int[] maxTwo = findMaxTwo(height,leftIndex,rightIndex);
        System.out.println("find max two at index " + maxTwo[0] + " and " + maxTwo[1]);
        int tempTrap = 0;
        for(int i = Math.min(maxTwo[0],maxTwo[1])+1; i < Math.max(maxTwo[0],maxTwo[1]); i++){
            tempTrap += height[maxTwo[1]] - height[i];
        }
        
        return subTrap(height, leftIndex,Math.min(maxTwo[0],maxTwo[1])) + tempTrap + subTrap(height, Math.max(maxTwo[0],maxTwo[1]),rightIndex); 
    }
    //find the max two's index (there is no garuntee which two will be selected if there is multiple result)
    //(but do have garuntee the height between them will not exceed second heighest one)
    //O(n)
    public int[] findMaxTwo(int[] a, int left, int right){//make sure input array's length is greater than two
        int maxIndex = -1;
        int secondMaxIndex = -1;
        for(int i = left; i <= right; i++){
            if(a[i] >= (maxIndex >= 0 ? a[maxIndex]:0)){
                //this = sign garuntee that all the max height is captured, so 
                //there will be no height exceed the second height
                if(maxIndex >= 0)
                    secondMaxIndex = maxIndex;
                maxIndex = i;
            }
            else if(a[i] >= (secondMaxIndex >= 0 ? a[secondMaxIndex] : 0)){
                secondMaxIndex = i;
            }
            //System.out.println("max is " + maxIndex + " secondMax is " + secondMaxIndex);
        }
        int[] result = new int[2];
        result[0] = maxIndex;
        result[1] = secondMaxIndex;
        return result;
    }
}