package librarymanagement.lib;

import librarymanagement.book.BookCopy;
import librarymanagement.dataaccessor.DBAccessor;
import librarymanagement.dataaccessor.Results;
import librarymanagement.dataaccessor.ResultsConverter;

import librarymanagement.user.Member;
import java.util.List;

public class Library {

    private final DBAccessor dbAccessor;

    public Library(DBAccessor dbAccessor) {
        this.dbAccessor = dbAccessor;
    }

    public void addBookCopy(BookCopy bookCopy){
        if(bookCopy == null) throw new IllegalArgumentException();
        dbAccessor.insertBookCopy(bookCopy);
    }

    public void deleteBookCopy(BookCopy bookCopy){
        boolean isCopyAvailable = dbAccessor.isCopyAvailable(bookCopy);
        if(isCopyAvailable)
            dbAccessor.deleteBookCopy(bookCopy);
    }

    public void blockMember(Member member){
        dbAccessor.markAsBlocked(member);
    }

    public void issueBook(BookCopy bookCopy, Member member){
        dbAccessor.issueBookCopyToMember(bookCopy, member);
    }

    public void submitBook(BookCopy bookCopy, Member member){
        dbAccessor.submitBookCopyFromMember(bookCopy, member);
    }

    public Member getBorrower(BookCopy bookCopy){
        Results result = dbAccessor.getBorrower(bookCopy);
        Member member = ResultsConverter.convertToMembers(result).get(0);
        return member;
    }

    public List<BookCopy> getBorrowedBooks(Member member){
        Results result = dbAccessor.getBorrowedBooks(member);
        List<BookCopy> bookCopies = ResultsConverter.convertToBookCopies(result);
        return bookCopies;
    }


}
