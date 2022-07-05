package com.sti.apisti.course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/course")
public class CourseController {
  private CourseService courseService;

  @Autowired
  public CourseController(CourseService courseService) {
    this.courseService = courseService;
  }

  @GetMapping
  public List<Course> getCourses() {
    return this.courseService.getCourses();
  }

  @PostMapping
  public void addCourse(@RequestBody Course course) {
    this.courseService.addCourse(course);
  }

  @DeleteMapping(path = "{courseId}")
  public void deleteCourse(@PathVariable("courseId") Long courseId) {
    this.courseService.deleteCourse(courseId);
  }

  @PutMapping(path = "{courseId}")
  public void updateCourse(
      @PathVariable("courseId") Long courseId,
      @RequestParam(required = false) String name,
      @RequestParam(required = false) String code) {

    this.courseService.updateCourse(courseId, name, code);
  }
}
