package com.example.demo.service.serviceImp;

import com.example.demo.entity.Course;
import com.example.demo.mapper.SchoolMapper;
import com.example.demo.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class SchoolServiceImp implements SchoolService {
 @Resource
    SchoolMapper schoolMapper;
    @Override
    public List<Course> findAll() {
        return schoolMapper.findAll();
    }

    @Override
    public List<Map> findAll2() {
        return schoolMapper.findAll2();
    }
}
