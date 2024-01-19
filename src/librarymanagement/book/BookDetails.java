package librarymanagement.book;

import java.util.Date;
import java.util.List;

public class BookDetails {
    private final String name;
    private final Date date;
    private final List<String> authors;

    public BookDetails(String name, Date date, List<String> authors) {
        this.name = name;
        this.date = date;
        this.authors = authors;
    }
}
