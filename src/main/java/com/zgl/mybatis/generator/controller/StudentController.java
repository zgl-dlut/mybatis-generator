package com.zgl.mybatis.generator.controller;

import com.zgl.mybatis.generator.entity.Student;
import com.zgl.mybatis.generator.mapper.StudentMapper;
import com.zgl.mybatis.generator.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zgl
 * @date 2019/5/15 下午1:48
 */
@RestController
@RequestMapping("/mysql")
public class StudentController {

	@Resource
	private StudentMapper studentMapper;

	@Autowired
	private AsyncService asyncService;

	@GetMapping("/queryRegisterSameCourse")
	public List<Student> queryRegisterSameCourse(String studentId){
		return studentMapper.queryRegisterSameCourse(studentId);
	}

	@GetMapping("async")
	public void async() {
		asyncService.batchInsert();
	}
}