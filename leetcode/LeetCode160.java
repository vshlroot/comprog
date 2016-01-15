package leetcode;

/**
 * Created by vishalss on 1/15/2016.
 */
public class LeetCode160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lena=0;
        int lenb=0;
        ListNode temp=headA;
        while(temp!=null){
            lena++;
            temp=temp.next;
        }
        temp=headB;
        while(temp!=null){
            lenb++;
            temp=temp.next;
        }
        if(lena>lenb){
            while (lena!=lenb){
                headA=headA.next;
                lena--;
            }
        }
        else if(lena<lenb){
            while (lena!=lenb){
                headB=headB.next;
                lenb--;
            }
        }
        if(headA ==null|| headB==null)
            return null;
        while (headA.val!=headB.val){
            headA=headA.next;
            headB=headB.next;
            if(headA ==null|| headB==null)
                return null;
        }
            return headA;
    }
}
