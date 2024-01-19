package librarymanagement.dataaccessor;

import librarymanagement.book.BookCopy;

import librarymanagement.user.Member;
import java.util.List;

public class DBAccessor {
    public Results getBooksWithName(String bookName){
        return null;
    }

    public Results getBooksWithAuthorNames(List<String> authorNames){
        return null;
    }

    public Results getMembersWithNames(String memberName){
        return null;
    }

    public void insertBookCopy(BookCopy bookCopy){

    }

    public void deleteBookCopy(BookCopy bookCopy){

    }

    public void markAsBlocked(Member member){

    }

    public void issueBookCopyToMember(BookCopy bookCopy, Member member){

    }

    public void submitBookCopyFromMember(BookCopy bookCopy, Member member){

    }

    public boolean isCopyAvailable(BookCopy bookCopy){
        return true;
    }

    public Results getBorrower(BookCopy bookCopy){
        return null;
    }

    public Results getBorrowedBooks(Member member){
        return null;
    }
}
