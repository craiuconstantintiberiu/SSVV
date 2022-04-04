package repository;

import domain.Tema;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import validation.StudentValidator;
import validation.TemaValidator;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class TemaRepositoryTest {

    TemaRepository temaRepository = new TemaRepository(new TemaValidator());

    @Test
    void addTemaValid() {
        Tema entity = new Tema("id", "descriere", 10, 8);
        Tema result = temaRepository.save(entity);
        assertNull(result);
        assertEquals(entity, temaRepository.entities.get("id"));
    }

    @Test
    void add2TemaValidSameId() {
        Tema entity = new Tema("id", "descriere", 10, 8);
        Tema entity2 = new Tema("id", "descriere", 10, 5);
        temaRepository.save(entity);
        Tema result = temaRepository.save(entity2);
        assertEquals(entity, result);
        assertEquals(entity2, temaRepository.entities.get("id"));
    }

    @ParameterizedTest(name = "{index} => id={0}, descriere={1}, deadline={2}, startline={3}")
    @MethodSource("temaProvider")
    void addTemaInvalidNullReturnedEntitiesEmpty(String id, String descriere, int deadline, int startline) {
        Tema entity = new Tema(id, descriere, deadline, startline);
        Tema result = temaRepository.save(entity);
        assertNull(result);
        assertTrue(temaRepository.entities.isEmpty());
    }

    private static Stream<Arguments> temaProvider() {
        return Stream.of(
                Arguments.of(null, null, 0, 0),
                Arguments.of("", null, 0, 0),
                Arguments.of("id", null, 0, 0),
                Arguments.of("id", "", 0, 0),
                Arguments.of("id", "descriere", 0, 0),
                Arguments.of("id", "descriere", 15, 0),
                Arguments.of("id", "descriere", 3, 5),
                Arguments.of("id", "descriere", 10, 0)
        );
    }

}
