package com.excel_data;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "emp_data")
@Data
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    private Double salary;
    private String department;
    private Integer age;
}
