package com.zgl.mybatis.generator.mapper;

import com.zgl.mybatis.generator.base.BaseMapper;
import com.zgl.mybatis.generator.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentMapper extends BaseMapper<Student> {

	List<Student> queryRegisterSameCourse(@Param("studentId") String studentId);
}