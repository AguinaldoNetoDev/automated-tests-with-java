package com.github.aguinaldoNetoDev.course.business;

import com.github.aguinaldoNetoDev.course.service.CourseService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.BDDMockito;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;

class CourseBusinessMockTest {

    CourseService mockService;
    CourseBusiness business;
    List<String> courses;

    @BeforeEach
    void setup() {
        //Given - Arrange
        mockService = Mockito.mock(CourseService.class);
        business = new CourseBusiness(mockService);

        courses = Arrays.asList(
                "REST API's RESTFul do 0 à Azure com ASP.NET Core 5 e Docker",
                "Agile Desmistificado com Scrum, XP, Kanban e Trello",
                "Spotify Engineering Culture Desmistificado",
                "REST API's RESTFul do 0 à AWS com Spring Boot 3 Java e Docker",
                "Docker do Zero à Maestria - Contêinerização Desmistificada",
                "Docker para Amazon AWS Implante Apps Java e .NET com Travis CI",
                "Microsserviços do 0 com Spring Cloud, Spring Boot e Docker",
                "Arquitetura de Microsserviços do 0 com ASP.NET, .NET 6 e C#",
                "REST API's RESTFul do 0 à AWS com Spring Boot 3 Kotlin e Docker",
                "Kotlin para DEV's Java: Aprenda a Linguagem Padrão do Android",
                "Microsserviços do 0 com Spring Cloud, Kotlin e Docker"
        );
    }


    @Test
    void testRetriveCoursesRelatedToSpring_when_usingMock() {
        //Given - Arrange
        Mockito.when(mockService.retrieveCourses("Aguinaldo")).thenReturn(courses);

        //When - Act
        List<String> filteredCourses = business.retriveCoursesRelatedToSpring("Aguinaldo");

        //Then - Assert
        Assertions.assertEquals(4, filteredCourses.size());
    }

    @Test
    void testDeleteCoursesNotRelatedToSpring_when_usingMockitoVerify_shouldCallMethodDeleteCourses() {
        //Given - Arrange
        Mockito.when(mockService.retrieveCourses("Aguinaldo")).thenReturn(courses);

        //When - Act
        business.deleteCoursesNotRelatedToSpring("Aguinaldo");

        //Then - Assert
        Mockito.verify(mockService, Mockito.times(1)).deleteCourse("Kotlin para DEV's Java: Aprenda a Linguagem Padrão do Android");
        Mockito.verify(mockService, never()).deleteCourse("Microsserviços do 0 com Spring Cloud, Kotlin e Docker");
    }

    @Test
    void testDeleteCoursesNotRelatedToSpring_when_usingMockitoVerifyV2_shouldCallMethodDeleteCourses() {
        //Given - Arrange
        BDDMockito.given(mockService.retrieveCourses("Aguinaldo")).willReturn(courses);

        String kotlinCourse = "Kotlin para DEV's Java: Aprenda a Linguagem Padrão do Android";
        String springCourse = "Microsserviços do 0 com Spring Cloud, Kotlin e Docker";

        //When - Act
        business.deleteCoursesNotRelatedToSpring("Aguinaldo");

        //Then - Assert
        BDDMockito.then(mockService)
                .should(times(1))
                .deleteCourse(kotlinCourse);

        BDDMockito.then(mockService)
                .should(never())
                .deleteCourse(springCourse);
    }

    @Test
    void testDeleteCoursesNotRelatedToSpring_when_capturingArguments_shouldCallMethodDeleteCourses() {
        //Given - Arrange

        courses = Arrays.asList(
                "REST API's RESTFul do 0 à AWS com Spring Boot 3 Kotlin e Docker",
                "Kotlin para DEV's Java: Aprenda a Linguagem Padrão do Android"
        );

        BDDMockito.given(mockService.retrieveCourses("Aguinaldo")).willReturn(courses);

        ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);

        String kotlinCourse = "Kotlin para DEV's Java: Aprenda a Linguagem Padrão do Android";

        //When - Act
        business.deleteCoursesNotRelatedToSpring("Aguinaldo");

        //Then - Assert
        BDDMockito.then(mockService)
                .should(times(1))
                .deleteCourse(argumentCaptor.capture());

        assertThat(argumentCaptor.getValue(), is(kotlinCourse));
    }

    @Test
    void testDeleteCoursesNotRelatedToSpring_when_capturingAListArguments_shouldCallMethodDeleteCourses() {
        //Given - Arrange
        BDDMockito.given(mockService.retrieveCourses("Aguinaldo")).willReturn(courses);

        ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);

        //When - Act
        business.deleteCoursesNotRelatedToSpring("Aguinaldo");

        //Then - Assert
        BDDMockito.then(mockService)
                .should(times(7))
                .deleteCourse(argumentCaptor.capture());

        assertThat(argumentCaptor.getAllValues().size(), is(7));
    }
}