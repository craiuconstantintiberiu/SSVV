package repository;

import domain.Student;
import org.junit.jupiter.api.Test;
import validation.StudentValidator;
import validation.ValidationException;

import static org.junit.jupiter.api.Assertions.*;


class StudentRepositoryTest {
    StudentRepository studentRepo = new StudentRepository(new StudentValidator());

    @Test
    void testValidateIDLessThan111() {
        Student student = new Student("asdas","asdasd",110);
        assertNull(studentRepo.save(student));
    }

    @Test
    void testValidateIDGreaterThan937() {
        Student student = new Student("asdas","asdasd",938);
        assertNull(studentRepo.save(student));
    }

    @Test
    void testValidateID() {
        Student student = new Student("asdas","asdasd",456);
        assertNull(studentRepo.save(student));
        assertTrue(studentRepo.entities.containsKey("asdas"));
    }

}