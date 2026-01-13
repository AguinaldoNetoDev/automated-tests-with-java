package com.github.aguinaldoNetoDev.course.business;

import com.github.aguinaldoNetoDev.course.service.CourseService;

import java.util.ArrayList;
import java.util.List;

//CourseBusiness = STU - SYSTEM/METHOD UNDER TEST
public class CourseBusiness {

    //Course is a dependency
    private final CourseService service;

    public CourseBusiness(CourseService service) {
        this.service = service;
    }

    public List<String> retriveCoursesRelatedToSpring(String student) {
        var filteredCourses = new ArrayList<String>();

        if ("Foo bar".equals(student)) return filteredCourses;

        var allCourses = service.retrieveCourses(student);

        for (String course: allCourses) {
            if (course.contains("Spring")) {
                filteredCourses.add(course);
            }
        }

        return filteredCourses;
    }
}
