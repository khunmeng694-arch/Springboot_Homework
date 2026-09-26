package com.khun.homework1.Service;

import com.khun.homework1.Model.TeacherModel;

import java.util.List;

public interface TeacherService {
    List<TeacherModel> getAllTeachers();
    TeacherModel getTeacherById(int Id);
    TeacherModel createTeacher(TeacherModel teacherModel);
    TeacherModel updtateTeacher(int Id , TeacherModel teacherModel);
    TeacherModel deleteTeacher(int id);
}