package leetcode;

public class ReverseNodesinkGroup {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(1);
		ListNode curr = head;
		for (int i = 2; i < 6; i++) {
			curr.next = new ListNode(i);
			curr = curr.next;
		}
		
		ListNode curr2 = reverseKGroup(head, 3);
		while(curr2!=null) {
			System.out.println(curr2.val);
			curr2 = curr2.next;
		}
	}

	public static ListNode reverseKGroup(ListNode head, int k) {
		
		ListNode dummyNode = new ListNode(0, head);
        ListNode subHead = dummyNode;
        while(subHead !=null) {
        	ListNode tmp2 = subHead;
        	int counter = k;
        	while(tmp2 !=null && counter>0) {
        		tmp2 = tmp2.next;
        		counter--;
        	}
        	if(tmp2 == null) {
        		break;
        	}
        	ListNode itr = subHead.next;
        	int i = 1;
        	while(i<k) {
        		ListNode tmp = itr.next;
                itr.next = tmp.next;
                tmp.next = subHead.next;
                subHead.next = tmp;
                i++;
        	}
        	ListNode curr2 = subHead;
        	while(curr2!=null) {
    			System.out.println(curr2.val);
    			curr2 = curr2.next;
    		}
        	subHead=itr;
        	System.out.println(subHead);
        }
		return dummyNode.next;
	}
	
	/*
	 * while(subhead !=null){
            ListNode t = dummyNode;
            int counter = k;
            while(t !=null && counter>0){
                counter--;
                t = t.next;
            }
            
            if(t == null){
                break;
            }
            ListNode itr = subhead.next;
            int i=1;
            while(i<k) {
        		ListNode tmp = itr.next;
                itr.next = tmp.next;
                tmp.next = subhead.next;
                subhead.next = tmp;
                i++;
        	}
            subhead = itr;
            
        }*/

}
