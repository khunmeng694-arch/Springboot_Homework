package com.khun.homework1.Controller;
import com.khun.homework1.Model.TeacherModel;
import com.khun.homework1.Service.TeacherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/teacher")
public class TeacherController {
    private final TeacherService teacherService;
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }
    @GetMapping
    public List<TeacherModel> findAll(){
        return teacherService.getAllTeachers();
    }
    @GetMapping("/{Id}")
    public ResponseEntity<?> findById(@PathVariable int Id) {
        TeacherModel teacher = teacherService.getTeacherById(Id);
        if (teacher == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("message", "Not Found"));
        }
        return ResponseEntity.ok(teacher);
    }
    @PostMapping
    public TeacherModel createTeacher(@RequestBody TeacherModel teacherModel){
        return teacherService.createTeacher(teacherModel);
    }
    @PutMapping("/{Id}")
    public TeacherModel update(@PathVariable int Id,@RequestBody TeacherModel teacherModel){
        return teacherService.updtateTeacher(Id,teacherModel);
    }
    @DeleteMapping("/{Id}")
    public TeacherModel delete(@PathVariable int Id){
        return teacherService.deleteTeacher(Id);
    }
}