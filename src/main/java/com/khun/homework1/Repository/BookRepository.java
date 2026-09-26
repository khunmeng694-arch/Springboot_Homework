package com.khun.homework1.Repository;

import com.khun.homework1.Model.BookModel;
import org.springframework.stereotype.Repository;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BookRepository {
    List<BookModel> bookModels = new ArrayList<>();
    public BookRepository(){
        bookModels.add(new BookModel(1,"Reneged Immortal","I don't Know"));
        bookModels.add(new BookModel(2,"battle through the heavens","I don't Know"));
        bookModels.add(new BookModel(3,"Immortal of sword","I don't Know"));
        bookModels.add(new BookModel(4,"Soul Land 1","I don't Know"));
    }
    public List<BookModel> findAll(){
        return bookModels;
    }
    public BookModel findbyid(int Id){
        return bookModels.stream()
                .filter( bookModel -> bookModel.getId()==Id)
                .findFirst()
                .orElse(null);
    }
    public BookModel save(BookModel bookModel){
        return bookModels.add(bookModel)?bookModel:null;
    }
    public BookModel update(int Id,BookModel bookModel){
        BookModel book = findbyid(Id);

        if(book == null){
            throw new RuntimeException("Id not found");
        }
        book.setId(bookModel.getId());
        book.setTitle(bookModel.getTitle());
        book.setAuthor(bookModel.getAuthor());
        return book;
    }
    public BookModel delete(int Id){
        BookModel book = findbyid(Id);
        if(book != null ){
            bookModels.remove(book);
            return  book;
        }
        return  null;
    }
}
