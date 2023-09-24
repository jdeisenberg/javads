public class BinaryTree<T> {
    T key;
    BinaryTree<T> leftChild;
    BinaryTree<T> rightChild;
    
    public BinaryTree(T rootObject) {
        this.key = rootObject;
        this.leftChild = null;
        this.rightChild = null;
    }
    
    public void insertLeft(T newNode) {
        if (this.leftChild == null) {
            this.leftChild = new BinaryTree<T>(newNode);
        } else {
            BinaryTree<T> newChild = new BinaryTree<T>(newNode);
            newChild.leftChild = this.leftChild;
            this.leftChild = newChild;
        }
    }
    
    public void insertRight(T newNode) {
        if (this.rightChild == null) {
            this.rightChild = new BinaryTree<T>(newNode);
        } else {
            BinaryTree<T> newChild = new BinaryTree<T>(newNode);
            newChild.rightChild = this.rightChild;
            this.rightChild = newChild;
        }
    }
    
    public T getRootValue() {
        return this.key;
    }
    
    public void setRootValue(T value) {
        this.key = value;
    }
    
    public BinaryTree<T> getLeftChild() {
        return this.leftChild;
    }
    
    public BinaryTree<T> getRightChild() {
        return this.rightChild;
    }
    
}
