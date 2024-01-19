package librarymanagement.searcher;

import librarymanagement.book.BookCopy;

import java.util.List;

public interface BookSearcher {
    List<BookCopy> search();
}
