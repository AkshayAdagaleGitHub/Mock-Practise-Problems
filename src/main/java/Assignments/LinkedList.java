package Assignments;

class ListNode{
    char value;
    ListNode next;

    ListNode(char value){
        this.value = value;
    }
}

public class LinkedList {

    public static void main(String args[]){
        ListNode head1 = new ListNode('a');
        head1.next = new ListNode('b');
        head1.next.next = new ListNode('c');
        head1.next.next.next = new ListNode('d');
        head1.next.next.next.next = new ListNode('e');

        ListNode head2 = new ListNode('a');
        head2.next = new ListNode('b');
//        head2.next.next = head1.next.next; // c

        ListNode intersectionNode = intersection(head1,head2);
        System.out.println(intersectionNode != null ? intersectionNode.value : "null");

    }

    public static ListNode intersection(ListNode list1, ListNode list2){
      if(list1 == null || list2 == null){
          return null;
      }
      ListNode end1 = getEndList(list1);
      ListNode end2 = getEndList(list2);

      if(end1 != end2){
            return null;
      }

        int size1 = getSize(list1);
        int size2 = getSize(list2);
        int diff = 0;

        if(size1 < size2){
            diff = size2 - size1;
            while(diff != 0){
                list2 = list2.next;
                diff--;
            }
        }else{
            diff = size1 - size2;
            while(diff != 0) {
                list1 = list1.next;
                diff--;
            }
        }

        while(list1 != list2){
            list1 = list1.next;
            list2 = list2.next;
        }
        return list1;
    }

    private static int getSize(ListNode list) {
        int size = 0;
        while(list != null){
           list = list.next;
            size++;
        }
        return size;
    }

    // 1 -> 2 -> 3 -> 4 -> null
    //                ^|
    //                 list
    public static ListNode getEndList(ListNode list){
        while(list.next != null){
            list = list.next;
        }
        return list;
    }
}
