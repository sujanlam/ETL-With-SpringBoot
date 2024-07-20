package com.excel_data.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Jobs")
@Data
public class Jobs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String company_for;
    private String agency_through;
    private String point_of_contact;
    private String email_poc;
    private String job_number;
    private String date_applied;
    @Enumerated(EnumType.STRING)
    private String status;
    @Enumerated(EnumType.STRING)
    private String jobType;
    @Enumerated(EnumType.STRING)
    private String chances;

}
