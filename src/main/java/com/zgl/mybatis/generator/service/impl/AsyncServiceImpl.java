package com.zgl.mybatis.generator.service.impl;

import com.zgl.mybatis.generator.base.ExecutorUtil;
import com.zgl.mybatis.generator.entity.Student;
import com.zgl.mybatis.generator.mapper.StudentMapper;
import com.zgl.mybatis.generator.service.AsyncService;
import com.zgl.mybatis.generator.service.SyncStudentHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author zgl
 * @date 2019/8/25 下午3:29
 */

@Service
@Slf4j
public class AsyncServiceImpl implements AsyncService {

	@Autowired
	private SyncStudentHandler syncStudentHandler;

	private List<Student> getStudentList() {
		List<Student> result = new ArrayList<>();
		for (int i =110000; i < 117000; i++) {
			result.add(new Student(String.valueOf(i), "zgl", "1992-12-19", "male"));
		}
		return result;
	}

	@Override
	public void batchInsert() {

		List<Student> studentList = getStudentList();
		int size = studentList.size();
		//将集合切分的段数(2*CPU的核心数)
		int sunSum = 2 * Runtime.getRuntime().availableProcessors();
		int listStart, listEnd;
		//当总条数不足sunSum条时 用总条数 当做线程切分值
		if (sunSum > size) {
			sunSum = size;
		}

		//入库开始时间
		Long insertOrUpdateBegin = System.currentTimeMillis();
		log.info("数据更新开始时间:" + insertOrUpdateBegin);
		//接收集合各段的 执行的返回结果
		List<Future<String>> futureList = new ArrayList<>();
		for (int i = 0; i < sunSum; i++) {
			//计算切割  开始和结束
			listStart = size / sunSum * i ;
			listEnd = size / sunSum * ( i + 1 );
			//最后一段线程会 出现与其他线程不等的情况
			if(i == sunSum - 1){
				listEnd = size;
			}
			//数据切断
			List<Student> studentSubList = studentList.subList(listStart, listEnd);
			int finalI = i;
			//for循环里进行异步,其实是同步
			/*CompletableFuture<Future<String>> future = CompletableFuture.supplyAsync(() -> syncStudentHandler.syncMargePsr(studentSubList, finalI), ExecutorUtil.EXECUTOR);
			futureList.add(future.join());*/
			//线程池异步1
			//ExecutorUtil.EXECUTOR.execute(() -> syncStudentHandler.syncMargePsr(studentSubList, finalI));
			//@Async异步
			futureList.add(syncStudentHandler.syncMargePsr(studentSubList, i));
			//线程池异步2
			/*Future<String> future = ExecutorUtil.EXECUTOR.submit(() -> {
				syncStudentHandler.syncMargePsr1(studentSubList, finalI);
				return Thread.currentThread().getName();
			});
			futureList.add(future);*/
		}
		for (Future<String> future : futureList) {
			try {
				String str = future.get();
				log.info("current thread id =" + Thread.currentThread().getName() + ",result=" + str);
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}
		Long insertOrUpdateEnd = System.currentTimeMillis();
		log.info("数据更新结束时间:" + insertOrUpdateEnd + "。此次更新数据花费时间为：" + (insertOrUpdateEnd - insertOrUpdateBegin));

	}

}