import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.opencsv.CSVReader;

public class ProcessCSV {
    public static void main(String[] args) {
        try{
            // sc.useDelimiter(",");
            // // Skip headers
            // sc.nextLine();
            // while(sc.hasNextLine()){
            //     String[] data = (sc.nextLine()).split(",");
            //     int rank = Integer.parseInt(data[1]);
            //     String title = data[2];
            //     String url = data[3];
            //     System.out.println(url + title);
            //     URL toProcess = new URL(url);
            //     String groupURL = toProcess.getHost();
                
            //     System.out.println(String.format("A::main: protocol = '%s'", groupURL));
            //     System.out.println(groupURL);

            // }
            CSVReader reader = new CSVReader(new FileReader("./data/CS201Data.csv"));
            List<SearchResult> rows = new ArrayList<SearchResult>();
            String[] data;
            reader.readNext();
            while ((data = reader.readNext()) != null) {
                    URL toProcess = new URL(data[3]);
                    String groupURL = toProcess.getHost();
                    SearchResult toAdd = new SearchResult(data[0],Integer.parseInt(data[1]),data[2],data[3],groupURL);
                    rows.add(toAdd);
            }
            FileWriter csvWriter = new FileWriter("data/SearchResultsWithGrouping.csv");
            String[] headers = new String[] {"Search Query","Rank","Title","URL"};
            for (String string : headers) {
                csvWriter.append(string);
                csvWriter.append(",");
            }
            csvWriter.append("Domains");
            csvWriter.append("\n");
            for (SearchResult rowData : rows) {
                csvWriter.append(rowData.getSearchQuery());
                csvWriter.append(",");

                csvWriter.append(Integer.toString(rowData.getRank()));
                csvWriter.append(",");
                csvWriter.append(rowData.getTitle());
                csvWriter.append(",");
                csvWriter.append(rowData.getURL());
                csvWriter.append(",");
                csvWriter.append(rowData.getGrouping());
                csvWriter.append("\n");
            }
            csvWriter.flush();
            csvWriter.close();
        
        }catch (Exception e){
           System.out.println(e.toString());
        }
    }
}
