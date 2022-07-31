package com.java.spring.files.csv.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.spring.files.csv.model.csvFile;

public interface CSVRepository extends JpaRepository<csvFile, Long> {
}
