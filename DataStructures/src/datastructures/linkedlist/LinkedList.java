package datastructures.linkedlist;

public class LinkedList {
	ListNode head;
		
	public LinkedList arrToLinkedList(int[] arr) {
		LinkedList newList = new LinkedList();
		
		for(int i: arr) {
			newList.head = insert(newList.head, i);
		}
		return newList;
	}
	
	public ListNode insert(ListNode head, int val) {
		ListNode newNode = new ListNode(val);
		
		if(head == null) {
			head = newNode;
		}
		else {
			ListNode temp = head;
			while(temp.next != null) {
				temp = temp.next;
			}
			temp.next = newNode;
		}
		
		return head;
	}
	
	public void printList(ListNode head) {
		if(head == null) {
			System.out.print("null");
		}
		
		while(head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
	}
	
	public ListNode reverseList(ListNode head) {
		ListNode newHead = null;
		
		while(head != null) {
			ListNode next = head.next;
			head.next = newHead;
			newHead = head;
			head = next;
		}
		return newHead;
	}
	
	public ListNode recurReverseList(ListNode head) {
		return recurReverseListHelper(head, null);
	}
	
	public ListNode recurReverseListHelper(ListNode head, ListNode newHead) {
		if(head == null) {
			return newHead;
		}

		ListNode next = head.next;
		head.next = newHead;
		
		return recurReverseListHelper(next, head);
	}
	
	public ListNode deleteNode(ListNode head, int val) {		
		ListNode temp = head;
		while(temp.next != null) {
			if(temp.next.val == val) {
				temp.next = temp.next.next;
			}
			temp = temp.next;
		}
		
		return head;
	}
	
	public static void main(String[] args) {
		int[] arr = new int[] {1,2,3,4,5,6,7,8,9};
		
		LinkedList linkedList = new LinkedList();
		
		linkedList = linkedList.arrToLinkedList(arr);
		linkedList.printList(linkedList.head);
		System.out.println();
		
		linkedList.head = linkedList.reverseList(linkedList.head);
		linkedList.printList(linkedList.head);
		System.out.println();
		
		linkedList.head = linkedList.recurReverseList(linkedList.head);
		linkedList.printList(linkedList.head);
		System.out.println();
		
		linkedList.head = linkedList.deleteNode(linkedList.head, 7);
		linkedList.printList(linkedList.head);
	}
}
