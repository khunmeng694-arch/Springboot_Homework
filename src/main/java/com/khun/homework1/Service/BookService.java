package com.khun.homework1.Service;

import com.khun.homework1.Model.BookModel;

import java.util.List;

public interface BookService {
    List<BookModel> getAllBook();
    BookModel getBookById(int Id);
    BookModel createBook(BookModel bookModel);
    BookModel updateBook(int Id,BookModel bookModel);
    BookModel deleteBook(int Id);
}
