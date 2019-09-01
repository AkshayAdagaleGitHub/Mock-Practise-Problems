import java.util.Comparator;
import java.util.PriorityQueue;

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

public class Solution {

	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(5);
		
		ListNode l2 = new ListNode(1);
		l2.next = new ListNode(3);
		l2.next.next = new ListNode(4);
		
		ListNode l3 = new ListNode(2);;
		l3.next = new ListNode(6);
		
		ListNode[] lists = {l1,l2,l3};
		ListNode result = mergeKLists(lists);
		printNodes(result);
	}
	
	public static void printNodes(ListNode head) {
		while(head != null) {
			System.out.println(head.val);
			head = head.next;
		}
	}
	/*
	 * 1 -> 4 -> 5
	 * 1 -> 3 -> 4
	 * 2 -> 6
	 * 
	 * */
	
	public static ListNode mergeKLists(ListNode[] lists) {
		int minIndex = 0;
		ListNode head = new ListNode(0);
		ListNode temp = head;
		while(true) {
			boolean isBreak = true;
			int min = Integer.MAX_VALUE;
			for(int i = 0; i < lists.length; i++) { // 0 // 1 // 2
				if(lists[i]!= null) {//0 //1 //2
					if(lists[i].val < min) { //1 //1 
						minIndex = i; // 0
						min = lists[i].val; // 1
					}
					isBreak = false;
				}
			}
			if(isBreak) {
				break;
			}
			temp.next = lists[minIndex]; // temp -> lists[0](1) 
			temp = temp.next; // temp -> list[0](4) 
			lists[minIndex] = lists[minIndex].next; //0(1) -> 0(4)
		}
		temp.next = null;
		
		return head.next;
	}
	
	public ListNode mergeKListsPriorityQueue(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>(){
            public int compare(ListNode a, ListNode b) {
                return a.val - b.val;
            }
        });
        
        for (ListNode node: lists) {
            if (node != null) {
                pq.offer(node);
            }
        }
        ListNode dummy = new ListNode(0);
        ListNode node = dummy;
        while (!pq.isEmpty()) {
            ListNode temp = pq.poll();
            node.next = temp;
            node = node.next;
            if (temp.next != null) {
                pq.offer(temp.next);
            }
        }
        return dummy.next;
    }
	
	/*
	 * public ListNode mergeKLists(ListNode[] lists) {
    return divideAndConquer(lists, 0, lists.length - 1);
  }
  
  private ListNode divideAndConquer(ListNode[] lists, int start, int end) {
    if (start == end) return lists[start];
    else if (start == end - 1) return mergeTwo(lists[start], lists[end]);
    else if (start > end) return null;
    
    int mid = (start + end) >>> 1;
    ListNode left = divideAndConquer(lists, start, mid);
    ListNode right = divideAndConquer(lists, mid + 1, end);
    
    return mergeTwo(left, right);
  }
  
  private ListNode mergeTwo(ListNode left, ListNode right) {
    if (left == null) return right;
    if (right == null) return left;

    ListNode head = new ListNode(0);
    ListNode curr = head;
    
    while (left != null && right != null) {
      if (left.val <= right.val) {
        curr = curr.next = left;
        left = left.next;
      } else {
        curr = curr.next = right;
        right = right.next;
      }
    }

    if (left != null) curr.next = left;
    if (right != null) curr.next = right;

    return head.next;
  }
	 * 
	 * 
	 */
}
