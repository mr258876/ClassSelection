package com.ClassSelection.dao;

import com.ClassSelection.dto.Department;

public interface IntfDepartmentDao {
    public Department getDepartmentByUserName(String UserName);   // 根据用户名查找学生
    public Department getDepartmentBySID(String SID);             // 根据学号查找学生
    public int updateDepartment(Department department);              // 更新学生对象
}
