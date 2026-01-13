package com.github.aguinaldoNetoDev.course.business;

import com.github.aguinaldoNetoDev.course.service.CourseService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

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
}