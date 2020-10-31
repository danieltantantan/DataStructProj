import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class Trie{

    TrieNode rootNode;

    public Trie(){
        rootNode = new TrieNode();
    }

    public void insertWord(String searchTerm, String URL, String grouping, String rank){
        TrieNode current = rootNode;
        String buildTogether = searchTerm + URL;
        boolean groupSet = false;
        for (int i = 0; i < URL.length() + searchTerm.length(); i++) {
            char c = buildTogether.charAt(i);
            Map<Character,TrieNode> children = current.getChildren();
            if(children.containsKey(c)){
                current = children.get(c);
            }
            else{
                TrieNode trieNode = new TrieNode();
                children.put(c, trieNode);
                current = children.get(c);
            }
            if(!groupSet && buildTogether.substring(0,i).contains(grouping)){
                current.setGroupName(grouping);
                groupSet = true;
            }
            if(i == searchTerm.length() - 1){
                current.setSearchTerm(searchTerm);
            }
        }
        current.setLeaf(true, rank);
    }

    public boolean searchWord(String word){
        TrieNode current = rootNode;
        for (int i = 0; i < word.length(); i++) {
            Map<Character, TrieNode> children = current.getChildren();
            char c = word.charAt(i);
            if(children.containsKey(c)){
                current = children.get(c);
            }
            else{
                return false;
            }
        }

        if(current.isLeaf() && current!=null){
            return true;
        }
        else{
            return false;
        }
    }

    public void print(TrieNode rootNode,int level, StringBuilder sequence) {
        if(rootNode.isLeaf()){
            sequence = sequence.insert(level, rootNode.getC());
//            System.out.println(sequence);
        }

        Map<Character, TrieNode> children = rootNode.getChildren();
        Iterator<Character> iterator = children.keySet().iterator();
        while (iterator.hasNext()) {
            char character = iterator.next();
            sequence = sequence.insert(level, character);
            print(children.get(character), level+1, sequence);
            sequence.deleteCharAt(level);
        }
    }
    public void printWith(TrieNode rootNode,TrieNode groupNode, int level, StringBuilder sequence, Map<String, List<String>> toProcess) {
        if(rootNode.isLeaf()){
            sequence = sequence.insert(level, rootNode.getC());
//            System.out.println(sequence);
        }
        TrieNode temp = groupNode;

        if(rootNode.isGroupSet()){
            temp = rootNode;
        }
        if(groupNode != null){
//            System.out.println(groupNode.getGroupName()+" GROUP NAME");
            if(rootNode.isLeaf()){
                toProcess.put(groupNode.getGroupName(), Arrays.asList(sequence.toString(), rootNode.getRank()));
            }
        }

        Map<Character, TrieNode> children = rootNode.getChildren();
        Iterator<Character> iterator = children.keySet().iterator();
        while (iterator.hasNext()) {
            char character = iterator.next();
            sequence = sequence.insert(level, character);
            printWith(children.get(character),temp, level+1, sequence, toProcess);
            sequence.deleteCharAt(level);
        }
    }
    public TrieNode searchPrefix(String word){
        TrieNode current = rootNode;
        for (int i = 0; i < word.length(); i++) {
            Map<Character, TrieNode> children = current.getChildren();
            char c = word.charAt(i);
            if(children.containsKey(c)){
                current = children.get(c);
            }
            else{
                return null;
            }
        }
        if(current.isSearchTermSet()){
            return current;
        }
        return null;
    }
    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isLeaf();
    }

    public boolean startsWith(String prefix) {
        TrieNode node = searchPrefix(prefix);
        return node != null;
    }
}