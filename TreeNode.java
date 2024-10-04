package ProgramacionIII.tpe;

import java.util.LinkedList;

public class TreeNode {
    int key;
    TreeNode left, right;
    LinkedList<Task> elementsList;

    public TreeNode(int value, TreeNode left, TreeNode right) {
        this.key = value;
        this.left = left;
        this.right = right;
        this.elementsList = new LinkedList<Task>();
    }

    public int getKey() {
        return key;
    }

    public TreeNode getLeft() {
        return left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public boolean isLeaf() {
        return this.left == null && this.right == null;
    }

    public boolean hasTwoChildren() {
        return this.left != null && this.right != null;
    }

    public void addElement(Task task) {
        this.elementsList.addFirst(task);
    }

    public LinkedList<Task> getList() {
        return this.elementsList;
    }

    public String toString() {
        return this.key + " ";
    }
}
