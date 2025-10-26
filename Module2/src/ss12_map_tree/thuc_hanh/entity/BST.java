package ss12_map_tree.thuc_hanh.entity;

import ss12_map_tree.thuc_hanh.service.AbstractTree;

public class BST<E extends Comparable<E>> extends AbstractTree<E> {
    protected TreeNode<E> root;
    protected int size = 0;

    public BST() {
    }
    public BST(E[] objects) {
        for (E object : objects) insert(object);
    }
    protected TreeNode<E> createNewNode(E element) {
        return new TreeNode<>(element);
    }
    @Override
    public boolean insert(E element) {
        if (root == null) {
            root = createNewNode(element);
        }
        else {
            TreeNode<E> parent = null;
            TreeNode<E> current = root;
            while (current != null) {
                if (element.compareTo(current.element) < 0) {
                    parent = current;
                    current = current.left;
                } else if (element.compareTo(current.element) > 0) {
                    parent = current;
                    current = current.right;
                } else {
                    return false;
                }
            }
            if (element.compareTo(parent.element) < 0) {
                parent.left = createNewNode(element);
            } else {
                parent.right = createNewNode(element);
            }
        }
        size++;
        return true;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void inorder() {
        inorder(root);
    }

    private void inorder(TreeNode<E> root) {
        if (root == null) return;
        inorder(root.left);
        System.out.println(root.element + " ");
        inorder(root.right);
    }
}
