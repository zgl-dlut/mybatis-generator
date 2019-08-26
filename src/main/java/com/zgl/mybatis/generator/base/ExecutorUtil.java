package com.zgl.mybatis.generator.base;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * @author zgl
 * @date 2019/8/25 下午3:16
 */
public class ExecutorUtil {

	private static final ThreadFactory THREAD_FACTORY = new ThreadFactoryBuilder().setNameFormat("zgl-pool-%d").build();

	public static final ThreadPoolExecutor EXECUTOR = new ThreadPoolExecutor(16, 16, 60L, TimeUnit.SECONDS,
			new LinkedBlockingDeque<>(100), THREAD_FACTORY, new ThreadPoolExecutor.CallerRunsPolicy());
}