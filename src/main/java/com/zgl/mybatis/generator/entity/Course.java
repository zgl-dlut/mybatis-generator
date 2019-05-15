package com.zgl.mybatis.generator.entity;

import java.io.Serializable;
import javax.persistence.*;

public class Course implements Serializable {
    /**
     * 课程编号
     */
    @Id
    @Column(name = "course_id")
    private String courseId;

    /**
     * 课程名称
     */
    @Column(name = "course_name")
    private String courseName;

    /**
     * 教师编号
     */
    @Column(name = "teacher_id")
    private String teacherId;

    private static final long serialVersionUID = 1L;

    /**
     * 获取课程编号
     *
     * @return course_id - 课程编号
     */
    public String getCourseId() {
        return courseId;
    }

    /**
     * 设置课程编号
     *
     * @param courseId 课程编号
     */
    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    /**
     * 获取课程名称
     *
     * @return course_name - 课程名称
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * 设置课程名称
     *
     * @param courseName 课程名称
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    /**
     * 获取教师编号
     *
     * @return teacher_id - 教师编号
     */
    public String getTeacherId() {
        return teacherId;
    }

    /**
     * 设置教师编号
     *
     * @param teacherId 教师编号
     */
    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", courseId=").append(courseId);
        sb.append(", courseName=").append(courseName);
        sb.append(", teacherId=").append(teacherId);
        sb.append("]");
        return sb.toString();
    }
}