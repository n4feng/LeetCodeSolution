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
    public int sumNumbers(TreeNode root) {
        if(root == null)
            return 0;
        return calSum(root, 0);
    }
    public int calSum(TreeNode root, int preSum){
        if(root.left == null && root.right == null){
            return preSum*10+root.val;
        }
        else{
            return (root.left == null ? 0:calSum(root.left, preSum*10+root.val)) + 
                (root.right == null ? 0:calSum(root.right, preSum*10+root.val));
        }
    }
}