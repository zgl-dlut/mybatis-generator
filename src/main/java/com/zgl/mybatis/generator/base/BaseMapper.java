package com.zgl.mybatis.generator.base;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author zgl
 * @date 2019/4/3 下午2:34
 */
public interface BaseMapper<T> extends Mapper<T>, MySqlMapper<T> {
}