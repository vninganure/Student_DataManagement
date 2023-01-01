
package com.studentData;

public class Student {
    private int sId;
    private String sname;
    private String address;
    private String mobile;
    private String email;
    private String gender;
    private String course;

    public int getsId() {
        return sId;
    }

    public String getSname() {
        return sname;
    }

    public String getAddress() {
        return address;
    }

    public String getMobile() {
        return mobile;
    }

    public String getEmail() {
        return email;
    }

    public String getGender() {
        return gender;
    }

    public String getCourse() {
        return course;
    }

    public void setsId(int sId) {
        this.sId = sId;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setCourse(String course) {
        this.course = course;
    }
    
    

    public Student(int sId, String sname, String address, String mobile, String email, String gender, String course) {
        super();
        this.sId = sId;
        this.sname = sname;
        this.address = address;
        this.mobile = mobile;
        this.email = email;
        this.gender = gender;
        this.course = course;
    }

    public Student(String sname, String address, String mobile, String email, String gender, String course) {
        super();
        this.sname = sname;
        this.address = address;
        this.mobile = mobile;
        this.email = email;
        this.gender = gender;
        this.course = course;
    }

    public Student() {
        super();
    }

    @Override
    public String toString() {
        return "Student{" + "sId=" + sId + ", sname=" + sname + ", address=" + address + ", mobile=" + mobile + ", email=" + email + ", gender=" + gender + ", course=" + course + '}';
    }
    
    
    
}
