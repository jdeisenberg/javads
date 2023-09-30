import java.util.Iterator;
import java.util.NoSuchElementException;

public class AVLTree<K extends Comparable<K>, V extends Comparable<V>>
    implements Iterable<AVLTree<K, V>.AVLTreeNode> {

    AVLTreeNode root;
    int size;

    public AVLTree() {
        this.root = null;
        this.size = 0;
    }
    
    public Iterator<AVLTreeNode> iterator() {
        return new AVLIterator();
    }
    
    public V get(K key) {
        if (this.root != null) {
            AVLTreeNode result = get(key, this.root);
            if (result != null) {
                return result.value;
            }
        }
        return null;
    }

    AVLTreeNode get(K key, AVLTreeNode currentNode) {
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
        AVLTreeNode result = get(key, this.root);
        return (result != null);
    }

    public void put(K key, V value) {
        if (this.root != null) {
            put(key, value, this.root);
        } else {
            this.root = new AVLTreeNode(key, value);
        }
        this.size = this.size + 1;
    }

    void put(K key, V value, AVLTreeNode currentNode) {
        if (key.compareTo(currentNode.key) < 0) {
            if (currentNode.leftChild != null) {
                put(key, value, currentNode.leftChild);
            } else {
                currentNode.leftChild = new AVLTreeNode(
                    key, value, currentNode);
                updateBalance(currentNode.leftChild);
            }
        } else {
            if (currentNode.rightChild != null) {
                put(key, value, currentNode.rightChild);
            } else {
                currentNode.rightChild = new AVLTreeNode(
                    key, value, currentNode);
                updateBalance(currentNode.rightChild);
            }
        }
    }
    
    void updateBalance(AVLTreeNode node) {
        if (node.balanceFactor > 1 || node.balanceFactor < -1) {
            rebalance(node);
        } else {
            if (node.parent != null) {
                if (node.isLeftChild()) {
                    node.parent.balanceFactor += 1;
                } else if (node.isRightChild()) {
                    node.parent.balanceFactor -= 1;
                }
                
                if (node.parent.balanceFactor != 0) {
                    updateBalance(node.parent);
                }
            }
        }
    }
    
    void rotateLeft(AVLTreeNode rotationRoot) {
        AVLTreeNode newRoot = rotationRoot.rightChild;
        rotationRoot.rightChild = newRoot.leftChild;
        if (newRoot.leftChild != null) {
            newRoot.leftChild.parent = rotationRoot;
        }
        newRoot.parent = rotationRoot.parent;
        if (rotationRoot.isRoot()) {
            root = newRoot;
        } else {
            if (rotationRoot.isLeftChild()) {
                rotationRoot.parent.leftChild = newRoot;
            } else {
                rotationRoot.parent.rightChild = newRoot;
            }
        }
        newRoot.leftChild = rotationRoot;
        rotationRoot.parent = newRoot;
        rotationRoot.balanceFactor = rotationRoot.balanceFactor + 1 -
            Math.min(newRoot.balanceFactor, 0);
        newRoot.balanceFactor = newRoot.balanceFactor + 1 +
            Math.max(rotationRoot.balanceFactor, 0);
    }
    
    void rotateRight(AVLTreeNode rotationRoot) {
        AVLTreeNode newRoot = rotationRoot.leftChild;
        rotationRoot.leftChild = newRoot.rightChild;
        if (newRoot.rightChild != null) {
            newRoot.rightChild.parent = rotationRoot;
        }
        newRoot.parent = rotationRoot.parent;
        if (rotationRoot.isRoot()) {
            root = newRoot;
        } else {
            if (rotationRoot.isRightChild()) {
                rotationRoot.parent.rightChild = newRoot;
            } else {
                rotationRoot.parent.leftChild = newRoot;
            }
        }
        newRoot.rightChild = rotationRoot;
        rotationRoot.parent = newRoot;
        rotationRoot.balanceFactor = rotationRoot.balanceFactor - 1 +
            Math.max(newRoot.balanceFactor, 0);
        newRoot.balanceFactor = newRoot.balanceFactor - 1 +
            Math.min(rotationRoot.balanceFactor, 0);
    }
    
    void rebalance(AVLTreeNode node) {
        if (node.balanceFactor < 0) {
            if (node.rightChild.balanceFactor > 0) {
                rotateRight(node.rightChild);
                rotateLeft(node);
            } else {
                rotateLeft(node);
            }
        } else if (node.balanceFactor > 0) {
            if (node.leftChild.balanceFactor < 0) {
                rotateLeft(node.leftChild);
                rotateRight(node);
            } else {
                rotateRight(node);
            }
        }
    }

    /*
     * Return nested list representation of tree
     */
    public String toString() {
        return stringify(this.root);
    }

    String stringify(AVLTreeNode node) {
        String result = "";
        if (node != null) {
            if (node.isLeaf()) {
                result = " [" +  node.key + "]";
            } else {
                result = " [" + node.key + stringify(node.leftChild) +
                    stringify(node.rightChild) + "]";
            }
        } else {
            result = " []";
        }
        return result;
    }

    class AVLTreeNode {
        K key;
        V value;
        AVLTreeNode leftChild;
        AVLTreeNode rightChild;
        AVLTreeNode parent;
        int balanceFactor;
        
        AVLTreeNode(K key, V value) {
            this(key, value, null, null, null, 0);
        }
        
        AVLTreeNode(K key, V value, AVLTreeNode parent) {
            this(key, value, null, null, parent, 0);
        }
        
        AVLTreeNode(K key, V value, AVLTreeNode left, AVLTreeNode right, AVLTreeNode parent,
            int balanceFactor) {
            this.key = key;
            this.value = value;
            this.leftChild = left;
            this.rightChild = right;
            this.parent = parent;
            this.balanceFactor = balanceFactor;
        }
        
        public int getBalanceFactor() {
            return this.balanceFactor;
        }
        
        public void setBalanceFactor(int balanceFactor) {
            this.balanceFactor = balanceFactor;
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

        void replaceValue(K key, V value, AVLTreeNode left, AVLTreeNode right) {
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

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return this.value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public String toString() {
            String keyStr = (key == null) ? "null" : key.toString();
            String valStr = (value == null) ? "null" : value.toString();
            return "key: " + key + " value: " + value + "\n  " +
                " left: " + leftChild + " right: " + rightChild +
                " parent: " + parent + " balance: " + balanceFactor;
        }

        AVLTreeNode findSuccessor() {
            AVLTreeNode successor = null;
            if (rightChild != null) {
                successor = rightChild.findMinimumChild();
            } else {
                if (parent != null) {
                    if (isLeftChild()) {
                        successor = parent;
                    } else {
                        parent.rightChild = null;
                        successor = parent.findSuccessor();
                        parent.rightChild = this;
                    }
                }
            }
            return successor;
        }

        AVLTreeNode findMinimumChild() {
            AVLTreeNode current = this;
            while (current.leftChild != null) {
                current = current.leftChild;
            }
            return current;
        }

        void spliceOut() {
            if (this.isLeaf()) {
                if (this.isLeftChild()) {
                    this.parent.leftChild = null;
                } else {
                    this.parent.rightChild = null;
                }
            } else if (this.hasAnyChild()) {
                if (this.leftChild != null) {
                    if (this.isLeftChild()) {
                        this.parent.leftChild = this.leftChild;
                    } else {
                        this.parent.rightChild = this.leftChild;
                    }
                    this.leftChild.parent = this.parent;
                } else {
                    if (this.isLeftChild()) {
                        this.parent.leftChild = this.rightChild;
                    } else {
                        this.parent.rightChild = this.rightChild;
                    }
                    this.rightChild.parent = this.parent;
                }
            }
        }
    }

    class AVLIterator implements Iterator<AVLTree<K, V>.AVLTreeNode> {
        AVLTreeNode iteratorNode;
        
        public AVLIterator() {
            if (root.leftChild == null) {
                iteratorNode = root;
            } else {
                iteratorNode = root.findMinimumChild();
            }
        }
        
        public boolean hasNext() {
            return iteratorNode != null;
        }
        
        public AVLTreeNode next() {
            AVLTreeNode result = null;
            if (iteratorNode != null) {
                result = iteratorNode;
                iteratorNode = iteratorNode.findSuccessor();
            }
            return result;
        }
    }
}
