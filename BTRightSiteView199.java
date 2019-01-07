/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        Map<Integer, Integer> res = new HashMap<>();
        TreeNode ptr = root;
        int [] maxDepth = new int[1];
        maxDepth[0] = 0;
        leftFirstSearch(ptr, res, 0, maxDepth);
        List<Integer> lres = new ArrayList<>();
        //System.out.println("maxDepth is "+maxDepth[0]);
        for(int i = 0; i < maxDepth[0]; i++){
            lres.add(res.get((Integer)i));
            System.out.println("add "+res.get((Integer)i)+" at key "+i);
        }
        return lres;
    }
    
    private void leftFirstSearch(TreeNode ptr, Map<Integer, Integer> res, int curDepth, int [] maxDepth){
        if(ptr != null){
            res.put(curDepth, ptr.val); 
            //System.out.println("add "+ptr.val+" at key "+curDepth);
            curDepth++;
            if(curDepth > maxDepth[0]){
                maxDepth[0] = curDepth;
            }
            leftFirstSearch(ptr.left, res, curDepth, maxDepth);
            leftFirstSearch(ptr.right, res, curDepth, maxDepth);
            curDepth--;
        }
    }
}