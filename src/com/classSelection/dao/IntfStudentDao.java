package com.ClassSelection.dao;

import com.ClassSelection.dto.Student;

public interface IntfStudentDao {
    public Student getStudentByUserName(String UserName);   // 根据用户名查找学生
    public Student getStudentBySID(String SID);             // 根据学号查找学生
    public int updateStudent(Student student);              // 更新学生对象
}
