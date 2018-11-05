package com.hcyshmily.jdbc;

public class Employee {

    private int id;
    private String last_name;
    private String email;
    private Integer deptId;

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", last_name='" + last_name + '\'' +
                ", email='" + email + '\'' +
                ", deptId=" + deptId +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getdeptId() {
        return deptId;
    }

    public void setdeptId(Integer deptId) {
        this.deptId = deptId;
    }
}
