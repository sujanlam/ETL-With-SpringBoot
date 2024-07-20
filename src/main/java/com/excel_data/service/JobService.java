package com.excel_data.service;

import com.excel_data.repos.JobRepository;
import com.excel_data.entity.Jobs;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class JobService {

    @Autowired
    private JobRepository empRepository;

    public void saveEmployeesFromExcel(MultipartFile file) throws IOException {
        List<Jobs> employees = new ArrayList<>();

        Workbook workbook = new XSSFWorkbook(file.getInputStream());
        Sheet sheet = workbook.getSheetAt(0);
        Iterator<Row> rows = sheet.iterator();

        while (rows.hasNext()) {
            Row currentRow = rows.next();
            // Skip header row
            if (currentRow.getRowNum() == 0) {
                continue;
            }
            //Skip ID if there is. Start from 1 instead of 0.
            Jobs employee = new Jobs();
            employee.setCompany_for(currentRow.getCell(0).getStringCellValue());
            employee.setAgency_through(currentRow.getCell(1).getStringCellValue());
            employee.setPoint_of_contact(currentRow.getCell(2).getStringCellValue());
            employee.setEmail_poc(currentRow.getCell(3).getStringCellValue());
            employee.setJob_number(currentRow.getCell(4).getStringCellValue());
            employee.setStatus((currentRow.getCell(5).getStringCellValue()));
            employee.setDate_applied(currentRow.getCell(6).getStringCellValue());
            employee.setJobType(currentRow.getCell(7).getStringCellValue());
            //employee.setRate(currentRow.getCell(8).getStringCellValue());
            employee.setChances(currentRow.getCell(9).getStringCellValue());

            employees.add(employee);
        }

        workbook.close();
        empRepository.saveAll(employees);
    }
}