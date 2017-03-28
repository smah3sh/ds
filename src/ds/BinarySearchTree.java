package ds;

/**
 * Created by mahesh.subramanian on 10/20/16.
 */
class Node {

  int data;
  Node left;
  Node right;

  public Node(int data) {
    this.data = data;
    left = null;
    right = null;
  }
}

public class BinarySearchTree {

  public static Node root;

  public BinarySearchTree() {
    this.root = null;
  }

  public Node find(int id) {

    Node current = root;

    while (current != null) {
      if (current.data == id) {
        return current;
      } else if (current.data > id) {
        current = current.left;
      } else {
        current = current.right;
      }
    }
    return null;
  }

  public boolean delete(int id) {
    Node parent = root;
    Node current = root;
    boolean isLeftChild = false;
    while (current.data != id) {
      parent = current;
      if (current.data > id) {
        isLeftChild = true;
        current = current.left;
      } else {
        isLeftChild = false;
        current = current.right;
      }
      if (current == null) {
        return false;
      }
    }
    //if i am here that means we have found the node
    //Case 1: if node to be deleted has no children
    if (current.left == null && current.right == null) {
      if (current == root) {
        root = null;
      }
      if (isLeftChild == true) {
        parent.left = null;
      } else {
        parent.right = null;
      }
    }
    //Case 2 : if node to be deleted has only one child
    else if (current.right == null) {
      if (current == root) {
        root = current.left;
      } else if (isLeftChild) {
        parent.left = current.left;
      } else {
        parent.right = current.left;
      }
    } else if (current.left == null) {
      if (current == root) {
        root = current.right;
      } else if (isLeftChild) {
        parent.left = current.right;
      } else {
        parent.right = current.right;
      }
    } else if (current.left != null && current.right != null) {

      //now we have found the minimum element in the right sub tree
      Node successor = getSuccessor(current);
      if (current == root) {
        root = successor;
      } else if (isLeftChild) {
        parent.left = successor;
      } else {
        parent.right = successor;
      }
      successor.left = current.left;
    }
    return true;
  }

  public Node getSuccessor(Node deleleNode) {
    Node successsor = null;
    Node successsorParent = null;
    Node current = deleleNode.right;
    while (current != null) {
      successsorParent = successsor;
      successsor = current;
      current = current.left;
    }
    //check if successor has the right child, it cannot have left child for sure
    // if it does have the right child, add it to the left of successorParent.
//		successsorParent
    if (successsor != deleleNode.right) {
      successsorParent.left = successsor.right;
      successsor.right = deleleNode.right;
    }
    return successsor;
  }

  public Node insert(int value) {
    Node newNode = new Node(value);
    if (root == null) {
      root = newNode;
      return root;
    }
    Node current = root;

    while (true) {

      if (value < current.data) {
        current = current.left;
        if (current.left == null) {
          // Insert here
          current.left = newNode;
          return newNode;
        }
      } else {
        if (current.right == null) {
          // Insert here
          current.right = newNode;
          return newNode;
        }
      }
    }
  }

  public void display(Node root) {
    if (root != null) {
      display(root.left);
      System.out.print(" " + root.data);
      display(root.right);
    }
  }

  public static void main(String arg[]) {
    BinarySearchTree b = new BinarySearchTree();
    b.insert(3);
    b.insert(8);
    b.insert(1);
    b.insert(4);
    b.insert(6);
    b.insert(2);
    b.insert(10);
    b.insert(9);
    b.insert(20);
    b.insert(25);
    b.insert(15);
    b.insert(16);
    System.out.println("Original Tree : ");
    b.display(b.root);
    System.out.println("");
    System.out.println("Check whether ds.Node with value 4 exists : " + b.find(4));
    System.out.println("Delete ds.Node with no children (2) : " + b.delete(2));
    b.display(root);
    System.out.println("\n Delete ds.Node with one child (4) : " + b.delete(4));
    b.display(root);
    System.out.println("\n Delete ds.Node with Two children (10) : " + b.delete(10));
    b.display(root);
  }
}

