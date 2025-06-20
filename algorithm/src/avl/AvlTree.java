package avl;

import java.util.ArrayList;
import java.util.List;

public class AvlTree<E extends Comparable<E>> {
    private Node<E> root;

    private Node<E> rotateLeft(Node<E> root) {
        Node<E> newRoot = root.getRight();
//       // newRoot.setParent(root.getParent());
//        root.setRight(newRoot.getLeft());
//        if (newRoot.getLeft() != null) {
//           // newRoot.getLeft().setParent(root);
//        }
        Node<E> newRootLift = newRoot.getLeft();
        newRoot.setLeft(root);
        root.setRight(newRootLift);
        root.setHeight(Math.max(getHeight(root.getLeft()), getHeight(root.getRight())) + 1);
        newRoot.setHeight(Math.max(getHeight(newRoot.getLeft()), getHeight(newRoot.getRight())) + 1);
        if (this.root == root) {
            this.root = newRoot;
        }
        return newRoot;
    }

    private Node<E> rotateRight(Node<E> root) {
        Node<E> newRoot = root.getLeft();
        Node<E> newRootRight = newRoot.getRight();
        newRoot.setRight(root);
        root.setLeft(newRootRight);
        root.setHeight(Math.max(getHeight(root.getLeft()), getHeight(root.getRight())) + 1);
        newRoot.setHeight(Math.max(getHeight(newRoot.getLeft()), getHeight(newRoot.getRight())) + 1);
        if (this.root == root) {
            this.root = newRoot;
        }
        return newRoot;
    }

    public Node<E> addNode(E item) {
        return addNode(root, item);
    }

    public Node<E> addNode(Node<E> parent, E item) {
        Node<E> node = new Node<>(item);
        if (this.root == null) {
            root = node;
            return node;
        }
        if (parent == null) {
            return node;
        }
        if (item.compareTo(parent.getItem()) > 0) {
            parent.setRight(addNode(parent.getRight(), item));
        } else if (item.compareTo(parent.getItem()) < 0) {
            parent.setLeft(addNode(parent.getLeft(), item));
        } else {
            parent.setItem(item);
        }
        parent.setHeight(1 + Math.max(getHeight(parent.getLeft()), getHeight(parent.getRight())));
        int balanceFactor = getBalanceFactor(parent);
        if (balanceFactor > 1 && getBalanceFactor(parent.getLeft()) >= 0) {
            return rotateRight(parent);
        }
        if (balanceFactor < -1 && getBalanceFactor(parent.getRight()) <= 0) {
            return rotateLeft(parent);
        }
        if (balanceFactor > 1 && getBalanceFactor(parent.getLeft()) < 0) {
            parent.setLeft(rotateLeft(parent));
            return rotateRight(parent);
        }
        if (balanceFactor < -1 && getBalanceFactor(parent.getRight()) > 0) {
            parent.setRight(rotateRight(parent));
            return rotateLeft(parent);
        }
        return parent;
    }

    public int getBalanceFactor(Node<E> node) {
        if (node == null) {
            return 0;
        }
        return getHeight(node.getLeft()) - getHeight(node.getRight());
    }

    public int getHeight(Node<E> node) {
        if (node == null) {
            return 0;
        }
        return node.getHeight();
    }

    public void middleOrder(Node<E> root, List<E> items) {
        if (root == null) {
            return;
        }
        middleOrder(root.getLeft(), items);
        items.add(root.getItem());
        middleOrder(root.getRight(), items);
    }

    public Node<E> getRoot() {
        return root;
    }

    public boolean updateNode(E oldItem, E newItem) {
        if (root == null) {
            return false;
        }
        return true;
    }

    public boolean deleteNode(E item) {
        return true;
    }

    public Node<E> findNode(E item) {
        Node<E> cur = root;
        while (cur != null) {
            if (cur.getItem().compareTo(item) == 0) {
                return cur;
            } else if (cur.getItem().compareTo(item) > 0) {
                cur = cur.getLeft();
            } else {
                cur = cur.getRight();
            }
        }
        return null;
    }

    public boolean isBalanced(Node<E> root) {
        if (root == null) {
            return true;
        }

        int balanceFactor = getBalanceFactor(root);
        if (Math.abs(balanceFactor) > 1) {
            return false;
        }
        return isBalanced(root.getLeft()) && isBalanced(root.getRight());
    }

    public boolean isBST() {
        List<E> items = new ArrayList<>();
        middleOrder(root, items);
        for (int i = 0; i < items.size() - 1; i++) {
            if (items.get(i).compareTo(items.get(i + 1)) > 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        AvlTree<Integer> avlTree = new AvlTree<>();
        int[] a = {1, 3, 5, 6, 78, 54};
        for (int i = 0; i < a.length; i++) {
            avlTree.addNode(a[i]);
        }
        boolean bst = avlTree.isBST();
        System.out.println("bst = " + bst);
        List<Integer> integers = new ArrayList<>();
        avlTree.middleOrder(avlTree.getRoot(), integers);
        System.out.println("integers = " + integers);
    }
}
