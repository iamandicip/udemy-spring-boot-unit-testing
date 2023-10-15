package com.luv2code.component;

import com.luv2code.component.models.CollegeStudent;
import com.luv2code.component.models.StudentGrades;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = MvcTestingExampleApplication.class)
public class ApplicationExampleTest {

    private static int count = 0;

    @Value("${info.app.name}")
    private String appName;

    @Value("${info.app.description}")
    private String appDescription;

    @Value("${info.app.version}")
    private String appVersion;

    @Value("${info.school.name}")
    private String schoolName;

    @Autowired
    CollegeStudent student;

    @Autowired
    StudentGrades studentGrades;

    @Autowired
    ApplicationContext applicationContext;


    @BeforeEach
    public void beforeEach() {
        count = count + 1;
        System.out.println("Testing " + appName + " which is " + appDescription
                + "! Version " + appVersion
                + ". Execution test count: " + count);

        student.setFirstname("Eric");
        student.setLastname("Roby");
        student.setEmailAddress("eric@luv2code.com");
        studentGrades.setMathGradeResults(Arrays.asList(100.0, 85.0, 76.50, 91.75));
        student.setStudentGrades(studentGrades);
    }

    @Test
    @DisplayName("Add grade results for student grades")
    void addGradeResultsForStudentGrades() {
        assertEquals(353.25, studentGrades.addGradeResultsForSingleClass(
                student.getStudentGrades().getMathGradeResults()
        ));
    }

    @Test
    @DisplayName("Add grade results for student grades not equals")
    void addGradeResultsForStudentGradesNotEquals() {
        assertNotEquals(0, studentGrades.addGradeResultsForSingleClass(
                student.getStudentGrades().getMathGradeResults()
        ));
    }

    @Test
    @DisplayName("Is grade greater")
    void isGradeGreaterStudentGrades() {
        assertTrue(studentGrades.isGradeGreater(90, 75));
    }

    @Test
    @DisplayName("Is grade greater false")
    void isGradeGreaterStudentGradesFalse() {
        assertFalse(studentGrades.isGradeGreater(88, 92));
    }

    @Test
    @DisplayName("Check null for student grades")
    void checkNullForStudentGrades() {
        assertNotNull(student.getStudentGrades().getMathGradeResults());
    }

    @DisplayName("Create student without grade init")
    @Test
    void createStudentWithoutGradesInit() {
        CollegeStudent studentTwo = applicationContext.getBean("collegeStudent", CollegeStudent.class);
        studentTwo.setFirstname("Chad");
        studentTwo.setLastname("Darby");
        studentTwo.setEmailAddress("chad@luv2code.com");
        assertNotNull(studentTwo.getFirstname());
        assertNotNull(studentTwo.getLastname());
        assertNotNull(studentTwo.getEmailAddress());
        assertNull(studentGrades.checkNull(studentTwo.getStudentGrades()));
    }

    @DisplayName("Verify students are prototypes")
    @Test
    void verifyStudentsArePrototypes() {
        CollegeStudent studentTwo = applicationContext.getBean("collegeStudent", CollegeStudent.class);
        assertNotSame(student, studentTwo);
    }

    @DisplayName("Find grade point average")
    @Test
    void findGradePointAverage() {
        assertAll("Testing all assert equals",
                () -> assertEquals(353.25,
                        studentGrades.addGradeResultsForSingleClass(student.getStudentGrades().getMathGradeResults())),
                () -> assertEquals(88.31,
                        studentGrades.findGradePointAverage(student.getStudentGrades().getMathGradeResults()))
        );
    }
}
