class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        int maxLen = 0;
        Map<Integer,Integer> longestSeq = new HashMap<>();//<number, the longest sequence this number will have>
        for(int i : nums){
            if(!longestSeq.containsKey(i)){
                int left = longestSeq.containsKey(i-1)?longestSeq.get(i-1):0;
                int right = longestSeq.containsKey(i+1)?longestSeq.get(i+1):0;
                int iSeqLength = left + right + 1;
                longestSeq.put(i,iSeqLength);
                //update the longestSwq of the left and right side of this seq
                if(longestSeq.containsKey(i-1)) longestSeq.replace(i-left,iSeqLength);
                if(longestSeq.containsKey(i+1)) longestSeq.replace(i+right,iSeqLength);
                maxLen = Math.max(maxLen,iSeqLength);
            }
        }
        return maxLen;
    }
}