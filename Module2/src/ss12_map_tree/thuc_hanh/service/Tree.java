package ss12_map_tree.thuc_hanh.service;

public interface Tree<E> {
//    Insert element into the binary search tree
//    return true if the element is insert successfully
    public boolean insert(E element);
    // Inorder travesal from the root
    public void inorder();
    // Get the number of nodes in the tree
    public int getSize();
}
