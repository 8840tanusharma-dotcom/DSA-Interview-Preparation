/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p = headA;
        while(p != null ){
        ListNode q = headB;
        while(q != null){
            if(p == q){
                return q;
            }
            q = q.next;
        }
        p = p.next;
        
        }
        return p;

    }
}