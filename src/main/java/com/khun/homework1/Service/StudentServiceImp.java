package com.khun.homework1.Service;

import com.khun.homework1.Model.StudentModel;
import com.khun.homework1.Repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentServiceImp implements StudentService{
    private  final StudentRepository studentRepository;

    public StudentServiceImp(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<StudentModel> findAllStudent() {
        return studentRepository.findAll();
    }

    @Override
    public StudentModel findStudentById(int Id) {
        return studentRepository.findId(Id);
    }

    @Override
    public StudentModel createStudent(StudentModel studentModel) {
        return studentRepository.save(studentModel);
    }

    @Override
    public StudentModel updateStudent(int Id, StudentModel studentModel) {
        return studentRepository.update(Id,studentModel);
    }

    @Override
    public StudentModel deleteStudent(int Id) {
        return studentRepository.delete(Id);
    }
}
