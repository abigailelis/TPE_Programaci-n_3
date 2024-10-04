package ProgramacionIII.tpe;

import java.util.LinkedList;

public class Tree {
    private TreeNode root;

    public Tree() {
        this.root = null;
    }

    public void add(int value, Task task) {
        if (this.root == null)
            this.root = new TreeNode(value, null, null);
        else
            add(value, this.root, task);
    }

    /*
     * h es la altura del árbol
     * O(h) porque en el peor de los casos el nuevo valor pasa a ser mi hoja más
     * lejana.
     */
    private void add(int value, TreeNode actual, Task task) {
        if (value < actual.getKey()) {
            if (actual.getLeft() == null){
                TreeNode node = new TreeNode(value, null, null);
                node.addElement(task);
                actual.setLeft(node);
            }
            else
                add(value, actual.getLeft(), task);
        } else if (value > actual.getKey())
            if (actual.getRight() == null){
                TreeNode node = new TreeNode(value, null, null);
                node.addElement(task);
                actual.setRight(node);
            }
            else
                add(value, actual.getRight(), task);
    }

    public boolean isEmpty(){
        return this.root == null;
    }

    public LinkedList<Task> getElemBetween (int minor, int mayor){
        LinkedList<Task> list = new LinkedList<>();
        if (!this.isEmpty())
            getElemBetween(minor, mayor, list, this.root);
        return list;
    }

    /*
     * n es la cantidad de nodos del árbol.
     * O(n) porque en el peor de los casos quiero obtener
     * los elementos de todo el árbol
     */

    private void getElemBetween (int minor, int mayor, LinkedList<Task> list, TreeNode actual){
        if(actual != null){
            if(actual.getKey() == minor){
                list.addAll(actual.getList());
                getElemBetween(minor, mayor, list, actual.getRight());
            }
            if(actual.getKey() == mayor){
                list.addAll(actual.getList());
                getElemBetween(minor, mayor, list, actual.getLeft());
            }
            if(actual.getKey() > minor){
                if(actual.getKey() < mayor)
                    list.addAll(actual.getList());
                getElemBetween(minor, mayor, list, actual.getLeft());
                getElemBetween(minor, mayor, list, actual.getRight());
            }
            if(actual.getKey() < minor){
                getElemBetween(minor, mayor, list, actual.getRight());
            }

        }
    }

    public void printInOrder() {
        printInOrder(this.root);
    }

    private void printInOrder(TreeNode node) {
        if (node == null)
            return;
        printInOrder(node.getLeft());
        System.out.print(node.getKey() + " ");
        printInOrder(node.getRight());
        // System.out.print(" - ");
    }

}
