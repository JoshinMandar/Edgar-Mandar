package com.example.demo;


public class Assignment {
    private int assignmentId;
    private String assignmentName;
    private String type;        // quiz, lab, test
    private String dueDate;
    private boolean completed;

    public Assignment(int assignmentId, String assignmentName, String type,
                      String dueDate, boolean completed) {
        this.assignmentId = assignmentId;
        this.assignmentName = assignmentName;
        this.type = type;
        this.dueDate = dueDate;
        this.completed = completed;
    }

    public int getAssignmentId() { return assignmentId; }
    public String getAssignmentName() { return assignmentName; }
    public String getType() { return type; }
    public String getDueDate() { return dueDate; }
    public boolean isCompleted() { return completed; }
    public void setCompleted(boolean completed) { this.completed = completed; }

    public String getInformation() {
        String status = "Unfinished";
        if (completed) {
            status = "Completed";
        }
        return assignmentName + " - " + type + " | Due " + dueDate + " | " + status;
    }
}
