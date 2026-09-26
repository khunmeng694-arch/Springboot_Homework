package com.khun.homework1.Service;

import com.khun.homework1.Model.BookModel;
import com.khun.homework1.Repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookServiceImp implements BookService {
    private final BookRepository bookRepository;
    public BookServiceImp(BookRepository bookRepository){
        this.bookRepository=bookRepository;
    }
    @Override
    public List<BookModel> getAllBook() {
        return bookRepository.findAll();
    }

    @Override
    public BookModel getBookById(int Id) {
        return bookRepository.findbyid(Id);
    }

    @Override
    public BookModel createBook(BookModel bookModel) {
        return bookRepository.save(bookModel);
    }

    @Override
    public BookModel updateBook(int Id, BookModel bookModel) {
        return bookRepository.update(Id,bookModel);
    }

    @Override
    public BookModel deleteBook(int Id) {
        return bookRepository.delete(Id);
    }
}
