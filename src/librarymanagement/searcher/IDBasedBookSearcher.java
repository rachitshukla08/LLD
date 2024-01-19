package librarymanagement.searcher;

import librarymanagement.book.BookCopy;

import java.util.List;

public class IDBasedBookSearcher implements BookSearcher{
    private final int id;

    public IDBasedBookSearcher(int id) {
        this.id = id;
    }

    @Override
    public List<BookCopy> search() {
        return null;
    }
}
