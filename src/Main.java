import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import com.opencsv.*;


public class Main {

    private static final String SAMPLE_CSV_FILE_PATH = "./src/CS201.csv";

    public static void main(String[] args) throws Exception
   {
      //Build reader instance
      //Read data.csv
      //Default seperator is comma
      //Default quote character is double quote
      //Start reading from line number 2 (line numbers start from zero)
      CSVReader reader = new CSVReader(new FileReader("./src/CS201.csv"));
      //Read CSV line by line and use the string array as you want
      String[] nextLine;
      Trie trie = new Trie();
       while ((nextLine = reader.readNext()) != null) {
         if (nextLine != null) {
            //Verifying the read data here
//             System.out.println(nextLine[3]);
             trie.insertWord(nextLine[0], nextLine[3], nextLine[4], nextLine[1]);
         }
       }
       TrieNode node = trie.searchPrefix("data science");
       Map<String, List<String>> toProcess = new HashMap<>();
       trie.printWith(node,null,0, new StringBuilder(""),toProcess);
       System.out.println(toProcess.toString());
   }
}
