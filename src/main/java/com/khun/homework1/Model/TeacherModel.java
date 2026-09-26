package com.khun.homework1.Model;
public class TeacherModel {
    private int Id;
    private String Curse;
    private String Name;
    private int Age;
    private String Gender;

    public TeacherModel(int Id,String Curse,String Name,int Age ,String Gender){
        this.Id=Id;
        this.Curse=Curse;
        this.Name=Name;
        this.Age=Age;
        this.Gender=Gender;

    }

    public static void remove(TeacherModel tteacherModel) {
    }

    public int getId(){
        return Id;
    }
    public void setId(int Id){
        this.Id=Id;
    }
    public String getCurse( ){
        return Curse;
    }
    public void setCurse(String Curse){
        this.Curse=Curse;
    }
    public String getName(){
        return Name;
    }
    public void setName(String Name){
        this.Name=Name;
    }
    public int getAge(){
        return Age;
    }
    public void setAge(int Age){
        this.Age=Age;
    }
    public String getGender(){
        return Gender;
    }
    public void setGender(String Gender){
        this.Gender=Gender;
    }
}
