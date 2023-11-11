class BinarySearchTree<K extends Comparable<K>, V extends Comparable<V>>
    implements Iterable<BinarySearchTree<K, V>.TreeNode> {

    TreeNode root;
    int size;
    
    public BinarySearchTree() {
        this.root = null;
        size = 0;
    }
    
    public int size() {
        return size;
    }
    
    public Iterator<TreeNode> iterator() {
        return new TreeIterator();
    }
     
    public void put(K key, V value) {
        if (this.root != null) {
            put(key, value, this.root);
        } else {
            this.root = new TreeNode(key, value);
        }
        this.size = this.size + 1;
    }
    
    void put(K key, V value, TreeNode currentNode) {
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

    TreeNode get(K key, TreeNode currentNode) {
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
    
    public TreeNode removeKey(K key) {
        if (size > 1) {
            TreeNode nodeToRemove = get(key, root);
            if (nodeToRemove != null) {
                removeNode(nodeToRemove);
                size = size - 1;
                return nodeToRemove;
            } else {
                throw new NoSuchElementException(
                    key.toString() + " not in tree."); 
            }
        } else if (size == 1 && root.key.equals(key)) {
            root = null;
            size = size - 1;
            return null;
        } else {
            throw new NoSuchElementException(
                    key.toString() + " not in tree.");
        }
    }
    
    void adjustParent(TreeNode nodeToRemove, TreeNode childOfRemoved) {
        if (nodeToRemove.isLeftChild()) {
            childOfRemoved.parent = nodeToRemove.parent;
            nodeToRemove.parent.leftChild = childOfRemoved;
        } else if (nodeToRemove.isRightChild()) {
            childOfRemoved.parent = nodeToRemove.parent;
            nodeToRemove.parent.rightChild = childOfRemoved;
        } else {
            nodeToRemove.replaceValue(
                childOfRemoved.key,
                childOfRemoved.value,
                childOfRemoved.leftChild,
                childOfRemoved.rightChild);
        }
    }    

    void removeNode(TreeNode currentNode) {
        // case 1: the current node is a leaf node
        if (currentNode.isLeaf()) {
            if (currentNode == currentNode.parent.leftChild) {
                currentNode.parent.leftChild = null;
            } else {
                currentNode.parent.rightChild = null;
            }
        } else if (currentNode.hasChildren()) { // case 3: two chilren
            TreeNode successor = currentNode.findSuccessor();
            successor.spliceOut();
            currentNode.key = successor.key;
            currentNode.value = successor.value;
        }
        else { // case 2: one child only
            if (currentNode.leftChild != null) {
                adjustParent(currentNode, currentNode.leftChild);
            }
            else {
                adjustParent(currentNode, currentNode.rightChild);
            }
        }
    }

    /*
     * Return nested list representation of tree
     */
    public String toString() {
        return stringify(this.root);
    }

    String stringify(TreeNode node) {
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

    class TreeNode {
        K key;
        V value;
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
                "parent: " + parent;
        }

        TreeNode findSuccessor() {
            TreeNode successor = null;
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
        
        TreeNode findMinimumChild() {
            TreeNode current = this;
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
    
    class TreeIterator implements Iterator<BinarySearchTree<K, V>.TreeNode> {
        TreeNode iteratorNode;
        
        public TreeIterator() {
            if (root.leftChild == null) {
                iteratorNode = root;
            } else {
                iteratorNode = root.findMinimumChild();
            }
        }
        
        public boolean hasNext() {
            return iteratorNode != null;
        }
        
        public TreeNode next() {
            TreeNode result = null;
            if (iteratorNode != null) {
                result = iteratorNode;
                iteratorNode = iteratorNode.findSuccessor();
            }
            return result;
        }
    }
}
