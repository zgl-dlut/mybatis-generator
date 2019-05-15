package com.zgl.mybatis.generator.entity;

import java.io.Serializable;
import javax.persistence.*;

public class Teacher implements Serializable {
    /**
     * 教师id
     */
    @Id
    @Column(name = "teacher_id")
    private String teacherId;

    /**
     * 教师名称
     */
    @Column(name = "teacher_name")
    private String teacherName;

    private static final long serialVersionUID = 1L;

    /**
     * 获取教师id
     *
     * @return teacher_id - 教师id
     */
    public String getTeacherId() {
        return teacherId;
    }

    /**
     * 设置教师id
     *
     * @param teacherId 教师id
     */
    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    /**
     * 获取教师名称
     *
     * @return teacher_name - 教师名称
     */
    public String getTeacherName() {
        return teacherName;
    }

    /**
     * 设置教师名称
     *
     * @param teacherName 教师名称
     */
    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", teacherId=").append(teacherId);
        sb.append(", teacherName=").append(teacherName);
        sb.append("]");
        return sb.toString();
    }
}