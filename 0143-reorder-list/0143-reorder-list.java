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
        // if(head == null)return;
        // ArrayList<ListNode> arr = new ArrayList<>();
        // ListNode cur = head;
        
        // while(cur != null){
        //     arr.add(cur);
        //     cur = cur.next;

        // }
        // int left =0;
        // int right = arr.size()-1;
        // while(left<right){
        //     arr.get(left).next = arr.get(right);
        //     left++;
        //     if(left == right)break;
        //     arr.get(right).next = arr.get(left);
        //     right--;
        // }
        // arr.get(left).next = null;
        if(head == null || head.next== null)return ;
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode node2 = reverse(slow.next);
        slow.next = null;
        ListNode node1 = head;
        while(node2 != null){
            ListNode temp1 = node1.next;
            ListNode temp2 = node2.next;

            node1.next = node2;
            node2.next = temp1;

            node1 = temp1;
            node2 = temp2;
        }
    }
        private ListNode reverse(ListNode head){
            ListNode prev = null;
            ListNode curr = head;
            while(curr != null){
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            return prev;
        }

         
         }
