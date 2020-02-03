package com.example.demo.mapper;

import com.example.demo.entity.Course;

import java.util.List;
import java.util.Map;

public interface SchoolMapper {
    List<Course> findAll();
    List<Map> findAll2();
}
