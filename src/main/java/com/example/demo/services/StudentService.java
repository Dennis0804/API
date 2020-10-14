package com.example.demo.services;

import com.example.demo.dtos.student.StudentGetDto;
import com.example.demo.dtos.student.StudentPostDto;
import com.example.demo.dtos.student.StudentPutDto;
import com.example.demo.entities.Student;
import com.example.demo.mappers.StudentMapper;
import com.example.demo.repositories.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    public StudentGetDto create(StudentPostDto studentPostDto) {
        Student studentEntity = studentMapper.toEntity(studentPostDto);
        return studentMapper.fromEntity(studentRepository.save(studentEntity));
    }

    public StudentGetDto modify(UUID studentId, StudentPutDto studentPutDto) {
        Student student = new Student();
        studentMapper.copy(studentPutDto, student);
        student.setId(studentId);
        return studentMapper.fromEntity(studentRepository.save(student));
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public void findStudentById(UUID id) {
        StudentGetDto studentGetDto = studentMapper.fromEntity(studentRepository.getOne(id));
    }

    public StudentGetDto findStudentByName(String name) {
        return studentMapper.fromEntity(studentRepository.findByFirstName(name));
    }

    public void delete(UUID id) {
        studentRepository.deleteById(id);
    }
}
