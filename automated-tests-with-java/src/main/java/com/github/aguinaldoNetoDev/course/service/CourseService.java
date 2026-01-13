package com.github.aguinaldoNetoDev.course.service;

import java.util.List;

public interface CourseService {

    public List<String> retrieveCourses(String student);

    List<String> doSomething(String student);
}
