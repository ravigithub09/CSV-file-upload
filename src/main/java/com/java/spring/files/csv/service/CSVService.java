package com.java.spring.files.csv.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.java.spring.files.csv.helper.CSVHelper;
import com.java.spring.files.csv.model.CSVFile;
import com.java.spring.files.csv.repository.CSVRepository;

@Service
public class CSVService {
  @Autowired
  CSVRepository repository;

  public void save(MultipartFile file) {
    try {
      List<CSVFile> csv = CSVHelper.csvConverter(file.getInputStream());
      repository.saveAll(csv);
    } catch (IOException e) {
      throw new RuntimeException("fail to store csv data: " + e.getMessage());
    }
  }

  
}
