package com.example.demo.service;

import com.example.demo.entity.Course;

import java.util.List;
import java.util.Map;

public interface SchoolService {
    List<Course> findAll();
    List<Map> findAll2();
}
