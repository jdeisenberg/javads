import java.util.Iterator;

public class BinarySearchTree<K extends Comparable<K>,
  V extends Comparable<V>> {

    private TreeNode root;
    private int size;
    
    public BinarySearchTree() {
        this.root = null;
        size = 0;
    }
    
    public int size() {
        return size;
    }

    public TreeNode getRoot() {
        return root;
    }
        
   public void put(K key, V value) {
        if (this.root != null) {
            put(key, value, this.root);
        } else {
            this.root = new TreeNode(key, value);
        }
        this.size = this.size + 1;
    }
    
    private void put(K key, V value, TreeNode currentNode) {
        if (key.compareTo(currentNode.key) < 1) {
            if (currentNode.leftChild != null) {
                put(key, value, currentNode.leftChild);
            } else {
                currentNode.leftChild = new TreeNode(key, value,
                    currentNode);
            }
        } else {
            if (currentNode.rightChild != null) {
                put(key, value, currentNode.rightChild);
            } else {
                currentNode.rightChild = new TreeNode(key, value,
                    currentNode);
            }
        }
    }
    
    public V get(K key) {
        if (this.root != null) {
            TreeNode result = get(key, this.root);
            if (result != null) {
                return result.value;
            }
        }
        return null;
    }

    private TreeNode get(K key, TreeNode currentNode) {
        if (currentNode == null) {
            return null;
        }
        if (key.compareTo(currentNode.key) == 0) {
            return currentNode;
        } else if (key.compareTo(currentNode.key) < 0) {
            return get(key, currentNode.leftChild);
        } else {
            return get(key, currentNode.rightChild);
        }
    }
    
    public boolean containsKey(K key) {
        TreeNode result = get(key, this.root);
        return (result != null);
    }
    
    class TreeNode {
        private K key;
        private V value;
        TreeNode leftChild;
        TreeNode rightChild;
        TreeNode parent;
        
        TreeNode(K key, V value) {
            this(key, value, null, null, null);
        }
        
        TreeNode(K key, V value, TreeNode parent) {
            this(key, value, null, null, parent);
        }
        
        TreeNode(K key, V value, TreeNode left, TreeNode right, TreeNode parent) {
            this.key = key;
            this.value = value;
            this.leftChild = left;
            this.rightChild = right;
            this.parent = parent;
        }
        
        /* Is this node a left child of a parent? */
        boolean isLeftChild() {
            return parent != null && parent.leftChild == this;
        }
        
        /* Is this node a right child of a parent? */
        boolean isRightChild() {
            return parent != null && parent.rightChild == this;
        }
        
        /* Is this the root node? (The root node has no parent) */
        boolean isRoot() {
            return parent == null;
        }
        
        /* Is this a leaf node? (Leaf nodes have no children) */
        boolean isLeaf() {
            return (leftChild == null && rightChild == null);
        }
        
        /* Does this node have any children? */
        boolean hasAnyChild() {
            return leftChild != null || rightChild != null;
        }
        
        /* Does this node have both left and right children? */
        boolean hasChildren() {
            return leftChild != null && rightChild != null;
        }
        
        void replaceValue(K key, V value, TreeNode left, TreeNode right) {
            this.key = key;
            this.value = value;
            this.leftChild = left;
            this.rightChild = right;
            if (this.leftChild != null) {
                this.leftChild.parent = this;
            }
            if (this.rightChild != null) {
                this.rightChild.parent = this;
            }
        }

        public K getKey() {
            return this.key;
        }
        
        public V getValue() {
            return this.value;
        }
        
        public String toString() {
            String keyStr = (key == null) ? "null" : key.toString();
            String valStr = (value == null) ? "null" : value.toString();
            return "key: " + key + " value: " + value + "\n  " +
                " left: " + leftChild + " right: " + rightChild + 
                "parent: " + parent;
        }
    }
}
