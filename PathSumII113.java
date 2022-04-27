/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {        
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        dfsSearchTarget(root, targetSum, res, new ArrayList<>());
        return res;
    }
    
    public void dfsSearchTarget(TreeNode root, int targetSum, List<List<Integer>> res, List<Integer> currentPath){
        currentPath.add(root.val);
        if (root.val == targetSum && root.left == null && root.right == null){            
            res.add(new ArrayList(currentPath));
        }
        else{
            if(root.left != null){
                dfsSearchTarget(root.left, targetSum-root.val, res, currentPath);
            }
            if(root.right != null){
                dfsSearchTarget(root.right, targetSum-root.val, res, currentPath);
            }
        }
        currentPath.remove(currentPath.size()-1);
    }
}
