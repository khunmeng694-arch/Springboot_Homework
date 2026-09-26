package com.khun.homework1.Model;

public class BookModel {
    private int Id;
    private String Title;
    private String Author;

    public BookModel(int Id,String Title,String Author){
        this.Id=Id;
        this.Title=Title;
        this.Author=Author;

    }
    public int getId( ){
        return Id;
    }
    public void setId(int Id){
        this.Id=Id;
    }
    public String getTitle(){
        return Title;
    }
    public void setTitle(String Title){
        this.Title=Title;
    }
    public String getAuthor(){
        return Author;
    }
    public void setAuthor(String Author){
        this.Author=Author;
    }
}
