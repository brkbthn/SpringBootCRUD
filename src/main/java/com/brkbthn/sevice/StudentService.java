package com.brkbthn.sevice;

import com.brkbthn.model.Student;
import com.brkbthn.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Transactional
@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public List<Student> getAllStudent(){

        return studentRepository.findAll();
    }

    public Student getOneStudent(Long id){
        return studentRepository.findById(id).get();
    }

    public Student addStudent(Student student){
        //Student kaydedilecek
         return studentRepository.save(student);
    }

    public Student updateStudent(Student student){
        return studentRepository.save(student);
    }

    public void   deleteStudentById(Long id){
       studentRepository.deleteById(id);

    }
}
