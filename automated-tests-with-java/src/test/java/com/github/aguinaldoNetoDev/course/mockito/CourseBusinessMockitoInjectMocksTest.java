package com.github.aguinaldoNetoDev.course.mockito;

import com.github.aguinaldoNetoDev.course.business.CourseBusiness;
import com.github.aguinaldoNetoDev.course.service.CourseService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
class CourseBusinessMockitoInjectMocksTest {

    @InjectMocks
    CourseBusiness business;

    @Mock
    CourseService mockService;

    @Captor
    ArgumentCaptor<String> argumentCaptor;

    List<String> courses;

    @BeforeEach
    void setup() {
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
        BDDMockito.given(mockService.retrieveCourses("Aguinaldo")).willReturn(courses);

        //When - Act
        List<String> filteredCourses = business.retriveCoursesRelatedToSpring("Aguinaldo");

        //Then - Assert
        assertThat(filteredCourses.size(), is(4));
    }

    @Test
    void testDeleteCoursesNotRelatedToSpring_when_capturingAListArguments_shouldCallMethodDeleteCourses() {
        //Given - Arrange
        BDDMockito.given(mockService.retrieveCourses("Aguinaldo")).willReturn(courses);

        //When - Act
        business.deleteCoursesNotRelatedToSpring("Aguinaldo");

        //Then - Assert
        BDDMockito.then(mockService)
                .should(times(7))
                .deleteCourse(argumentCaptor.capture());

        assertThat(argumentCaptor.getAllValues().size(), is(7));
    }
}