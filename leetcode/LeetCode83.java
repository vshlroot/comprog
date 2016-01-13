package leetcode;

/**
 * Created by vishalss on 1/13/2016.
 */
/*
 Given a sorted linked list, delete all duplicates such that each element appear only once.

For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.
 */
public class LeetCode83 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null)
            return null;
        ListNode t1=head;
        ListNode t2=head.next;

        while(t2!=null){
            while(t2!=null && t2.val==t1.val){
                t2=t2.next;
            }
            t1=t1.next=t2;
            if(t2==null){
                break;
            }
            t2=t2.next;
        }
        return head;
    }
}
