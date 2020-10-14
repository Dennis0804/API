package com.example.demo.controllers;

import com.example.demo.dtos.student.StudentGetDto;
import com.example.demo.dtos.student.StudentPostDto;
import com.example.demo.dtos.student.StudentPutDto;
import com.example.demo.entities.Student;
import com.example.demo.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentControllers {

    private final StudentService studentService;

    @PostMapping
    public ResponseEntity<StudentGetDto> add(@RequestBody StudentPostDto studentPostDto) {
        StudentGetDto studentGetDto = studentService.create(studentPostDto);
        return ResponseEntity.ok(studentGetDto);
    }

    @PutMapping("/{studentId}")
    public ResponseEntity<StudentGetDto> update(@PathVariable UUID studentId, @RequestBody StudentPutDto studentPutDto) {
        return ResponseEntity.ok(studentService.modify(studentId, studentPutDto));
    }

    @GetMapping
    public ResponseEntity<List<Student>> find() {
        List<Student> list = studentService.getAllStudents();
        return ResponseEntity.ok(list);
    }

    @GetMapping("search")
    public ResponseEntity<StudentGetDto> findByName(@RequestParam String StudentName) {
        return ResponseEntity.ok(studentService.findStudentByName(StudentName));
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<StudentGetDto> findById(@PathVariable UUID studentId, @RequestBody StudentPutDto studentPutDto) {
        return ResponseEntity.ok(studentService.modify(studentId, studentPutDto));
    }

    @DeleteMapping("/{studentId}")
    public ResponseEntity<StudentGetDto> delete(@PathVariable UUID studentId) {
        studentService.delete(studentId);
        return ResponseEntity.ok().build();
    }
}