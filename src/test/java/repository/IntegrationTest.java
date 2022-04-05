package repository;

import domain.Nota;
import domain.Pair;
import domain.Student;
import domain.Tema;
import org.junit.jupiter.api.Test;
import validation.NotaValidator;
import validation.StudentValidator;
import validation.TemaValidator;

import static org.junit.jupiter.api.Assertions.*;

public class IntegrationTest {

    NotaRepository notaRepository = new NotaRepository(new NotaValidator());
    TemaRepository temaRepository = new TemaRepository(new TemaValidator());
    StudentRepository studentRepo = new StudentRepository(new StudentValidator());

    @Test
    void addNotavalid() {
        Nota entity = new Nota(new Pair<>("id", "id"), 2, 10, "bad");
        Nota result = notaRepository.save(entity);
        assertNull(result);
        assertEquals(entity, notaRepository.entities.get(new Pair<>("id", "id")));

    }

    @Test
    void addTemaValid() {
        Tema entity = new Tema("id", "descriere", 10, 8);
        Tema result = temaRepository.save(entity);
        assertNull(result);
        assertEquals(entity, temaRepository.entities.get("id"));
    }

    @Test
    void addStudentValid() {
        Student student = new Student("id","name",112);
        assertNull(studentRepo.save(student));
        assertEquals(student, studentRepo.entities.get("id"));
    }

    @Test
    void addEachEntity(){
        Tema entity = new Tema("id", "descriere", 10, 8);
        Tema temaResult = temaRepository.save(entity);

        Student student = new Student("id","name",112);
        Student studentResult = studentRepo.save(student);

        Nota nota = new Nota(new Pair<>("id", "id"), 2, 10, "bad");
        Nota notaResult = notaRepository.save(nota);


        assertNull(temaResult);
        assertEquals(entity, temaRepository.entities.get("id"));

        assertNull(studentResult);
        assertEquals(student, studentRepo.entities.get("id"));

        assertNull(notaResult);
        assertEquals(nota, notaRepository.entities.get(new Pair<>("id", "id")));
    }

}
