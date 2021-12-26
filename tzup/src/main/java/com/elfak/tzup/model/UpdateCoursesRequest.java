package com.elfak.tzup.model;

public class UpdateCoursesRequest {
    int courseId;
    String courseFullname;
    String courseShortname;

    public int getCourseId() {
        return courseId;
    }

    public String getCourseFullname() {
        return courseFullname;
    }

    public String getCourseShortname() {
        return courseShortname;
    }
}
