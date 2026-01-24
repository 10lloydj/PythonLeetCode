
import java.util.Map.Entry;/**
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
    Map<Integer, Integer> levelSum = new HashMap<>();

    public int maxLevelSum(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int level = 0;
        int levelSum = 0;
        int maxLevel = Integer.MIN_VALUE;
        int maxLevelSum = Integer.MIN_VALUE;
        while (!queue.isEmpty()) {
            level++;
            levelSum = 0;

            for(int queueLevel = queue.size(); queueLevel > 0; queueLevel--) {
                TreeNode current = queue.removeFirst();
                levelSum += current.val;
                if (current.left != null) {
                    queue.addLast(current.left);
                }
                if (current.right != null) {
                    queue.addLast(current.right);
                }
            }

            if (levelSum > maxLevelSum) {
                maxLevel = level;
                maxLevelSum = levelSum;
            }
        }
        return maxLevel;
    }
}