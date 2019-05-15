package com.zgl.mybatis.generator.entity;

import java.io.Serializable;
import javax.persistence.*;

public class Score implements Serializable {
    /**
     * 学生id
     */
    @Id
    @Column(name = "student_id")
    private String studentId;

    /**
     * 课程id
     */
    @Id
    @Column(name = "course_id")
    private String courseId;

    /**
     * 成绩
     */
    private Integer score;

    private static final long serialVersionUID = 1L;

    /**
     * 获取学生id
     *
     * @return student_id - 学生id
     */
    public String getStudentId() {
        return studentId;
    }

    /**
     * 设置学生id
     *
     * @param studentId 学生id
     */
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    /**
     * 获取课程id
     *
     * @return course_id - 课程id
     */
    public String getCourseId() {
        return courseId;
    }

    /**
     * 设置课程id
     *
     * @param courseId 课程id
     */
    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    /**
     * 获取成绩
     *
     * @return score - 成绩
     */
    public Integer getScore() {
        return score;
    }

    /**
     * 设置成绩
     *
     * @param score 成绩
     */
    public void setScore(Integer score) {
        this.score = score;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", studentId=").append(studentId);
        sb.append(", courseId=").append(courseId);
        sb.append(", score=").append(score);
        sb.append("]");
        return sb.toString();
    }
}