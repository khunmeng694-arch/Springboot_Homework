package com.khun.homework1.Service;

import com.khun.homework1.Model.TeacherModel;
import com.khun.homework1.Repository.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TeacherServiceImp implements TeacherService{
    private final TeacherRepository teacherRepository;
    public TeacherServiceImp(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }
    @Override
    public List<TeacherModel> getAllTeachers() {
        return teacherRepository.findAll();
    }
    @Override
    public TeacherModel getTeacherById(int Id) {
        return TeacherRepository.findById(Id);
    }

    @Override
    public TeacherModel createTeacher(TeacherModel teacherModel) {
        return teacherRepository.save(teacherModel);
    }

    @Override
    public TeacherModel updtateTeacher(int Id, TeacherModel teacherModel) {
        return teacherRepository.update(Id,teacherModel);
    }

    @Override
    public TeacherModel deleteTeacher(int Id) {
        return teacherRepository.delete(Id);
    }
}

