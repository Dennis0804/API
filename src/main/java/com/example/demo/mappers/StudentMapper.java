package com.example.demo.mappers;

import com.example.demo.dtos.student.StudentGetDto;
import com.example.demo.dtos.student.StudentPostDto;
import com.example.demo.dtos.student.StudentPutDto;
import com.example.demo.entities.Student;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface StudentMapper {
    Student toEntity(StudentPostDto studentPostDto);
    StudentGetDto fromEntity(Student student);
    void copy(StudentPutDto studentPutDto, @MappingTarget Student student);
}
