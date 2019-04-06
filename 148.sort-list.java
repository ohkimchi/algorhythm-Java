/*
 * @lc app=leetcode id=148 lang=java
 *
 * [148] Sort List
 *
 * https://leetcode.com/problems/sort-list/description/
 *
 * algorithms
 * Medium (34.36%)
 * Total Accepted:    176.3K
 * Total Submissions: 510.8K
 * Testcase Example:  '[4,2,1,3]'
 *
 * Sort a linked list in O(n log n) time using constant space complexity.
 *
 * Example 1:
 *
 *
 * Input: 4->2->1->3
 * Output: 1->2->3->4
 *
 *
 * Example 2:
 *
 *
 * Input: -1->5->3->4->0
 * Output: -1->0->3->4->5
 *
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if (null == head || null == head.next) return head;

        ListNode prev = null, slow = head, fast = head;
        while (null != fast && null != fast.next) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        ListNode l1 = sortList(head), l2 = sortList(slow);
        return merge(l1, l2);
    }

    public ListNode merge(ListNode l1, ListNode l2) {
        ListNode l = new ListNode(0), p = l;
        while (null != l1 && null != l2) {
            if (l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        if (null != l1) p.next = l1;
        if (null != l2) p.next = l2;
        return l.next;
    }
}

