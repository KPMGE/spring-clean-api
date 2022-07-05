package com.sti.apisti.course;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class Course {
  @Id
  @SequenceGenerator(name = "course_sequence", sequenceName = "course_sequence", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_sequence")

  private Long id;
  private String name;
  private String code;

  public Course() {
  }

  public Course(String name, String code) {
    this.name = name;
    this.code = code;
  }

  public String getName() {
    return this.name;
  }

  public String getCode() {
    return this.code;
  }

  public Long getId() {
    return this.id;
  }

  public String setName(String name) {
    return this.name = name;
  }

  public String setCode(String code) {
    return this.code = code;
  }
}
