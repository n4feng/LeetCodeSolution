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
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        return isValidNode(root.left, null, root.val)&&isValidNode(root.right, root.val, null);
    }
    public boolean isValidNode(TreeNode node, Integer low, Integer high){
        if(node == null) return true;
        else {
            return (Objects.isNull(low)? true : (node.val > low)) && (Objects.isNull(high)? true : (node.val < high)) 
            && isValidNode(node.left, low, node.val) && isValidNode(node.right, node.val, high);
        }
    }
}