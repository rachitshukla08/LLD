package librarymanagement.searcher;

import librarymanagement.book.BookCopy;
import librarymanagement.dataaccessor.DBAccessor;
import librarymanagement.dataaccessor.Results;
import librarymanagement.dataaccessor.ResultsConverter;

import java.util.List;

public class NameBasedBookSearcher implements BookSearcher{

    private final String bookName;
    private final DBAccessor dbAccessor;

    public NameBasedBookSearcher(String bookName, DBAccessor dbAccessor){
        this.bookName = bookName;
        this.dbAccessor = dbAccessor;
    }

    @Override
    public List<BookCopy> search() {
        Results results = dbAccessor.getBooksWithName(this.bookName);
        return ResultsConverter.convertToBookCopies(results);
    }
}
