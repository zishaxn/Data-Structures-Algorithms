package tries;

public class TrieTest {
    public static void main(String[] args) {
        Trie t = new Trie();
        t.add("AND");
        t.add("ANDY");
        t.add("BEST");
        System.out.println(t.getNumWords());
        System.out.println(t.isPresent("AND"));
    }
}
