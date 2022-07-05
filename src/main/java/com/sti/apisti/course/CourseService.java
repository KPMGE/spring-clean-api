package com.sti.apisti.course;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
  private CourseRepository courseRepository;

  @Autowired
  public CourseService(CourseRepository courseRepository) {
    this.courseRepository = courseRepository;
  }

  public List<Course> getCourses() {
    return this.courseRepository.findAll();
  }

  public void addCourse(Course course) {
    this.courseRepository.save(course);
  }

  public void deleteCourse(Long courseId) {
    boolean courseExists = this.courseRepository.existsById(courseId);

    if (!courseExists) {
      throw new Error("courseId does not exist");
    }

    this.courseRepository.deleteById(courseId);
  }

  @Transactional
  public void updateCourse(Long courseId, String newName, String newCode) {
    Course foundCourse = this.courseRepository.findById(courseId).orElseThrow();

    if (newName != null)
      foundCourse.setName(newName);

    if (newCode != null)
      foundCourse.setCode(newCode);
  }
}
