package com.github.aguinaldoNetoDev.course.business;

import com.github.aguinaldoNetoDev.course.service.CourseService;
import com.github.aguinaldoNetoDev.course.service.stubs.CourseServiceStub;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class CourseBusinessStubTest {

    @Test
    void testRetriveCoursesRelatedToSpring_when_usingStub() {
        //Given - Arrange
        CourseService stubService = new CourseServiceStub();
        CourseBusiness business = new CourseBusiness(stubService);

        //When - Act
        List<String> filteredCourses = business.retriveCoursesRelatedToSpring("Aguinaldo");

        //Then - Assert
        Assertions.assertEquals(4, filteredCourses.size());
    }
}