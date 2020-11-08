
public class SearchResult {
    private String searchQuery;
    private int rank;
    private String title;
    private String url;
    private String grouping;

    public SearchResult(String searchQuery, int rank, String title, String url, String grouping) {
        this.searchQuery = searchQuery;
        this.rank = rank;
        this.title = title;
        this.url = url;
        this.grouping = grouping;
    }

    public String getSearchQuery() {
        return searchQuery;
    }

    public int getRank() {
        return rank;
    }

    public String getTitle() {
        return title;
    }

    public String getURL() {
        return url;
    }

    public String getGrouping() {
        return grouping;
    }

    public String toString() {
        return "Search Query: " + searchQuery + ", Rank: " + rank + ", Title: " + title + ", URL: " + url + ", Grouping: " + grouping;
    }
}