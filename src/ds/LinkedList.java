package ds;

/**
 * Created by mahesh.subramanian on 1/5/17.
 */
public class LinkedList {

  public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
  }

  public ListNode removeNthFromEnd(ListNode head, int n) {

    ListNode fast = head, slow = head, temp = null;
    if (n == 1 && head.next == null) {
      return null;
    } else {
      // Move fast, n nodes ahead
      for (int i = 0; i < n; i++)
        fast = fast.next;
      while (fast!= null && fast.next != null) {
        fast = fast.next;
        slow = slow.next;
      }
      if (fast == null) {
        // remove head
        head = slow.next;
      } else {
        // Now remove node.next
        temp = slow.next;
        slow.next = temp.next;
      }
    }
    return head;
  }

  public ListNode buildList(int [] data) {

    ListNode head = null, lastNode = null;

    for (int datum : data) {
      ListNode node = new ListNode(datum);
      if (head == null) {
        head = node;
        lastNode = head;
      } else {
        lastNode.next = node;
        lastNode = node;
      }
    }
    return head;
  }

  public void printList(ListNode head) {
    System.out.print("List: ");
    ListNode node = head;
    while (node != null) {
      System.out.print(node.val);
      node = node.next;
      if (node != null) System.out.print(", ");
    }
    System.out.println();
  }

  /**
   * Merge two lists recursively
   * @param l1
   * @param l2
   * @return
   */
  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

    if(l1 == null) return l2;
    if(l2 == null) return l1;

    if(l1.val < l2.val) {
      System.out.println("l1 < l2: " + l1.val + ", " + l2.val);
      l1.next = mergeTwoLists(l1.next, l2);
      System.out.println("return l1 " + l1.val);
      return l1;
    } else {
      System.out.println("l2 >= l1: " + l2.val + ", " + l1.val);
      l2.next = mergeTwoLists(l2.next, l1);
      System.out.println("return l2 " + l2.val);
      return l2;
    }
  }

  public static void main(String [] args) {

    LinkedList ll = new LinkedList();
/*
    // int [] data = {1,2,3,4,5,6,7,8}; // 4
    // int [] data = {1}; // 1
    int [] data = {1,2}; // 1, 2
    ListNode head = ll.buildList(data);
    ll.printList(head);
    ListNode removed = ll.removeNthFromEnd(head, 2);
    if (removed == null)
      System.out.println("Removed node: null");
    else
      System.out.println("Removed node: " + removed.val);
    ll.printList(head);
*/
    int [] one = {1,3,4,5,7};
    int [] two = {2,6};

    ListNode l1 = ll.buildList(one);
    ListNode l2 = ll.buildList(two);

    ListNode mergedList = ll.mergeTwoLists(l1, l2);
    ll.printList(mergedList);


  }

}
