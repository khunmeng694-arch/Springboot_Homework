package com.khun.homework1.Repository;

import com.khun.homework1.Model.StudentModel;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository {

    List<StudentModel> studentModels = new ArrayList<>();
    public StudentRepository(){
        studentModels.add(new StudentModel(1,"Thea Kanika","20","FeMale"));
        studentModels.add(new StudentModel(2,"Phat Navy","22","FeMale"));
        studentModels.add(new StudentModel(3,"Chhun Menghorn","20","Male"));
    }
    public List<StudentModel> findAll(){
        return studentModels;
    }
    public StudentModel findId(int Id){
        return  studentModels.stream()
                .filter(studentModel -> studentModel.getId()==Id)
                .findFirst()
                .orElse(null);
    }
    public StudentModel save(StudentModel studentModel){
        return  studentModels.add(studentModel)?studentModel:null;
    }
    public StudentModel update(int Id,StudentModel studentModel){
        StudentModel student = findId(Id);

        if(student == null){
            throw new  RuntimeException("Student Not Found");
        }
        student.setId(studentModel.getId());
        student.setName(studentModel.getName());
        student.setAge(studentModel.getAge());
        student.setGender(studentModel.getGender());
        return student;
    }
    public StudentModel delete(int Id){
        StudentModel student = findId(Id);
        if(student != null){
            studentModels.remove(student);
            return student;
        }
        return null;
    }
}
