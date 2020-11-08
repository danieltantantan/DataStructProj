import java.util.*;
import java.io.*;

public class SearchResultDAO {
    private Scanner sc = null;
    HashSet<String> searchQueries = new HashSet<String>();
    private ArrayList<Node> headNodes = new ArrayList<Node>();
    static Node[] hashTable;
    static int modValue = 0 ;
    public SearchResultDAO() {
        Node current = null;
        
        //Prepare linkedList of Nodes while keeping track of Headers nodes
        try  (Scanner sc = new Scanner(new File("./data/SearchResultsWithGrouping.csv"))){
            sc.useDelimiter(",");
            // Skip headers
            sc.nextLine();
            while(sc.hasNextLine()){
                String[] data = (sc.nextLine()).split(",");
                if (!(searchQueries.contains(data[0]))){
                    current = new Node(data[0]);
                    headNodes.add(current);
                    searchQueries.add(data[0]); 
                }
                int rank = Integer.parseInt(data[1]);
                String title = data[2];
                String url = data[3];
                String grouping = data[4];
                SearchResult result = new SearchResult(data[0], rank, title, url, grouping);
                Node tmp = new Node(result);
                current.setNext(tmp);
                current = tmp;               
            }
            
            //h(k) Starts , pair hashTable key to each header nodes . Arr size = 2* elements
            hashTable = new Node[headNodes.size()*2];
            modValue = headNodes.size()*2;
            for (int index = 0 ; index < headNodes.size() ; index ++){
                Node pointer = headNodes.get(index);
                if (pointer.getElement() instanceof String){
                    int hashedKey = getHashKey((String)(pointer.getElement()));
                    hashTable[hashedKey] = pointer;
           //         System.out.println(hashedKey);
                    /// for Testing
               /*      Node next = pointer.getNext();
                    while (next != null){
                        System.out.println(next.getElement());
                        next = next.getNext();
                    } */

                    ////End of Test
                }
            }
        }catch (Exception e){
            System.out.println(e);
           if (sc !=null){
                sc.close();
           }
            
        }

        
    }
    public static void main (String[] args){
        SearchResultDAO test = new SearchResultDAO();
        System.out.println(getResult("nus computer science"));
    }

    public static int getHashKey(String searchterm){
        // Hashing function so that the hashcode of  search terms matters e.g "hello world" vs "world hello"
        int h = 0;
        int g = 5;
        for (int i = 0 ; i < searchterm.length() ; i++){
            h = g * h +((int) searchterm.charAt(i));
        }

        h = h % modValue;
      
        //Linear probing
        while ( hashTable[h]!= null){
            if ((h+1) >= hashTable.length){
                h = 0;
            }
            else{
             //   System.out.print("Probing from: "+h+" to: ");
                h += 1;
            //    System.out.println(h);

            }
        }
        return h;

    }
    public ArrayList<Node> getQueries(){
        return this.headNodes;
    }
    public static Node getResult(String searchQuery){
        int h = 0;
        int g = 5;
        for (int i = 0 ; i < searchQuery.length() ; i++){
            h = g * h +((int) searchQuery.charAt(i));
        }

        h = h % modValue;
      
        //Linear probing
        while (!hashTable[h].getElement().equals(searchQuery)){
            if ((h+1) >= hashTable.length){
                h = 0;
            }
            else{
                h += 1;
            }
        }
        return hashTable[h];
        
    }

}