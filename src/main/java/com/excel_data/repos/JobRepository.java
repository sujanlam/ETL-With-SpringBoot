package com.excel_data.repos;

import com.excel_data.entity.Jobs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Jobs, Long> {
}
