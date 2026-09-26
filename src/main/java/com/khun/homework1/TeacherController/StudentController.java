package com.khun.homework1.TeacherController;

import com.khun.homework1.Model.StudentModel;
import com.khun.homework1.Service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {
    private final StudentService studentService;
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }
    @GetMapping
    public List<StudentModel> findAll(){
        return  studentService.findAllStudent();
    }
    @GetMapping("/{Id}")
    public ResponseEntity<?> findId(@PathVariable int Id){
        StudentModel student = studentService.findStudentById(Id);
        if(student == null){
            return  ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("Message","Not Found"));
        }
        return  ResponseEntity.ok(student);
    }
    @PostMapping
    public StudentModel save(@RequestBody StudentModel studentModel){
        return studentService.createStudent(studentModel);
    }
    @PutMapping("/{Id}")
    public StudentModel update(@PathVariable int Id,@RequestBody StudentModel studentModel){
        return studentService.updateStudent(Id,studentModel);
    }
    @DeleteMapping("/{Id}")
    public StudentModel delete(@PathVariable int Id){
        return  studentService.deleteStudent(Id);
    }
}
