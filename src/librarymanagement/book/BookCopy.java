package librarymanagement.book;

public class BookCopy {
    //Composition over inheritance
    private final BookDetails bookDetails;
    private final int id;

    public BookCopy(BookDetails bookDetails, int id) {
        this.bookDetails = bookDetails;
        this.id = id;
    }
}
