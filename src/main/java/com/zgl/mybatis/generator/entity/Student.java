package com.zgl.mybatis.generator.entity;

import java.io.Serializable;
import javax.persistence.*;

public class Student implements Serializable {
    /**
     * 学生id
     */
    @Id
    @Column(name = "student_id")
    private String studentId;

    /**
     * 学生名字
     */
    @Column(name = "student_name")
    private String studentName;

    /**
     * 出生日期
     */
    private String birth;

    /**
     * 性别
     */
    private String sex;

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
     * 获取学生名字
     *
     * @return student_name - 学生名字
     */
    public String getStudentName() {
        return studentName;
    }

    /**
     * 设置学生名字
     *
     * @param studentName 学生名字
     */
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    /**
     * 获取出生日期
     *
     * @return birth - 出生日期
     */
    public String getBirth() {
        return birth;
    }

    /**
     * 设置出生日期
     *
     * @param birth 出生日期
     */
    public void setBirth(String birth) {
        this.birth = birth;
    }

    /**
     * 获取性别
     *
     * @return sex - 性别
     */
    public String getSex() {
        return sex;
    }

    /**
     * 设置性别
     *
     * @param sex 性别
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", studentId=").append(studentId);
        sb.append(", studentName=").append(studentName);
        sb.append(", birth=").append(birth);
        sb.append(", sex=").append(sex);
        sb.append("]");
        return sb.toString();
    }
}