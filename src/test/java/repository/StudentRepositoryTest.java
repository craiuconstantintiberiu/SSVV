package repository;

import domain.Student;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import validation.StudentValidator;
import validation.ValidationException;

import static org.junit.jupiter.api.Assertions.*;


class StudentRepositoryTest {
    StudentRepository studentRepo = new StudentRepository(new StudentValidator());

    @Test
    void testValidateDuplicateId() {
        Student student = new Student("id","name",112);
        Student student2 = new Student("id","name2",113);
        assertNull(studentRepo.save(student));
        assertEquals(student,studentRepo.save(student2));
        Student studentFound=studentRepo.entities.get("id");
        assertEquals(studentFound,student);
    }

    @Test
    void testValidateGrupa112() {
        Student student = new Student("id","name",112);
        assertNull(studentRepo.save(student));
        assertTrue(studentRepo.entities.containsKey("id"));
    }

    @Test
    void testValidateGrupa111() {
        Student student = new Student("id","name",111);
        assertNull(studentRepo.save(student));
        assertTrue(studentRepo.entities.containsKey("id"));
    }

    @Test
    void testValidateGrupa110() {
        Student student = new Student("id","name",110);
        assertNull(studentRepo.save(student));
        assertFalse(studentRepo.entities.containsKey("id"));
    }

    @Test
    void testValidateGrupa937() {
        Student student = new Student("id","name",937);
        assertNull(studentRepo.save(student));
        assertTrue(studentRepo.entities.containsKey("id"));
    }

    @Test
    void testValidateGrupa938() {
        Student student = new Student("id","name",938);
        assertNull(studentRepo.save(student));
        assertFalse(studentRepo.entities.containsKey("id"));
    }

    @Test
    void testValidateGrupa936() {
        Student student = new Student("id","name",936);
        assertNull(studentRepo.save(student));
        assertTrue(studentRepo.entities.containsKey("id"));
    }

    @Test
    void testValidateIdNull() {
        Student student = new Student(null,"name",455);
        assertNull(studentRepo.save(student));
        assertFalse(studentRepo.entities.containsKey(null));
    }

    @Test
    void testValidateIdEmpty() {
        Student student = new Student("","name",455);
        assertNull(studentRepo.save(student));
        assertFalse(studentRepo.entities.containsKey(null));
    }

    @Test
    void testValidateId() {
        Student student = new Student("id","name",455);
        assertNull(studentRepo.save(student));
        assertTrue(studentRepo.entities.containsKey("id"));
    }

    @Test
    void testValidateNameNull() {
        Student student = new Student("id",null,455);
        assertNull(studentRepo.save(student));
        assertFalse(studentRepo.entities.containsKey("id"));
    }

    @Test
    void testValidateNameEmpty() {
        Student student = new Student("id","",455);
        assertNull(studentRepo.save(student));
        assertFalse(studentRepo.entities.containsKey("id"));
    }

    @Test
    void testValidateName() {
        Student student = new Student("id","name",455);
        assertNull(studentRepo.save(student));
        assertTrue(studentRepo.entities.containsKey("id"));
    }

    //id-null
    //id-empty
    //id-not empty

    //nume-null
    //nume-empty
    //nume-not empty

    //grupa-109,110,111
    //grupa-937,938,939



}