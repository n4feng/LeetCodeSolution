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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        addElement(1,root,result);
        return result;
    }
    private void addElement(int level, TreeNode element, List<List<Integer>> result){
        //add list when level exceed current list size
        if(result == null) result.add(new ArrayList<Integer>());
        else if(result.size() < level) result.add(new ArrayList<Integer>());
        
        result.get(level-1).add(element.val);
        //the order of left and right does matter, left first
        if(element.left != null) addElement(level+1, element.left, result);
        if(element.right != null) addElement(level+1, element.right, result);
    }
}