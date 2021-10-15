package com.ClassSelection.dto;

public class Department {
        // Fields
        private String DepartmentID;
        private String UserName;
        private String DepartmentName;
    
        // Constructors
    
        /** default constructor */
        public Department(){
    
        }
    
        /** full constructor */
        public Department(String DepartmentID, String Username, String DepartmentName){
            this.DepartmentID = DepartmentID;
            this.UserName = Username;
            this.DepartmentName = DepartmentName;
        }
    
        // Property accessors
        public String getDepartmentID(){
            return this.DepartmentID;
        }
    
        public String getUserName(){
            return this.UserName;
        }
    
        public String getDepartmentName(){
            return this.DepartmentName;
        }
    
        public void setDepartmentID(String DepartmentID){
            this.DepartmentID = DepartmentID;
        }
    
        public void setUserName(String UserName){
            this.UserName = UserName;
        }
    
        public void setDepartmentName(String DepartmentName){
            this.DepartmentName = DepartmentName;
        }
}
