package librarymanagement.tester;

import librarymanagement.auth.UserAuthenticator;
import librarymanagement.book.BookCopy;
import librarymanagement.book.BookDetails;
import librarymanagement.dataaccessor.DBAccessor;
import librarymanagement.id.IDGenerator;
import librarymanagement.lib.Library;
import librarymanagement.searcher.*;
import librarymanagement.user.Member;

import java.util.Date;
import java.util.List;

public class Tester {

    private final DBAccessor dbAccessor;
    private final Library library;
    public Tester(){
        this.dbAccessor = new DBAccessor();
        this.library = new Library(this.dbAccessor);
    }
    public List<BookCopy> searchBooksByBookName(String bookName){
        if(bookName ==null)
            throw new IllegalArgumentException("Book name cannot be null");
        BookSearcher bookSearcher = new NameBasedBookSearcher(bookName, dbAccessor);
        return bookSearcher.search();
    }

    public List<BookCopy> searchBooksByAuthorNames(List<String> authorNames){
        if(authorNames ==null || authorNames.size() == 0)
            throw new IllegalArgumentException("Authornames cannot be null or empty");
        BookSearcher bookSearcher = new AuthorBasedBookSearcher(authorNames);
        return bookSearcher.search();
    }

    public List<Member> searchMembersByMemberName(String memberName, String adminToken) throws IllegalAccessException {
        if(!UserAuthenticator.isAdmin(adminToken))
            throw new IllegalAccessException("Operation forbidden");
        MemberSearcher memberSearcher = new NameBasedMemberSearcher(memberName);
        return memberSearcher.search();
    }

    public void addBook(String bookName, Date publicationDate, List<String> authors,
                        String adminToken) throws IllegalAccessException {
        if(!UserAuthenticator.isAdmin(adminToken))
            throw new IllegalAccessException("Operation forbidden");
        /**
        * Validation logic for bookname, date, author, etc
        * */

        BookCopy bookCopy = new BookCopy(new BookDetails(bookName, publicationDate,authors), IDGenerator.getUniqueID());
        this.library.addBookCopy(bookCopy);
    }

    public void deleteCopy(int bookCopyId, String adminToken) throws IllegalAccessException {
        if(bookCopyId<=0 || adminToken == null || adminToken.isEmpty())
            throw new IllegalArgumentException("Invalid parameters");
        if(!UserAuthenticator.isAdmin(adminToken))
            throw new IllegalAccessException("Operation forbidden");
        BookSearcher bookSearcher = new IDBasedBookSearcher(bookCopyId);
        List<BookCopy> bookCopies = bookSearcher.search();
        if(bookCopies == null || bookCopies.isEmpty())
            throw new RuntimeException("No book copies retrieved for given id");
        this.library.deleteBookCopy(bookCopies.get(0));
    }

    public void blockMember(int memberId, String adminToken) throws IllegalAccessException {
        if(memberId<=0 || adminToken == null || adminToken.isEmpty())
            throw new IllegalArgumentException("Invalid parameters");
        if(!UserAuthenticator.isAdmin(adminToken))
            throw new IllegalAccessException("Operation forbidden");
        MemberSearcher memberSearcher = new IDBasedMemberSearcher(memberId);
        List<Member> members = memberSearcher.search();
        if(members == null || members.isEmpty())
            throw new RuntimeException("No members retrieved for given id");
        this.library.blockMember(members.get(0));

    }

    public void issueBook(int bookCopyId, int memberId, String adminToken) throws IllegalAccessException {
        if(bookCopyId<=0 || memberId<=0 || adminToken == null || adminToken.isEmpty())
            throw new IllegalArgumentException("Invalid parameters");
        if(!UserAuthenticator.isAdmin(adminToken))
            throw new IllegalAccessException("Operation forbidden");
        BookSearcher bookSearcher = new IDBasedBookSearcher(bookCopyId);
        List<BookCopy> bookCopies = bookSearcher.search();
        if(bookCopies == null || bookCopies.isEmpty())
            throw new RuntimeException("No book copies retrieved for given id");
        MemberSearcher memberSearcher = new IDBasedMemberSearcher(memberId);
        List<Member> members = memberSearcher.search();
        if(members == null || members.isEmpty())
            throw new RuntimeException("No members retrieved for given id");
        this.library.issueBook(bookCopies.get(0), members.get(0));
    }

    public void submitBook(int bookCopyId, int memberId, String adminToken){

    }

    public Member getBorrowerOfBook(int bookCopyId, String adminToken){
        return null;
    }

    public List<BookCopy> getBooksBorrowedByMember(int memberId, String adminToken){
        return null;
    }
}
