package 数据结构.Tree.HuffumanCoding;
/******************************************************************************
 *  Compilation:  javac Huffman.java
 *  Execution:    java Huffman - < input.txt   (compress)
 *  Execution:    java Huffman + < input.txt   (expand)
 *  Dependencies: BinaryIn.java BinaryOut.java
 *  Data files:   https://algs4.cs.princeton.edu/55compression/abra.txt
 *                https://algs4.cs.princeton.edu/55compression/tinytinyTale.txt
 *                https://algs4.cs.princeton.edu/55compression/medTale.txt
 *                https://algs4.cs.princeton.edu/55compression/tale.txt
 *
 *  Compress or expand a binary input stream using the Huffman algorithm.
 *
 *  % java Huffman - < in.txt | java BinaryDump 60
 *
 *  010100000100101000100010010000110100001101010100101010000100
 *  000000000000000000000000000110001111100101101000111110010100
 *  120 bits
 *
 *  % java Huffman - < abra.txt | java Huffman +
 *  ABRACADABRA!
 *
 ******************************************************************************/

/**
 *  The {@code Huffman} class provides static methods for compressing
 *  and expanding a binary input using Huffman codes over the 8-bit extended
 *  ASCII alphabet.
 *  <p>
 *  For additional documentation,
 *  see <a href="https://algs4.cs.princeton.edu/55compression">Section 5.5</a> of
 *  <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 *
 *  @author Robert Sedgewick
 *  @author Kevin Wayne
 */
/**
 * https://www.cnblogs.com/wkfvawl/p/9783271.html
 * https://algs4.cs.princeton.edu/55compression/Huffman.java.html
 * https://algs4.cs.princeton.edu/home/
 */

//import edu.princeton.cs.algs4.BinaryStdIn;
//import edu.princeton.cs.algs4.BinaryStdOut;
//import edu.princeton.cs.algs4.MinPQ;

public class Huffman {
//    // alphabet size of extended ASCII
//    private static final int R = 256;
//
//    // Do not instantiate.
//    private Huffman() { }
//
//    // Huffman trie node
//    private static class Node implements Comparable<Node> {
//        private final char ch;
//        private final int freq;
//        private final Node left;
//        private final Node right;
//
//        Node(char ch, int freq, Node left, Node right) {
//            this.ch    = ch;
//            this.freq  = freq;
//            this.left  = left;
//            this.right = right;
//        }
//
//        // is the node a leaf node?
//        private boolean isLeaf() {
//            // 要么左右都为空， 要么左右都不为空
//            assert ((left == null) && (right == null)) || ((left != null) && (right != null));
//            return (left == null) && (right == null);
//        }
//
//        // compare, based on frequency
//        public int compareTo(Node that) {
//            return this.freq - that.freq;
//        }
//    }
//
//    /**
//     * Reads a sequence of 8-bit bytes from standard input; compresses them
//     * using Huffman codes with an 8-bit alphabet; and writes the results
//     * to standard output.
//     */
//    public static void compress() {
//        // read the input
//        String s = BinaryStdIn.readString();
//        char[] input = s.toCharArray();
//
//        // tabulate frequency counts
//        int[] freq = new int[R];
//        for (int i = 0; i < input.length; i++)
//            freq[input[i]]++;
//
//        // build Huffman trie
//        Node root = buildTrie(freq);
//
//        // build code table
//        String[] st = new String[R];
//        buildCode(st, root, "");
//
//        // print trie for decoder
//        writeTrie(root);
//
//        // print number of bytes in original uncompressed message
//        BinaryStdOut.write(input.length);
//
//        // use Huffman code to encode input
//        for (int i = 0; i < input.length; i++) {
//            String code = st[input[i]];
//            for (int j = 0; j < code.length(); j++) {
//                if (code.charAt(j) == '0') {
//                    BinaryStdOut.write(false);
//                }
//                else if (code.charAt(j) == '1') {
//                    BinaryStdOut.write(true);
//                }
//                else throw new IllegalStateException("Illegal state");
//            }
//        }
//
//        // close output stream
//        BinaryStdOut.close();
//    }
//
//    // 核心函数，建立霍夫曼树
//    // 建树，每次弹出权重最小的两个节点，然后将它们合并。当最后只剩下一个节点的时候，合并完成。
//    // build the Huffman trie given frequencies
//    private static Node buildTrie(int[] freq) {
//        // initialze priority queue with singleton trees
//        MinPQ<Node> pq = new MinPQ<Node>();
//        for (char c = 0; c < R; c++)
//            if (freq[c] > 0)
//                pq.insert(new Node(c, freq[c], null, null));
//
//        // merge two smallest trees
//        while (pq.size() > 1) {
//            Node left  = pq.delMin();
//            Node right = pq.delMin();
//            Node parent = new Node('\0', left.freq + right.freq, left, right);
//            pq.insert(parent);
//        }
//        return pq.delMin();
//    }
//
//    // write bitstring-encoded trie to standard output
//    private static void writeTrie(Node x) {
//        if (x.isLeaf()) {
//            BinaryStdOut.write(true);
//            BinaryStdOut.write(x.ch, 8);
//            return;
//        }
//        BinaryStdOut.write(false);
//        writeTrie(x.left);
//        writeTrie(x.right);
//    }
//
//    // 核心函数， 将字符 -> 对应的霍夫曼编码
//    // 数组st即为每个字符对应的01霍夫曼编码，其内容为 ->  A : 110, B : 111, C : 10, D : 00, E : 01 ...
//    // make a lookup table from symbols and their encodings
//    private static void buildCode(String[] st, Node x, String s) {
//        if (!x.isLeaf()) {
//            buildCode(st, x.left,  s + '0');
//            buildCode(st, x.right, s + '1');
//        }
//        else {
//            st[x.ch] = s;
//        }
//    }
//
//    /**
//     * Reads a sequence of bits that represents a Huffman-compressed message from
//     * standard input; expands them; and writes the results to standard output.
//     */
//    public static void expand() {
//
//        // read in Huffman trie from input stream
//        Node root = readTrie();
//
//        // number of bytes to write
//        int length = BinaryStdIn.readInt();
//
//        // decode using the Huffman trie
//        for (int i = 0; i < length; i++) {
//            Node x = root;
//            while (!x.isLeaf()) {
//                boolean bit = BinaryStdIn.readBoolean();
//                if (bit) x = x.right;
//                else     x = x.left;
//            }
//            BinaryStdOut.write(x.ch, 8);
//        }
//        BinaryStdOut.close();
//    }
//
//
//    private static Node readTrie() {
//        boolean isLeaf = BinaryStdIn.readBoolean();
//        if (isLeaf) {
//            return new Node(BinaryStdIn.readChar(), -1, null, null);
//        }
//        else {
//            return new Node('\0', -1, readTrie(), readTrie());
//        }
//    }

    /**
     * Sample client that calls {@code compress()} if the command-line
     * argument is "-" an {@code expand()} if it is "+".
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
//        if
//            (args[0].equals("-")) compress();
//        else if
//            (args[0].equals("+")) expand();
//        else
//            throw new IllegalArgumentException("Illegal command line argument");
    }
}
