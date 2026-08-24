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
    HashMap<Integer, Integer> map = new HashMap<>();

    public int[] findMode(TreeNode root) {
        count(root);

        int max = 0;

        for (int freq : map.values()) {
            max = Math.max(max, freq);
        }

        ArrayList<Integer> result = new ArrayList<>();

        for (int key : map.keySet()) {
            if (map.get(key) == max) {
                result.add(key);
            }
        }

        int[] ans = new int[result.size()];

        for (int i = 0; i < result.size(); i++) {
            ans[i] = result.get(i);
        }

        return ans;
    }

    private void count(TreeNode root) {
        if (root == null) {
            return;
        }

        map.put(root.val, map.getOrDefault(root.val, 0) + 1);

        count(root.left);
        count(root.right);
    }
}