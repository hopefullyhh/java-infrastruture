package avl;

public class Node<E extends Comparable<E>> {
    private E item;
    private Node<E> left;
    private Node<E> right;
   // private Node<E> parent;
    private int height;

    public Node(E item) {
        this.item = item;
        height = 1;
    }

    public E getItem() {
        return item;
    }

    public void setItem(E item) {
        this.item = item;
    }

    public Node<E> getLeft() {
        return left;
    }

    public void setLeft(Node<E> left) {
        this.left = left;
    }

    public Node<E> getRight() {
        return right;
    }

    public void setRight(Node<E> right) {
        this.right = right;
    }

//    public Node<E> getParent() {
//        return parent;
//    }
//
//    public void setParent(Node<E> parent) {
//        this.parent = parent;
//    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
