package tries;

public class TrieNode {
    char data;  // Every node itself is char;
    boolean isTerminalNode;
    TrieNode[] children; //reference to it child nodes.
    int childCount=0;   //counts number of children of particular node

    public TrieNode(char data) {
        this.data = data;
        this.isTerminalNode = false;
        this.children = new TrieNode[26];
        this.childCount=0;
    }
}
