package com.elfak.tzup.model;


public class UpdateCourseEnrollmentsRequest {
    String courseShortname;
    int studentIndex;
    String studentFirstname;
    String studentLastname;
    String studentEmail;

    public String getCourseShortname() {
        return courseShortname;
    }

    public int getStudentIndex() {
        return studentIndex;
    }

    public String getStudentFirstname() {
        return studentFirstname;
    }

    public String getStudentLastname() {
        return studentLastname;
    }

    public String getStudentEmail() {
        return studentEmail;
    }
}

