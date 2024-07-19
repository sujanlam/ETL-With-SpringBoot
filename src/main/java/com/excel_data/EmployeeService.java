package com.excel_data;

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
public class EmployeeService {

    @Autowired
    private EmpRepository empRepository;

    public void saveEmployeesFromExcel(MultipartFile file) throws IOException {
        List<Employee> employees = new ArrayList<>();

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
            Employee employee = new Employee();
            employee.setName(currentRow.getCell(0).getStringCellValue());
            employee.setAddress(currentRow.getCell(1).getStringCellValue());
            employee.setSalary(currentRow.getCell(2).getNumericCellValue());
            employee.setDepartment(currentRow.getCell(3).getStringCellValue());

            Cell ageCell = currentRow.getCell(4);
            if (ageCell != null && ageCell.getCellType() == CellType.NUMERIC) {
                employee.setAge((int) ageCell.getNumericCellValue());
            } else {
                continue; // Skip records with no age
            }

            employees.add(employee);
        }

        workbook.close();
        empRepository.saveAll(employees);
    }
}