package com.khun.homework1.Model;

public class StudentModel {
    private int Id;
    private String name;
    private String age;
    private String gender;

    public StudentModel(int Id, String name, String age,String gender){
        this.Id=Id;
        this.name=name;
        this.age= age;
        this.gender = gender;
    }
    public int getId(){
        return  Id;
    }
    public void setId(int Id){
        this.Id = Id;
    }
    public String getName(){
        return  name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getAge(){
        return age;
    }
    public void setAge(String age){
        this.age=age;
    }
    public String getGender(){
        return  gender;
    }
    public void setGender(String gender){
        this.gender = gender;
    }
}
