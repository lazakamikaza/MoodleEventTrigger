package com.elfak.tzup.controler;

import com.elfak.tzup.model.UpdateCourseEnrollmentsRequest;
import com.elfak.tzup.model.UpdateCourseEnrollmentsResponse;
import com.elfak.tzup.model.UpdateCoursesRequest;
import com.elfak.tzup.service.ExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExcelController {

    @Autowired
    ExcelService excelService;

    @RequestMapping(value = "/updateCourseEnrollments", method = RequestMethod.POST)
    public UpdateCourseEnrollmentsResponse updateCourseEnrollments(@RequestBody UpdateCourseEnrollmentsRequest updateCourseEnrollmentsRequest) {
        UpdateCourseEnrollmentsResponse response = new UpdateCourseEnrollmentsResponse();
        excelService.updateCourseEnrollmentsExcel(updateCourseEnrollmentsRequest);
        return response;
    }

    @RequestMapping(value = "/updateCourses", method = RequestMethod.POST)
    public UpdateCourseEnrollmentsResponse updateCourseEnrollments(@RequestBody UpdateCoursesRequest updateCoursesRequest) {
        UpdateCourseEnrollmentsResponse response = new UpdateCourseEnrollmentsResponse();
        excelService.updateCoursesExcel(updateCoursesRequest);
        return response;
    }
}