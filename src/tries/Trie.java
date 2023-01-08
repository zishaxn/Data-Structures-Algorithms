package tries;

public class Trie {
    //root of node
    private TrieNode root;
    private int numWords;

    public Trie() {
        root = new TrieNode('\0');
    }


    /*******************************************************************************************************/
    //Method to add a given String in Tree
    public void add(String word) {
        addHelper(root, word);
        numWords++;
    }

    //Helper Method To Add a word in the Trie.
    private void addHelper(TrieNode root, String word) {
        if (word.length() == 0) {
            root.isTerminalNode = true;
            return;
        }

        int childIndex = word.charAt(0) - 'A';
        TrieNode child = root.children[childIndex];
        if (child == null) {
            child = new TrieNode(word.charAt(0));
            root.children[childIndex] = child;
            root.childCount++;
        }
        addHelper(child, word.substring(1));
    }

    /*******************************************************************************************************/

    //Method to check if given String is present
    public boolean isPresent(String word) {
        return isPresentHelper(root, word);
    }

    private boolean isPresentHelper(TrieNode root, String word) {
        if (root.isTerminalNode && word.length() == 0) {
            return true;
        }
        if (word.length() == 0) {
            return false;
        }

        int childIndex = word.charAt(0) - 'A';
        TrieNode child = root.children[childIndex];
        if (child == null) {
            return false;
        }
        return isPresentHelper(child, word.substring(1));
    }


    /*******************************************************************************************************/
    //Method to Remove The given String
    public void remove(String word) {
        remove(root, word);
    }
    private void remove(TrieNode root, String word) {
        if (root.isTerminalNode && word.length() == 0) {
            root.isTerminalNode = false;
            return;
        }
        int childIndex = word.charAt(0) - 'A';
        TrieNode child = root.children[childIndex];
        if (child == null) {
            return;
        }
        remove(child, word.substring(1));
        if (!child.isTerminalNode && child.childCount == 0) {
            root.children[childIndex] = null;
            root.childCount--;
        }

    }

    /*******************************************************************************************************/
    public int getNumWords(){
        return numWords;
    }
}
