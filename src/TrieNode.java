import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

class TrieNode{

    private char c;
    private Map<Character,TrieNode> children = new HashMap<>();
    private boolean isLeaf = false;
    private String groupName = "";
    private boolean groupSet = false;
    private boolean searchTermSet = false;
    private String searchTerm = "";
    private String rank = "";
    TrieNode(){

    }

    /**
     * @param c the c to set
     */
    public void setC(char c) {
        this.c = c;
    }

    /**
     * @return the children
     */
    public Map<Character, TrieNode> getChildren() {
        return children;
    }

    /**
     * @return the isLeaf
     */
    public boolean isLeaf() {
        return isLeaf;
    }

    /**
     * @return the c
     */
    public char getC() {
        return c;
    }

    /**
     * @param isLeaf the isLeaf to set
     */
    public void setLeaf(boolean isLeaf, String number) {
        this.isLeaf = isLeaf;
        this.rank = number;
    }

    public String getRank(){
        return this.rank;
    }

    public void setGroupName(String groupName){
        this.groupName = groupName;
        this.groupSet = true;
    }

    public boolean isGroupSet(){
        return this.groupSet;
    }

    public String getGroupName(){
        return this.groupName;
    }

    public void setSearchTerm(String searchTerm) {
        this.searchTerm = searchTerm;
        this.searchTermSet = true;
    }

    public boolean isSearchTermSet(){
        return this.searchTermSet;
    }

    public void processNode(){
        Map<String, String[]> toReturn = new HashMap<>();
        for (Map.Entry<Character,TrieNode> child : children.entrySet()) {
            System.out.println("Key = " + child.getKey() + ", Value = " + child.getValue());
        }
    }
}
