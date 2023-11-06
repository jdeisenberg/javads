import java.util.ArrayList;

public class Octree {
    OTNode root;
    int numLeaves;
    int maxLevel;
    ArrayList<OTNode> allLeaves;
    
    public Octree() {
        this.root = null;
        this.maxLevel = 5;
        this.numLeaves = 0;
        this.allLeaves = new ArrayList<OTNode>();
    }
    
    public void insert(int r, int g, int b) {
        if (this.root == null) {
            this.root = new OTNode(null, 0, this);
        }
        this.root.insert(r, g, b, 0, this);
    }
    
    public int[] find(int r, int g, int b) {
        if (this.root != null) {
            return this.root.find(r, g, b, 0);
        } else {
            return null;
        }
    }
    
    public void reduce(int maxCubes) {
        System.err.printf("Reducing %d to %d%n",
            this.allLeaves.size(), maxCubes);
        while (this.allLeaves.size() > maxCubes) {
            OTNode smallest = this.findMinCube();
            smallest.parent.merge();
            this.allLeaves.add(smallest.parent);
            this.numLeaves += 1;
        }
    }
    
    public OTNode findMinCube() {
        int minCount = Integer.MAX_VALUE;
        int maxLevel = 0;
        OTNode minCube = null;
        
        for (OTNode node: allLeaves) {
            if (node.count <= minCount && node.level >= maxLevel) {
                minCube = node;
                minCount = node.count;
                maxLevel = node.level;
            }
        }
        return minCube;
    }
    
    
    public class OTNode {
        public int red;
        public int green;
        public int blue;
        public int count;
        public OTNode parent;
        public int level;
        public Octree oTree;
        public OTNode[] children;
        
        public OTNode() {
            this(null, 0, null);
        }
        
        public OTNode(OTNode parent, int level, Octree outer) {
            this.red = 0;
            this.green = 0;
            this.blue = 0;
            this.parent = parent;
            this.level = level;
            this.oTree = outer;
            this.children = new OTNode[8];
        }
        
        public void insert(int r, int g, int b, int level, Octree outer) {
            if (level < oTree.maxLevel) {
                int index = computeIndex(r, g, b, level);
                if (this.children[index] == null) {
                    this.children[index] = new OTNode(this, level + 1, outer);
                }
                this.children[index].insert(r, g, b, level + 1, outer);
            } else {
                if (this.count == 0) {
                    this.oTree.numLeaves = this.oTree.numLeaves + 1;
                    this.oTree.allLeaves.add(this);
                }
                this.red += r;
                this.green += g;
                this.blue += b;
                this.count += 1;
            }
        }
        
        public int computeIndex(int r, int g, int b, int level) {
            int nShift = 8 - level;
            int rBits = (r >> (nShift - 2)) & 0x04;
            int gBits = (g >> (nShift - 1)) & 0x02;
            int bBits = (b >> nShift) & 0x01;
            return rBits | gBits | bBits;
        }
        
        public int[] find(int r, int g, int b, int level) {
            if (level < this.oTree.maxLevel) {
                int index = computeIndex(r, g, b, level);
                if (this.children[index] != null) {
                    return this.children[index].find(r, g, b, level + 1);
                } else if (this.count > 0) {
                    return new int[] {this.red / this.count,
                        this.green / this.count, this.blue / this.count};
                } else {
                    System.err.printf(
                        "No leaf node to represent RGB(%d, %d, %d)%n",
                            r, g, b);
                    return null;
                }
            } else {
                return new int[] {this.red / this.count,
                    this.green / this.count, this.blue / this.count};
            }
        }
        
        public void merge() {
            for (OTNode child: this.children) {
                if (child != null) {
                    if (child.count > 0) {
                        boolean removed = this.oTree.allLeaves.remove(child);
                        this.oTree.numLeaves -= 1;
                    } else {
                        System.err.println("Recursively merging non-leaf");
                        System.exit(0);
                        child.merge();
                    }

                    this.count += child.count;
                    this.red += child.red;
                    this.green += child.green;
                    this.blue += child.blue;
                }
            }
            
            for (int i = 0; i < 8; i++) {
                this.children[i] = null;
            }
        }
    }
}
