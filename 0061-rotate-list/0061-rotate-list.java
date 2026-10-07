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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null)return null;
        ArrayList<Integer> arr = new ArrayList<>();
        ListNode cur = head;
        while(cur != null){
            arr.add(cur.val);
            cur = cur.next;
        }
        ArrayList<Integer> rotate = new ArrayList<>();
        int n = arr.size();
        k = k%n;
        for(int i=n-k;i<n;i++){
         rotate.add(arr.get(i));
        }
        for(int i=0;i<n-k;i++){
            rotate.add(arr.get(i));
        }
        ListNode dummy = new ListNode(0);
        cur = dummy;
        for(int val : rotate){
            cur.next = new ListNode(val);
            cur = cur.next;
        }
        return dummy.next;
        
    }
}