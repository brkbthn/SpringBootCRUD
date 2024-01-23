package com.brkbthn.controller;

import com.brkbthn.model.Student;
import com.brkbthn.sevice.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1") //api nin 1. versiyonu //  http://localhost:8090/api/v1
public class StudentController {

    @Autowired
    StudentService studentService;

    //@RequestMapping(path = "/hello" , method = RequestMethod.GET)   ___>eski usül
    @GetMapping("/hello")
    public String hello(){
        return "Selam";
    }


    // http://localhost:8090/api/v1/student/1
    @GetMapping("/student/{id}")//esnek değer verileceğinde süslü parantez koyulur
    public Student getStudent(@PathVariable(name = "id") Long id){
        //@Pathvariable (name="id") ile girilen değişken ile api deki değişken eşlenir
        //(name="id") kısmının yazılmasına gerek yoktur yazılmasa da çalışır
        return studentService.getOneStudent(id);
    }

    @GetMapping("/students")
    public List<Student> getStudents(){
        return studentService.getAllStudent();
    }

    //PUT -> INSERT ekleme, id değerinin verilmesine gerek yoktur veri tabanı otomatik olarak verecektir
    // http://localhost:8090/api/v1/student
    @PostMapping("/student")
    public Student addStudent(@RequestBody Student student){
        /*
        @RequestBody anotasyonu bilgi göderirken kullanılır
        student kaydedilecek
        */
        return studentService.addStudent(student);
    }
    //PUT -> UPDATE güncelleme, id değerine göre güncelleme yapar
    // http://localhost:8090/api/v1/student/1
    @PutMapping("/student/{id}")
    public Student updateStudent(@PathVariable long id, @RequestBody Student student){
        Student studentInfo = studentService.getOneStudent(id);
        if (studentInfo!=null) {
            studentInfo.setId(id);
            studentInfo.setFirstName(student.getFirstName());
            studentInfo.setLastName(student.getLastName());
            studentInfo.setEmail(student.getEmail());
            studentService.updateStudent(studentInfo);
        }

        return studentInfo;
    }

    //DELETE
    //http://localhost:8090/api/v1/student/1
    @DeleteMapping("/student/{id}")
    public String deleteStudent(@PathVariable Long id){
        studentService.deleteStudentById(id);
        return "silme işlemi gerçekleştirildi";
    }




}
