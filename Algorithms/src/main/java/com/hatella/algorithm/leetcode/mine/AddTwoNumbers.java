package com.hatella.algorithm.leetcode.mine;

public class AddTwoNumbers {
	public static void main(String args[]) {
		ListNode l1 = new ListNode(5);
		ListNode startL1 = l1;
//		l1.next = new ListNode(4);
//		l1 = l1.next;
//		l1.next = new ListNode(3);
//		l1 = l1.next;
		l1.next = null;
		
		ListNode l2 = new ListNode(5);
		ListNode startL2 = l2;
//		l2.next = new ListNode(6);
//		l2 = l2.next;
//		l2.next = new ListNode(4);
//		l2 = l2.next;
		l2.next = null;
		
		AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
		ListNode startL3 = addTwoNumbers.addTwoNumbers(startL1, startL2);
		while(startL3 != null) {
			System.out.println(startL3.val);
			startL3 = startL3.next;
		}
	}
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int carry = 0;
		ListNode startL2 = l2;
		ListNode l3 =  new ListNode(0);
		ListNode startL3 = null;
		int count = 0;
		while(l1 != null || l2 !=null) {
			int value1 = l1 != null ? l1.val:0;
			int value2 = l2 != null ? l2.val:0;
			
			int temp = (value1 + value2 + carry)%10;
			carry = (value1 + value2 + carry)/10;
			l3.next = new ListNode(temp);
			if(count == 0)
				startL3 = l3.next;
			count++;
			
			l1 = l1 != null ? l1.next : null;
			l2 = l2 != null ? l2.next : null;
			l3 = l3.next;
		}
		if(carry != 0) {
			l3.next = new ListNode(carry);
			l3 = l3.next;
			l3.next = null;
		}
		return startL3;   
    }
}
class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
}