package datastructs.hashtables;

public class HashTableNotes {


    // A Hash table is a data structure that provides a mapping from keys to values using a technique called "hashing". key-value pairs, keys are unique

    // Often used to track item frequencies (i.e. counting the number of times a word appears in a given text)

    /*
    A hash function H(x) is a function that maps a key 'x' to a whole number in a fixed range.

    Example, H(x) = (x^2 - 6x + 9) modulo 10, maps all integer keys to the range [0, 9]

    H(4) = (16 - 24 + 9) modulo 10 = 1
    H(-7) = (49 + 42 + 9) mod 10 = 0
    H(0) = (0 - 0 + 9) % 10 = 9

    the hash values are great for comparing objects, by checking against the hash values instead of the objects themselves, thus speeding up object comparisons.

    *Note*
    Hash functions for files are more sophisticated than those used for hash tables. These are called cryptographic hash functions aka checksums

    Hash functions must be "deterministic"
    meaning, if H(x) = y then H(x) must always produce y and never another value.

    We try very hard to make "uniform" hash functions to minimize the number of hash collisions. A "hash collision" is when two objects y, y has to the same value

    To enforce deterministic behavior, we ensure that the keys used in our hash table are immutable data types (const/final, etc.)

    *** Can only achieve constant time O(1) behaviour if you have a good "uniform hash function" ****


What to do if there is a hash collision???

    We use on of many hash collision resolution techniques, the two most popular are separate chaining and open addressing

    Separate chaining: deals with hash collisions by maintaining a data structure (usually a linked list) to hold all the different values which hashed to a particular value.

    Open addressing: deals with hash collisions by finding another place within the hash table for the object to go by offsetting it from the position to which it hashed to.



                    Complexity
                Average         Worst
    Insertion      O(1)*            O(n)

    Removal        O(1)*            O(n)

    Search         O(1)*            O(n)

   ** only with good uniform hash functions **

     */

}
