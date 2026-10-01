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
    public boolean isPalindrome(ListNode head) {
       ArrayList<Integer> arr1 = new ArrayList<>();
       ArrayList<Integer> arr2 = new ArrayList<>();
       ListNode p = head;
       while(p != null){
        arr1.add(p.val);
        p = p.next;
       }
       for(int i = arr1.size()-1;i>=0;i--){
        arr2.add(arr1.get(i));
       }
       if(arr1.equals(arr2)){
        return true;
       }
       return false;
    }
}