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
    public void reorderList(ListNode head) {
        if(head == null)return;
        ArrayList<ListNode> arr = new ArrayList<>();
        ListNode cur = head;
        
        while(cur != null){
            arr.add(cur);
            cur = cur.next;

        }
        int left =0;
        int right = arr.size()-1;
        while(left<right){
            arr.get(left).next = arr.get(right);
            left++;
            if(left == right)break;
            arr.get(right).next = arr.get(left);
            right--;
        }
        arr.get(left).next = null;

         
         }
}