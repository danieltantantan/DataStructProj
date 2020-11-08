//
//import java.util.*;
//
//public class SearchResultTable {
//    private HashMap<String, LinkedList<SearchResult>> map;
//    private SearchResultDAO searchResultDAO;
//
//    public SearchResultTable() {
//        // overall table is a hashmap - key is the search query, value is a linked list of all the search results for that query
//        map = new HashMap<String, LinkedList<SearchResult>>();
//        searchResultDAO = new SearchResultDAO();
//
//        // get all search results from searchresultDAO
//        ArrayList<SearchResult> searchResults = searchResultDAO.getSearchResults();
//
//        // get all unique search queries
//        Set<String> searchQueries = searchResultDAO.getSearchQueries();
//
//        // initialise table/linkedlists - initial map should have empty linked list for each search query
//        for (String query : searchQueries) {
//            LinkedList<SearchResult> searchList = new LinkedList<SearchResult>();
//            map.put(query, searchList);
//        }
//
//        for (SearchResult result : searchResults) {
//            String query = result.getSearchQuery();
//            // append search result to linkedlist
//            map.get(query).addLast(result);
//
//        }
//
//    }
//
//    public HashMap<String, LinkedList<SearchResult>> getMap() {
//        return map;
//    }
//
//    // public static void main(String[] args) {
//    //     SearchResultTable test = new SearchResultTable();
//    //     HashMap<String, LinkedList<SearchResult>> map = test.getMap();
//    //     LinkedList<SearchResult> list = map.get("smu computer science");
//    //     int i = 0;
//    //     for (SearchResult res :list) {
//
//    //         if (i == 6) {
//    //             break;
//    //         }
//    //         i++;
//    //         System.out.println(res);
//
//    //     }
//
//    // }
//
//}
