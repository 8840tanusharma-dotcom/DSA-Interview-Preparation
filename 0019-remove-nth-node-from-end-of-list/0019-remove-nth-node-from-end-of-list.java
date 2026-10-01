/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
       ArrayList<Integer> arr = new ArrayList<>();
       
       ListNode p = head;
       while(p != null){
        arr.add(p.val);
        p = p.next;
       }
       int index = arr.size()-n;
       arr.remove(index);
       ListNode dummy = new ListNode(0);
       ListNode curr = dummy;
       for(int v : arr){
        curr.next = new ListNode(v);
        curr = curr.next;
       }
       return dummy.next;
    }
}