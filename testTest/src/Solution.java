import org.junit.Test;
import sun.reflect.generics.tree.Tree;

import javax.net.ssl.SSLContext;
import java.util.*;

/**
 * @author ZJJ
 * #Description Solution
 * #Date: 2022/7/9 15:53
 */

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);

        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(4);
        ListNode n6 = new ListNode(4);
        ListNode n7 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;

        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;

//        char[][] matrix =
//                {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};

//        TreeNode t1 = new TreeNode(10);
//        TreeNode t2 = new TreeNode(5);
//        TreeNode t3 = new TreeNode(-3);
//        TreeNode t4 = new TreeNode(3);
//        TreeNode t5 = new TreeNode(2);
//        TreeNode t6 = new TreeNode(11);
//        TreeNode t7 = new TreeNode(3);
//        TreeNode t8 = new TreeNode(-2);
//        TreeNode t9 = new TreeNode(1);
//
//        t1.left = t2;
//        t1.right = t3;
//        t3.right = t6;
//        t3.left = null;
//        t2.left = t4;
//        t2.right = t5;
//        t5.left = null;
//        t5.right = t9;
//        t4.left = t7;
//        t4.right = t8;
//        t7.left = null;
//        t7.right = null;
//        t8.left = null;
//        t8.right = null;

        int[] nums = {9, 1, 3, 2, 8};
        System.out.println(solution.find(nums,0, nums.length));
    }

    public void add() {
        System.out.println("hello world");
    }

    public int findMax(int[] nums) {
        return find(nums, 0, nums.length);
    }

    public int find(int[] nums, int l, int r) {
        if (l == r) {
            return nums[l];
        }
        int mid = (l + r) / 2;
        int left = find(nums, l, mid);
        int right = find(nums, mid + 1, r);

        return left >= right ? left : right;
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return getClass().getName() + "@" + Integer.toHexString(hashCode());
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};