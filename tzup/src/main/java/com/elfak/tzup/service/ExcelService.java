package com.elfak.tzup.service;

import com.elfak.tzup.model.UpdateCourseEnrollmentsRequest;
import com.elfak.tzup.model.UpdateCoursesRequest;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

@Service
public class ExcelService {

    private static final String pathToCourseEnrollments = "C:\\\\\\\\demo\\\\\\\\CoursesEnrollments.xlsx";

    public void updateCourseEnrollmentsExcel(UpdateCourseEnrollmentsRequest updateCourseEnrollmentsRequest)  {
        try {
            FileInputStream inputStream = new FileInputStream(pathToCourseEnrollments);
            Workbook workbook = WorkbookFactory.create(inputStream);

            Sheet sheet = workbook.getSheet(updateCourseEnrollmentsRequest.getCourseShortname());

            int rowCount = sheet.getLastRowNum();
            Row row = sheet.createRow(++rowCount);
            row.createCell(0).setCellValue(updateCourseEnrollmentsRequest.getStudentIndex());
            row.createCell(1).setCellValue(updateCourseEnrollmentsRequest.getStudentLastname());
            row.createCell(2).setCellValue(updateCourseEnrollmentsRequest.getStudentFirstname());
            row.createCell(3).setCellValue(updateCourseEnrollmentsRequest.getStudentEmail());

            inputStream.close();

            FileOutputStream outputStream = new FileOutputStream(pathToCourseEnrollments);
            workbook.write(outputStream);
            workbook.close();
            outputStream.close();

        } catch (IOException | EncryptedDocumentException
                | InvalidFormatException ex) {
            ex.printStackTrace();
        }
    }

    public void updateCoursesExcel(UpdateCoursesRequest updateCoursesRequest) {
        try {
            FileInputStream inputStream = new FileInputStream(pathToCourseEnrollments);
            Workbook workbook = WorkbookFactory.create(inputStream);

            Sheet sheet = workbook.getSheet("Kursevi");
            workbook.createSheet(updateCoursesRequest.getCourseShortname());

            int rowCount = sheet.getLastRowNum();
            Row row = sheet.createRow(++rowCount);
            row.createCell(0).setCellValue(updateCoursesRequest.getCourseId());
            row.createCell(1).setCellValue(updateCoursesRequest.getCourseFullname());
            row.createCell(2).setCellValue(updateCoursesRequest.getCourseShortname());

            inputStream.close();

            FileOutputStream outputStream = new FileOutputStream(pathToCourseEnrollments);
            workbook.write(outputStream);
            workbook.close();
            outputStream.close();

        } catch (IOException | EncryptedDocumentException
                | InvalidFormatException ex) {
            ex.printStackTrace();
        }
    }
}
