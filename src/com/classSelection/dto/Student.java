package com.ClassSelection.dto;

public class Student {
    // Fields
    private String StudentID;
    private String UserName;
    private String StudentName;

    // Constructors

    /** default constructor */
    public Student(){

    }

    /** full constructor */
    public Student(String StudentID, String Username, String StudentName){
        this.StudentID = StudentID;
        this.UserName = Username;
        this.StudentName = StudentName;
    }

    // Property accessors
    public String getStudentID(){
        return this.StudentID;
    }

    public String getUserName(){
        return this.UserName;
    }

    public String getStudentName(){
        return this.StudentName;
    }

    public void setStudentID(String StudentID){
        this.StudentID = StudentID;
    }

    public void setUserName(String UserName){
        this.UserName = UserName;
    }

    public void setStudentName(String StudentName){
        this.StudentName = StudentName;
    }
}
