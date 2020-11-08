import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import com.opencsv.*;


public class Main {

    private static final String SAMPLE_CSV_FILE_PATH = "./src/CS201.csv";

    public static void main(String[] args) throws Exception
   {

      Trie trie = new Trie();
       SearchResultDAO SRDAO = new SearchResultDAO();
       List<Node> heads = SRDAO.getQueries();
       for(Node temp : heads){
           while(temp.getNext()!= null){
               Node searchObj = temp.getNext();
               if (searchObj.getElement() instanceof SearchResult){
                   SearchResult test1 = (SearchResult) searchObj.getElement();
                   trie.insertWord(test1);
               }
               temp = temp.getNext();
           }
       }
       String word = args[0];
       TrieNode node = trie.searchPrefix(word);
       Map<String, List<List<String>>> toProcess = new HashMap<>();
       try{
        trie.printWith(node,null,0, new StringBuilder(""),toProcess);
        Iterator<String> iterateFinal = toProcess.keySet().iterator();
        Map<Integer,String> forSorting = new TreeMap<>();
        while (iterateFinal.hasNext()) {
            String group = iterateFinal.next();
            Collections.sort(toProcess.get(group), new Comparator<List<String>> () {
                @Override
                public int compare(List<String> a, List<String> b) {
                    return a.get(1).compareTo(b.get(1));
                }
            });
            forSorting.put(Integer.parseInt(toProcess.get(group).get(0).get(1)), group);
        }
        Map<String, List<List<String>>> sortedMap = new LinkedHashMap<>();
        Iterator<Integer> resultIterator = forSorting.keySet().iterator();
        while (resultIterator.hasNext()) {
            Integer temp = resultIterator.next();
            String group = forSorting.get(temp);
            sortedMap.put(group, toProcess.get(group));
        }
        System.out.println(sortedMap.toString());
       }catch(Exception e){
           System.out.println("Word not found");
       }
      
   }

}
