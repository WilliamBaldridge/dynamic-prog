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


}
