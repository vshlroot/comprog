/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class LeetCode2{
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if(l1==null)
			return l2;
		else if(l2==null){
			return l1;
		}
		ListNode l=null,l1_temp,l2_temp,l_temp,l_temp_2=null;
		int carry=0,sum=0;
		l1_temp=l1;
		l2_temp=l2;
        do{
			sum=l1.val+l2.val+carry;
			if(sum>=10){
				sum%=10;
				carry=1;
			}
			else{
				carry=0;
			}
			l1=l1.next;
			l2=l2.next;
			
			l_temp=new ListNode(sum);
			if(l==null){
				l=l_temp;
				l_temp_2=l;
			}
			else{
				l_temp_2.next=l_temp;
				l_temp_2=l_temp_2.next;
			}
		}
		while(l1!=null && l2!=null);
		while(l1==null && l2!=null){
			sum=l2.val+carry;
			if(sum>=10){
				sum%=10;
				carry=1;
			}
			else{
				carry=0;
			}
			l2=l2.next;
			l_temp_2.next=new ListNode(sum);
			l_temp_2=l_temp_2.next;
		}
//		else if(l2==null && l1!=null){
		while(l2==null && l1!=null){
			sum=l1.val+carry;
			if(sum>=10){
				sum%=10;
				carry=1;
			}
			else{
				carry=0;
			}
			l1=l1.next;
			l_temp_2.next=new ListNode(sum);
			l_temp_2=l_temp_2.next;
		}
		if(carry==1)
			l_temp_2.next=new ListNode(1);
		return l;
    }
}
