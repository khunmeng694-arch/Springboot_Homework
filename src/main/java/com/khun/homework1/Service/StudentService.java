package com.khun.homework1.Service;

import com.khun.homework1.Model.StudentModel;

import java.util.List;

public interface StudentService {
    List<StudentModel> findAllStudent();
    StudentModel findStudentById(int Id);
    StudentModel createStudent(StudentModel studentModel);
    StudentModel updateStudent(int Id,StudentModel studentModel);
    StudentModel deleteStudent(int Id);
}
