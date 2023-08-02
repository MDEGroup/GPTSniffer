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
    public int maxAncestorDiff(TreeNode root) {
        int ans[] = ancestor(root);
        return ans[2];
    }
    public int[] ancestor(TreeNode root){
        if(root==null)
        {
            int arr[] = new int[3];
            arr[0] = Integer.MAX_VALUE; // Min Node value
            arr[1] = Integer.MIN_VALUE; // Max Node value
            arr[2] = Integer.MIN_VALUE; // Max difference
            return arr;
        }
        if(root.left==null && root.right==null){
            int arr[] = new int[3];
            arr[0] = root.val; // Min Node value
            arr[1] = root.val;
            arr[2] = Integer.MIN_VALUE; // Max difference
            return arr;
        }
        int lst[] = ancestor(root.left);
        int rst[] = ancestor(root.right);
        int arr[] = new int[3];
        arr[0]= Math.min(Math.min(lst[0], rst[0]), root.val);
        arr[1] = Math.max(Math.max(lst[1], rst[1]), root.val);
        int temp=0;
        if(lst[0]!=Integer.MAX_VALUE)
            temp = Math.max(temp, Math.abs(root.val-lst[0])); 
        
        if(lst[1]!=Integer.MIN_VALUE)
            temp = Math.max(temp, Math.abs(root.val-lst[1]));
            

        if(rst[0]!=Integer.MAX_VALUE)
            temp = Math.max(temp, Math.abs(root.val-rst[0]));
            
        if(rst[1]!=Integer.MIN_VALUE)
            temp = Math.max(temp, Math.abs(root.val-rst[1]));
        arr[2] = Math.max(temp, Math.max(lst[2], rst[2]));
        return arr;

            
        
    }
}