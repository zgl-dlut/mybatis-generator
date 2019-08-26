package com.zgl.mybatis.generator.service;

import com.zgl.mybatis.generator.entity.Student;
import com.zgl.mybatis.generator.mapper.StudentMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.Future;

/**
 * @author zgl
 * @date 2019/8/25 下午4:30
 */
@Component
@Slf4j
public class SyncStudentHandler {

	@Autowired
	private StudentMapper studentMapper;

	@Async(value = "myThreadPoolExecutor")
	public Future<String> syncMargePsr(List<Student> studentList, int pageIndex) {
		log.info(String.format("此批数据的段数为:%s 此段数据的数据条数为:%s", pageIndex, studentList.size()));
		Future<String> result = new AsyncResult<>(Thread.currentThread().getName());
		for (Student student : studentList) {
			studentMapper.insert(student);
		}
		log.info("更新结束,线程:{}", Thread.currentThread().getName());
		return result;
	}

	public void syncMargePsr1(List<Student> studentList, int pageIndex) {
		log.info(String.format("此批数据的段数为:%s 此段数据的数据条数为:%s", pageIndex, studentList.size()));
		for (Student student : studentList) {
			studentMapper.insert(student);
		}
		log.info("更新结束,线程:{}", Thread.currentThread().getName());
	}
}