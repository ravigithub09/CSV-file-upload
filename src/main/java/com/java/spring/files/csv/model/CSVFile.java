package com.java.spring.files.csv.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;
import lombok.Getter;

@Entity
@Table(name = "tutorials")
@Getter
public class CSVFile {

  @Id
  @GeneratedValue(strategy=GenerationType.SEQUENCE)
  @Column(name = "id")
  private long id;

  @Column(name = "code")
  private String code;

  @Column(name = "name")
  private String name;

  @Column(name = "batch")
  private String batch;
  
  @Column(name = "stock")
  private String stock;

  @Column(name = "deal")
  private String deal;

  @Column(name = "free")
  private boolean free;
  
   @Column(name = "mrp")
  private Double mrp;

  @Column(name = "rate")
  private Double rate;
  
  @Column(name = "exp")
  private Date exp;

  @Column(name = "company")
  private String company;

  @Column(name = "supplier")
  private boolean supplier;

  public Tutorial() {

  }

  public Tutorial(String code, String name, String batch, String stock, String deal, String free, Double mrp, Double rate, Date exp, String company
  , String supplier) {
    
    this.code = code;
    this.name = name;
    this.batch = batch;
	this.stock = stock;
    this.deal = deal;
    this.free = free;
	this.mrp = mrp;
    this.rate = rate;
    this.exp = exp;
	this.company = company;
    this.supplier = supplier;
  }
}
