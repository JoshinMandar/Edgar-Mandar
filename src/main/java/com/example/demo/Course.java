package com.example.demo;

import java.util.ArrayList;

public class Course {
    private int id;
    private String className;
    private String classCode;
    private String instructor;
    private ArrayList<Assignment> assignments = new ArrayList<>();

    public Course(int id, String className, String classCode, String instructor) {
        this.id = id;
        this.className = className;
        this.classCode = classCode;
        this.instructor = instructor;
    }
    public int getId() { return id; }
    public String getClassName() { return className; }
    public void setClassName(String className) { this.className = className; }
    public String getClassCode() { return classCode; }
    public void setClassCode(String classCode) { this.classCode = classCode; }
    public String getInstructor() { return instructor; }
    public void setInstructor(String instructor) { this.instructor = instructor; }
    public ArrayList<Assignment> getAssignments() { return assignments; }

    public void addAssignment(Assignment assignment) {
        assignments.add(assignment);
    }
}
