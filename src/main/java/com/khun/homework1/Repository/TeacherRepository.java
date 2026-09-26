package com.khun.homework1.Repository;
import com.khun.homework1.Model.TeacherModel;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

import static com.khun.homework1.Model.TeacherModel.remove;

@Repository
public class TeacherRepository {
    static List<TeacherModel> teacherModels = new ArrayList<>();
    public TeacherRepository(){
        teacherModels.add(new TeacherModel(1,"Java","Lysokun",45,"Male"));
        teacherModels.add(new TeacherModel(2,"Webdevelopment","Sovisal",35,"Male"));
        teacherModels.add(new TeacherModel(3,"SpringBoot","Tang Mengkhun",45,"Male"));
    }
    public List<TeacherModel> findAll() {
        return teacherModels;
    }

    public static TeacherModel findById(int Id){
        return teacherModels.stream()
                .filter(teacherModel -> teacherModel.getId()== Id)
                .findFirst()
                .orElse(null);
    }
    public static TeacherModel save(TeacherModel teacherModel){
        return teacherModels.add(teacherModel)?teacherModel:null;
    }
    public TeacherModel update(int id , TeacherModel teacherModel){
        TeacherModel teacher = findById(id);

        if (teacher == null){
            throw new RuntimeException("Student not found");
        }
        teacher.setId(teacherModel.getId());
        teacher.setName(teacherModel.getName());
        teacher.setAge(teacherModel.getAge());
        teacher.setGender(teacherModel.getGender());
        teacherModels.add(teacher);
        return teacher;
    }
    public TeacherModel delete(int Id) {
        TeacherModel teacherModel = findById(Id);
        if (teacherModel != null) {
            teacherModels.remove(teacherModel);
            return teacherModel;
        }
        return null;
    }
}


