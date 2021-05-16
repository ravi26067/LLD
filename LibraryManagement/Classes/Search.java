package lld.lms;

import lld.lms.enums.BookType;

import java.util.Date;
import java.util.List;

public interface Search {

    List<BookItem> searchByAuthor(Author author);

    List<BookItem> searchByTitle(String title);

    List<BookItem> searchByDateofPublication(Date date);

    List<BookItem> searchByCatagory(BookType catagory);
}
