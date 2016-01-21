package leetcode;

/**
 * Created by vishalss on 1/20/2016.
 */
/*
Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.

You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.

Example:
Given 1->2->3->4->5->NULL,
return 1->3->5->2->4->NULL.

Note:
The relative order inside both the even and odd groups should remain as it was in the input.
The first node is considered odd, the second node even and so on ...
 */
public class LeetCode328 {
    public ListNode oddEvenList(ListNode head) {
        if(head ==null || head.next==null){
            return head;
        }
        ListNode h1=head;
        ListNode head2=head.next;
        ListNode l1=head;
        ListNode h2=head.next;
        boolean even=true;

        while(h1!=null){
            if(h1.next==null) {
                h1.next=head2;
                break;
            }
            h2=h1.next;
            if(h2!=null) {
                if(h2.next!=null)
                    h1.next = h2.next;
                else {
                    if(!even) {
                        h1.next = null;
                        h2.next = head2;
                    }
                    else{
                        h1.next=head2;
                    }
                    break;
                }
            }
            h1=h2;
            if(even)
                even=false;
            else
                even=true;
        }
        return head;
    }
}
