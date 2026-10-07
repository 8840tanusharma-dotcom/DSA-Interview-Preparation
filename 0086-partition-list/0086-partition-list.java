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
    public ListNode partition(ListNode head, int x) {
        // if(head == null)return null;
        // ListNode cur = head;
        // ArrayList<Integer> arr = new ArrayList<>();
        // while(cur != null){
        //     arr.add(cur.val);
        //     cur = cur.next;
        // }
        // ArrayList<Integer> before = new ArrayList<>();
        // ArrayList<Integer> after = new ArrayList<>();

        // for(int i=0;i<=arr.size()-1;i++){
        //     if(arr.get(i) < x){
        //         before.add(arr.get(i));
        //     }else{
        //         after.add(arr.get(i));
        //     }
        // }
        // ArrayList<Integer> result = new ArrayList<>();
        // result.addAll(before);
        // result.addAll(after);
        
        // ListNode dummy = new ListNode(0);
        // cur = dummy;
        // for(int val : result){
        //     cur.next = new ListNode(val);
        //     cur = cur.next;
        // }
        // return dummy.next;
        ListNode dummy1 = new ListNode(0);
        ListNode dummy2 = new ListNode(0);
        ListNode temp = dummy1;
        ListNode demo = dummy2;
        ListNode cur = head;
        while(cur != null){
            if(cur.val < x){
                temp.next = new ListNode(cur.val);
                temp = temp.next;
                cur = cur.next;
            }else{
                demo.next = new ListNode(cur.val);
                demo = demo.next;
                cur = cur.next;
            }
        }
        temp.next = dummy2.next;
        return dummy1.next;
    }
}