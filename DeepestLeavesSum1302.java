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
class DeepestLeavesSum1302 {
    public int deepestLeavesSum(TreeNode root) {
        List<TreeNode> queue = new ArrayList<>();
        queue.add(root);
        int nodeRemainUnderLevel = 1;
        int nodeSum = 0;
        
        while(!queue.isEmpty()){
            if(nodeRemainUnderLevel == 0){
                //get next level size
                nodeRemainUnderLevel = queue.size();
                nodeSum = 0;
            }
            TreeNode ptr = queue.remove(0);
            nodeRemainUnderLevel-= 1;
            nodeSum += ptr.val;
            
            if(ptr.left != null){
                queue.add(ptr.left);
            }
            if(ptr.right != null){
                queue.add(ptr.right);
            }
        }
        
        return nodeSum;
    }
}
