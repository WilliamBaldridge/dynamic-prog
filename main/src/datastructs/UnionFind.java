package datastructs;

public class UnionFind {

    // Union Find is a data structure that keeps track of elements which are split into one or more disjoint sets, 2 primary operations find and union.


    // When & where used
    // 1. Kruskal's minimum spanning tree algo
    // 2. Grid percolation
    // 3. Network connectivity
    // 4. Least common ancestor in trees
    // 5. Image processing

    /*
               Complexity
        Construction         O(n)
        Union               alpha(n)
        Find                alpha(n)
        Get
        component           alpha(n)
        size
        Check if
        connected           alpha(n)
        Count
        components           O(1)

    alpha(n) is amortized constant time

     */

    // Can begin using Union Find by first constructing a bijection (a mapping) between your objects and the integers in the range [0, n]
    // This step is not necessary in general, but will allow to construct array-based union find

    // Find Operation:
    //  To *find* which component a particular element belongs to, find the root of that component by following the parent notes until a self-loop is reached (a node who's parent is itself)

    // Union Operation:
    //  To unify two elements, find which are the root nodes of each component and, if the root nodes are different, make one of the root nodes the parent of the other


    private int size;
    private int[] sizeComponents;

    // id[i] points to the parent of i, if id[i] = i then i is a root node
    private int[] id;

    // Tracks the number of components in the union find
    private int numComponents;

    public UnionFind(int size) {

        if (size <= 0) throw new IllegalArgumentException("Size must be > 0");

        this.size = numComponents = size;
        sizeComponents = new int[size];
        id = new int[size];

        for (int i = 0; i < size; i++) {

            id[i] = i;
            sizeComponents[i] = 1;
        }

    }

    // Find which component/set 'p' belongs to, takes amortized constant time.
    public int find(int p) {

        // Find the root of the component/set
        int root = p;
        while (root != id[root]) root = id[root];

        // Compress the path leading back to the root.
        // Doing this operation is called "path compression"
        // and is what gives us amortized time complexity.
        while (p != root) {

            int next = id[p];
            id[p] = root;
            p = next;
        }

        return root;
    }

    // This is an alternative recursive formulation for the find method
    // public int find(int p) {
    //   if (p == id[p]) return p;
    //   return id[p] = find(id[p]);
    // }

    // Return whether or not the elements 'p' and
    // 'q' are in the same components/set.
    public boolean connected(int p, int q) {

        return find(p) == find(q);
    }

    // Return the size of the components/set 'p' belongs to
    public int componentSize(int p) {

        return sizeComponents[find(p)];
    }

    // Return the number of elements in this UnionFind/Disjoint set
    public int size() {

        return size;
    }

    // Returns the number of remaining components/sets
    public int components() {

        return numComponents;
    }

    // Unify the components/sets containing elements 'p' and 'q'
    public void unify(int p, int q) {

        // These elements are already in the same group!
        if (connected(p, q)) return;

        int root1 = find(p);
        int root2 = find(q);

        // Merge smaller component/set into the larger one.
        if (sizeComponents[root1] < sizeComponents[root2]) {

            sizeComponents[root2] += sizeComponents[root1];
            id[root1] = root2;
            id[root2] = 0;
        } else {

            sizeComponents[root1] += sizeComponents[root2];
            id[root2] = root1;
            id[root1] = 0;
        }

        // Since the roots found are different we know that the
        // number of components/sets has decreased by one
        numComponents--;
    }

}
