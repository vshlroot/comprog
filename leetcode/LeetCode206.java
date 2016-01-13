package leetcode;

/**
 * Created by vishalss on 1/13/2016.
 */
/*
Reverse a singly linked list.
 */
public class LeetCode206 {
    public ListNode reverseList(ListNode head) {
        if(head==null)
            return null;
        ListNode result=null,temp;
        while (head!=null){
            temp=head.next;
            head.next=result;
            result=head ;
            head=temp;
        }
        return result;
    }
}
